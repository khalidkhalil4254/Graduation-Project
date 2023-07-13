const nodemailer = require('nodemailer');

module.exports.handler = async(event)=>{

    const reqBody = JSON.parse(event.body);
    const from_email = reqBody.FROM;
    const to_email = reqBody.TO; 
    const email_subject = reqBody.SUBJECT;
    const email_txt = reqBody.TEXT;

    console.log(`sender:${from_email}\nreceiver:${to_email}\nsubject:${email_subject}\ntext:${email_txt}`);

    try {
        //initializing and creating transporter of an email: 
        const transporter = nodemailer.createTransport({
            service:"gmail",
            port: 465,
            secure: true, // true for 465, false for other ports
            auth:{
                user: process.env.MY_EMAIL,
                pass: process.env.MY_EMAIL_PASSWORD
            }
        });
        //---------@TODO to be implemented (insert this mail into emails table in the database)---------



        
        //creating an email and sending it to a user:
        await transporter.sendMail({
            from: `${from_email}`,
            to: `${to_email}`,
            subject: `${email_subject}`,
            text: `${email_txt}`
        });

        return {
            statusCode:201,
            body: JSON.stringify({message:`Email sent successfully!`})
        }

        } catch (error) {
            console.log(`Error: ${error}`);
            return {
                statusCode:401,
                body: JSON.stringify({message:`Email seding failure! ${error.toString()}`})
            }
        }
}