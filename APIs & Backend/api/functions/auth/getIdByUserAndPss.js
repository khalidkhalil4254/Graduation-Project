//importing/requiring ===> dependencies/modules:
const response = require('./common/responses');
const config=require('./common/config');
const mysql = require("mysql");


module.exports.handler=async(event,callback,context)=>{
    //extracting user information from the http-request-body sent from DesktopApp:
    const username = event.queryStringParameters.USERNAME;
    const password = event.queryStringParameters.PASSWORD;


    console.log(`username: ${username}, pass: ${password}`)

    //crud operations=>(create,read ,update ,delete)

    //creating DB connection pool:
    const pool = mysql.createPool({
        host: config.conf.db_host,
        user: config.conf.db_username,
        password: config.conf.db_password,
        database: config.conf.db_name
      });

      const query = `select ID from Authentication where username='${username}' and user_pass='${password}';`;
    const newUser = {};


    const results = await new Promise((resolve, reject) => {
        pool.query(query, newUser, (error, results, fields) => {
            if (error) {
                console.error(error);
                reject(results);
            }else{
                console.log('User found in database.');
                resolve(results);
            }
    
        });
      });

      // Close the connection pool
      pool.end();

      if(results.length!=0){
        const id = results[0].ID;
        console.log(`ID: ${id}`);
        // Return the ID value as (200) if found!
        return {
            statusCode:200,
            body:JSON.stringify(id)
        };
    }
    else{
        console.log('User not found in database.');
        // Return the results as JSON as (404) if not found!
        return response._404;
    }


};