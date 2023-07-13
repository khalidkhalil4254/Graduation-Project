const configuration=require('./config');
module.exports.DB_Connection={
    host: configuration.conf.db_host,
    user: configuration.conf.db_username,
    password: configuration.conf.db_password,
    database: configuration.conf.db_name
  }