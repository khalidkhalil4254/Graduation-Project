//1 main,2 lects, 2 Hall doors (important)  <==================**********
//importing RFID module & SPI protocol libraries:-----------------------------------
#include <SPI.h>
#include <MFRC522.h>
//importing wifi & https libraries:---------------------------------------
#include <ESP8266WiFi.h>
#include <WiFiClientSecure.h>
#include <ESP8266HTTPClient.h>
#include <Servo.h>
#include "certs.h"
//defining some important parameters & global variables:
#define SS_PIN 4                //D2
#define RST_PIN 5               //D1
MFRC522 rfid(SS_PIN, RST_PIN);  //constructing Instance of the class (crating object of the MFRC522 module to use in code)
MFRC522::MIFARE_Key key;        //creating key to Init array that will store new NUID
byte nuidPICC[4];
Servo door;

// Replace with your network credentials
const char* ssid = "WE_89BD2C";
const char* password = "jaf18144YouJOE@ T_a";

// Create a list of certificates with the server certificate
X509List cert(IRG_Root_X1);


//functions to establish specific WIFI connection:
int wifiConnect(const char* SSID, const char* PASSWORD) {
  WiFi.begin(SSID, PASSWORD);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  return 1;
}

int getRequest(String url, String path) {
  int result = -1;
  WiFiClientSecure client;

  // wait for WiFi connection
  if ((WiFi.status() == WL_CONNECTED)) {

    client.setTrustAnchors(&cert);

    HTTPClient https;

    Serial.println("[HTTPS] begin..." + url + path);
    if (https.begin(client, url + path)) {  // HTTPS

      Serial.print("[HTTPS] GET...\n");
      // start connection and send HTTP header
      int httpCode = https.GET();
      result = httpCode;

      // httpCode will be negative on error
      if (httpCode > 0) {
        // HTTP header has been send and Server response header has been handled
        Serial.printf("[HTTPS] GET... code: %d\n", httpCode);

        // file found at server
        if (httpCode == HTTP_CODE_OK || httpCode == HTTP_CODE_MOVED_PERMANENTLY) {
          String payload = https.getString();
          Serial.println(payload);
        }
      } else {
        Serial.printf("[HTTPS] GET... failed, error: %s\n", https.errorToString(httpCode).c_str());
      }

      https.end();
    } else {
      Serial.printf("[HTTPS] Unable to connect\n");
    }
  }
  return result;
}

//function to print the rfid as string and as number in decimal numeric system :
void printDec(byte* buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++) {
    Serial.println(buffer[i] < 0x10 ? " 0" : " ");
    Serial.println(buffer[i], DEC);
  }
}

//function to get the rfid as string and as number in decimal numeric system :
String get_rfid_dec(byte* buffer, byte bufferSize) {
  String result = "";
  for (byte i = 0; i < bufferSize; i++) {
    result += buffer[i] < 0x10 ? "0" : "";
    result += buffer[i];
  }
  return result;
}

void printHex(byte* buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++) {
    Serial.print(buffer[i] < 0x10 ? " 0" : " ");
    Serial.print(buffer[i], HEX);
  }
}

void setup() {
  door.attach(16);
  //---------------------------------------------------------------initializing SPI and RFID module communication-------------------------------------------------------------------------------
  SPI.begin();      // Init SPI bus
  rfid.PCD_Init();  // Init MFRC522
  Serial.println();
  Serial.print(F("Reader :"));
  //-------------------------------------------------
  rfid.PCD_DumpVersionToSerial();
  for (byte i = 0; i < 6; i++) {
    key.keyByte[i] = 0xFF;
  }
  //-------------------------------------------------
  Serial.println();
  Serial.println(F("This code scan the MIFARE Classic NUID."));
  Serial.print(F("Using the following key:"));
  printHex(key.keyByte, MFRC522::MF_KEY_SIZE);


  //-----------------------------------------------------initialization of wifi and time required by https---------------------------------------------------------
  Serial.begin(9600);
  //Serial.setDebugOutput(true);

  Serial.println();
  Serial.println();
  Serial.println();

  //Connect to Wi-Fi
  wifiConnect(ssid, password);

  // Set time via NTP, as required for x.509 validation
  configTime(3 * 3600, 0, "pool.ntp.org", "time.nist.gov");

  Serial.println("Waiting for NTP time sync: ");
  time_t now = time(nullptr);
  while (now < 8 * 3600 * 2) {
    delay(500);
    Serial.print(".");
    now = time(nullptr);
  }
  Serial.println("");
  struct tm timeinfo;
  gmtime_r(&now, &timeinfo);
  Serial.print("Current time: ");
  Serial.println(asctime(&timeinfo));
}

void loop() {
  // Reset the loop if no new card present on the sensor/reader. This saves the entire process when idle.
  //instead of using interrupts
  if (!rfid.PICC_IsNewCardPresent())
    return;
  // Verify if the NUID has been readed
  if (!rfid.PICC_ReadCardSerial())
    return;
  Serial.print(F("PICC type: "));
  MFRC522::PICC_Type piccType = rfid.PICC_GetType(rfid.uid.sak);
  Serial.println(rfid.PICC_GetTypeName(piccType));
  // Check if the PICC of Classic MIFARE type?
  if (piccType != MFRC522::PICC_TYPE_MIFARE_MINI && piccType != MFRC522::PICC_TYPE_MIFARE_1K && piccType != MFRC522::PICC_TYPE_MIFARE_4K) {
    Serial.println(F("Your tag is not of type MIFARE Classic."));
    return;
  }
  //check if the reading is new:
  if (rfid.uid.uidByte[0] != nuidPICC[0] || rfid.uid.uidByte[1] != nuidPICC[1] || rfid.uid.uidByte[2] != nuidPICC[2] || rfid.uid.uidByte[3] != nuidPICC[3]) {
    Serial.println(F("A new card has been detected."));
    // Store NUID into nuidPICC array
    for (byte i = 0; i < 4; i++) {
      nuidPICC[i] = rfid.uid.uidByte[i];
    }
    Serial.println(F("The NUID tag is:"));
    Serial.print(F("In dec: "));
    // printDec(rfid.uid.uidByte, rfid.uid.size);
    Serial.println("RFID read:" + get_rfid_dec(rfid.uid.uidByte, rfid.uid.size));
    //getting rfid as string and printing it:-------------------------@TODO=>to be implemented (get request to ensure user is existed)----------------------------------

    String path = "/api/v0/users/read?uid=" + get_rfid_dec(rfid.uid.uidByte, rfid.uid.size);
    //printing the results:

    //check if the uer is existed or not?
    if (getRequest(api_host, path) == 200) {


    Serial.println("Door is On!");
      for (int i = 260; i >= 80; i--) {  // move from 180 to 0 degrees
        door.write(i);                  // send the angle to the servo
        delay(2);                      // wait for the servo to reach the angle
      }

delay(5000);  //wait 3 seconds till turning it off

      Serial.println("Door is Off!");
      for (int i = 80; i <= 260; i++) {  // move from 0 to 180 degrees
        door.write(i);                  // send the angle to the servo
        delay(2);                      // wait for the servo to reach the angle
      }


  



    } else {
      // Serial.println("Door is off!");
      // digitalWrite(16, LOW); // turn the red LED on
      // delay(5000); //wait 3 seconds till turning it off
      // Serial.println("Door is on!");
      // digitalWrite(16, HIGH); // turn the red LED off
    }

    // -------------------------@TODO=>to be implemented (post request to add new log record in logs table)----------------------------------
    // Serial.println(postRequest(api_host,"/path",&cert));
  } else Serial.println(F("Card read previously."));
  // stop readings using RFID module:
  rfid.PICC_HaltA();
  // Stop encryption on PCD
  rfid.PCD_StopCrypto1();
}
