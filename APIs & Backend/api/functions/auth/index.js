// handler.js
'use strict';
 
module.exports.handler = async function (event, context, callback) {
 return{
    statusCode:200,
    body: JSON.stringify({
        message:"hello world!"
    }),
 };
};