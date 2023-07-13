const res = require('./common/responses');
const config = require('./common/config');
const mysql = require('mysql');

module.exports.handler=async(event, context, callback)=>{


    console.log(`Connecting to db...`);

    //creating database connections:
    const connectionPool = mysql.createPool({
        host: config.conf.db_host,
        user: config.conf.db_username,
        password: config.conf.db_password,
        database: config.conf.db_name,
    });



    console.log(`Connected to db...`);

    const query = `select * from sessions;`;
    const item={}

    const results = await new Promise((resolve, reject) => {
      connectionPool.query(query,item ,(error, results, fields) => {
            if (error) {
                console.error(error);
                reject(results);
            }else{
                console.log('Reading the found items from the table...');
                resolve(results);
            }
    
        });
      });

      // Close the connection pool
      connectionPool.end();


      if(results.length>0){
        console.log(`Result: ${results}`);
        return {
          statusCode:200,
          body: JSON.stringify({
            message: results
          })
        };
      }

      else{
        console.log(`Not found any resources!`);
        return res._404;
      }


}