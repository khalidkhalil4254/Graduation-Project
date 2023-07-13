module.exports={
    _200:{
        statusCode:200,
        body:JSON.stringify({
          message:"ok!"  
        })
    },
    _201:{
        statusCode:201,
        body:JSON.stringify({
          message:"created!"  
        })
    },
    _204:{
        statusCode:204,
        body:JSON.stringify({
          message:"no content!"  
        })
    },
    _400:{
        statusCode:400,
        body:JSON.stringify({
          message:"bad request!"  
        })
    },
    _401:{
        statusCode:401,
        body:JSON.stringify({
          message:"Unauthorized!"  
        })
    },
    _404:{
        statusCode:404,
        body:JSON.stringify({
          message:"not found!"  
        })
    },
    _409:{
      statusCode:409,
      body: JSON.stringify({
        message:"Conflict!"
      })
    }
}