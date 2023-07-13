# SES Smart Exhibition System

SES is a simple cloud application developed alongside the Graduation Project. It allows users to register and signup/log into a Desktop .Net App and Android App, Managing/organizing and Monitoring the Exhibition using microservice based restAPIs.

The project is split into Four parts:
1. Frontend:
   - .NET Desktop App.
   - Android Kotlin App.
2. Backend RESTful API - AWS Lambda NodeJS applications.
3. Embedded:
   - QRCODE Module.
   - RFID Module.
   - Ligting Control Module.
  

## Getting Started
> _tip_: it's recommended that you start with getting the backend APIs running since the frontend Android & .NET Desktop App depends on the APIs.


### Prerequisite
1. The depends on the Node Package Manager (NPM). You will need to download and install Node from [https://nodejs.com/en/download](https://nodejs.org/en/download/). This will allow you to be able to run `npm` commands.
2. Environment variables will need to be set. These environment variables include database connection details that should not be hard-coded into the application code.


#### Environment Script
A file named `config.js` in `common` Folder has been prepared as an optional tool to help you configure these variables on your local development environment.
 
We do _not_ want your credentials to be stored in git. After pulling this `starter` project, run the following command to tell git to stop tracking the script in git but keep it stored locally. This way, you can use the script for your convenience and reduce risk of exposing your credentials.
`git rm --cached config.js`

Afterwards, we can prevent the file from being included in your solution by adding the file to our `.gitignore` file.


### 1. Database
Create a MySQL database either locally or on AWS RDS. The database is used to store the application's metadata.

* We will need to use password authentication for this project. This means that a username and password is needed to authenticate and access the database.
* The port number will need to be set as `3306`. This is the typical port that is used by MySQL so it is usually set to this port by default.

Once your database is set up, set the config values for environment variables prefixed with `DB_` in `config.js`.
* If you set up a local database, your `DB_HOST` is most likely `localhost`
* If you set up an RDS database, your `DB_HOST` is most likely in the following format: `***.****.us-west-1.rds.amazonaws.com`. You can find this value in the AWS console's RDS dashboard.


### 2. S3
Create an AWS S3 bucket. The S3 bucket is used to store Log Files that can be displayed in Desktop App (In Future Development).

Set the config values for environment variables prefixed with `Bucket_Params` in `createLog.js`.


### 3. Backend API
Launch the backend API locally. The API is the application's interface to S3 and the database.

* To download all the package dependencies, run the command from the directory `api/`:
    ```bash
    npm install .
    ```
* To deploy and run all of the applications, run:
    ```bash
    npm run deployAll
    ```
* To remove and delete all of the applications, run:
    ```bash
    npm run removeAll
    ```
* To get details and information about deployed applications, run:
    ```bash
    npm run infoAll
    ```


### 4. Frontend App
Launch the frontend (.NET Desktop App & Android App) locally as Normal.
* Install APK for running the Android App and Open (EXE) of .Net Desktop App to run the management Application:
