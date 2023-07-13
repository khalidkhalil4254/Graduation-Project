const res = require('./common/responses');
const config = require('./common/config');
const mysql = require('mysql');

module.exports.handler = async (event, context, callback) => {

    console.log(`Connecting to db...`);

    //creating database connections:
    const connectionPool = mysql.createPool({
        host: config.conf.db_host,
        user: config.conf.db_username,
        password: config.conf.db_password,
        database: config.conf.db_name,
    });

    console.log(`Connected to db...`);

    const query = `SELECT COUNT(*) FROM registeration;`;
    const item = {}

    const results = await new Promise((resolve, reject) => {
        connectionPool.query(query, item, (error, results, fields) => {
            if (error) {
                console.error(error);
                reject(results);
            } else {
                console.log('Reading the found items from the table...');
                resolve(results);
            }
        });
    });

    // Close the connection pool
    connectionPool.end();

    if (results.length != 0) {
        const count = results[0]['COUNT(*)'];
        console.log(`Count: ${count}`);
        // Return the count value as a number with (200) if found!
        return {
            statusCode: 200,
            body: count
        };
    } else {
        console.log('No rows found in database.');
        // Return the results as JSON with (404) if not found!
        return res._404;
    }
}