//importing/requiring ===> dependencies/modules:
const response = require('./common/responses');
const config=require('./common/config');
const mysql = require('mysql');

exports.handler = async (event) => {
  const rfid=event.queryStringParameters.uid;
  console.log("RFID:"+rfid);

  // Create a MySQL connection pool(a cache of db connections):
  const pool = mysql.createPool({
    host: config.conf.db_host,
    user: config.conf.db_username,
    password: config.conf.db_password,
    database: config.conf.db_name
  });

  // Execute the SQL query
  const query = `SELECT * FROM User where RFID=${rfid};`;
  const results = await new Promise((resolve, reject) => {
    pool.query(query, (error, results) => {
      if (error) {
        reject(error);
      } else {
        resolve(results);
      }
    });
  });

// Close the connection pool
pool.end();


  console.log(`Res: ${results}`);

  if(results.length!=0){
          // Format the results as JSON
          const json_results = JSON.stringify(results);
          // Return the results as JSON as (200) if found!
          return response._200;

  }else{
          // Format the results as JSON
          const json_results = JSON.stringify(results);
          // Return the results as JSON as (404) if not found!
          return response._404;
          
  }
}; 