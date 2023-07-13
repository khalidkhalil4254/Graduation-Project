// handler.js
'use strict';

module.exports.handler=async(event, context, callback)=>{
    return {
        statusCode:200,
        body: JSON.stringify({
            message: "Hello World!"
        }),
    }    
}