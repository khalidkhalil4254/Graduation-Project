const res = require('./common/responses');
const config = require('./common/config');
const mysql = require('mysql');

module.exports.handler = async(event, context, callback)=>{

    const data = JSON.parse(event.body);
    const combined_Key = data.KEY;
    const registeration_email = data.EMAIL;
    const registeration_company = data.COMPANY;


    console.log(`key:${combined_Key}, email:${registeration_email}, company: ${registeration_company}`);

    //creating database connections:
    const connectionPool = mysql.createPool({
        host: config.conf.db_host,
        user: config.conf.db_username,
        password: config.conf.db_password,
        database: config.conf.db_name,
    });


    const newSessionDetails = {}


    const query = `INSERT INTO registeration(combined_Key,registeration_email,registeration_company) VALUES ('${combined_Key}','${registeration_email}','${registeration_company}');`;


    const results = await new Promise((resolve, reject) => {
        connectionPool.query(query, newSessionDetails, (error, results, fields) => {
            if (error) {
                console.error(error);
                reject(results);
            }else{
                console.log('Registeration Created Successfully!');
                resolve(results);
            }
    
        });
      });

      // Close the connection pool
      connectionPool.end();
      

      if(results!=null || results.length!=0){
        console.log(`Created Successed!`);
        return res._200;
      }


      else{
        console.log(`Not created any resources!`);
        return res._409;
      }


}