const res = require('./common/responses');
const config = require('./common/config');
const mysql = require('mysql');

module.exports.handler = async(event, context, callback)=>{

    const data = JSON.parse(event.body);
    const speaker = data.speaker;
    const title = data.title;
    const company = data.company;
    const startTime = data.startTime;
    const endTime = data.endTime;


    console.log(`Data: ${data}`);

    //creating database connections:
    const connectionPool = mysql.createPool({
        host: config.conf.db_host,
        user: config.conf.db_username,
        password: config.conf.db_password,
        database: config.conf.db_name,
    });


    const newSessionDetails = {
        speaker,
        title,
        company,
        startTime,
        endTime
    }


    const query = `INSERT INTO sessions(session_speaker ,session_title ,session_company ,session_start_time ,session_end_time ) VALUES ('${speaker}','${title}','${company}','${startTime}','${endTime}');`;


    const results = await new Promise((resolve, reject) => {
        connectionPool.query(query, newSessionDetails, (error, results, fields) => {
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

      console.log(`Result: ${results}`);
      

      if(results!=null || results.length!=0){
        console.log(`Result: ${results}`);
        return res._200;
      }


      else{
        console.log(`Not created any resources!`);
        return res._409;
      }


}