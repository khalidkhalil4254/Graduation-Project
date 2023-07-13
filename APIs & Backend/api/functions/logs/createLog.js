const AWS = require('aws-sdk');
const s3 = new AWS.S3();

module.exports.handler=async(event,callback,context)=>{
  const data = JSON.parse(event.body);

  try{
    const bucketName = process.env.BUCKET_NAME;
    const fileName = process.env.FILE_NAME;
  
    // Read existing data from S3
    const s3Object = await s3.getObject({ Bucket: bucketName, Key: fileName }).promise();
    // Add new data to the existing data
    const date = new Date();
    console.log(`Storing Log:(${date},${date})....\nIn AWS-S3 bucket:${bucketName} and filename:${fileName}`);
  


    const existingData = s3Object.Body.toString('utf-8');
    const newData = `${date}, ${JSON.stringify(data)} \n`;
    const updatedData = `${existingData}\n${newData}`;

  
    // Write the updated data to S3
    await s3.putObject({
      Bucket: bucketName,
      Key: fileName,
      Body: updatedData,
    }).promise();
  }catch(err){
    console.log(err);
    //if captured an error:
    return {
      statusCode: 401,
      body: `Error: ${err}`,
    };
  }


  //if there is no error captured:
  return {
    statusCode: 201,
    body: 'Data added successfully',
  };


};