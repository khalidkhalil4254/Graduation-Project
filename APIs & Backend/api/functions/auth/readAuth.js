//importing/requiring ===> dependencies/modules:
const response = require('./common/responses');
const config=require('./common/config');
const mysql = require("mysql");


module.exports.handler=async(event,callback,context)=>{
    //extracting user information from the http-request-body sent from DesktopApp:

        const requestBody = JSON.parse(event.body);

        console.log(requestBody)
    
        const username = requestBody['USERNAME'];
        const password = requestBody['PASSWORD'];
    
        console.log(`Username: ${username} ,Password: ${password}`);
    
        //crud operations=>(create,read ,update ,delete)
    
        //creating DB connection pool:
        const pool = mysql.createPool({
            host: config.conf.db_host,
            user: config.conf.db_username,
            password: config.conf.db_password,
            database: config.conf.db_name
          });
    
        const query = `select * from Authentication where username='${username}' and user_pass='${password}';`;
    
    
        const results = await new Promise((resolve, reject) => {
            pool.query(query, (error, results, fields) => {
                if (error) {
                    console.error(error);
                    reject(results);
                }else{
                    console.log('A user found!');
                    resolve(results);
                }
        
            });
          });
    
          // Close the connection pool
          pool.end();
    
        if(results.length!=0){
            //console.log(`OK=>Results:${results}`);
            // Format the results as JSON
            const json_results = JSON.stringify(results);
            console.log(json_results);
            // Return the results as JSON as (200) if found!
            return response._200;
        }
        else{
            //console.log(`FAIL=>Results:${results}`);
            // Format the results as JSON
            const json_results = JSON.stringify(results);
            console.log(json_results);
            // Return the results as JSON as (404) if not found!
            return response._404;


};

}