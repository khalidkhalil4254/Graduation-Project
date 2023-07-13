//importing wifi & https libraries:---------------------------------------
#include <ESP8266WiFi.h>
#include <WiFiClientSecure.h>
#include <ESP8266HTTPClient.h>
#include <Servo.h>
#include "certs.h"
#include <string.h>

Servo door;

// Replace with your network credentials
const char* ssid = "Vodafone_VDSL";
const char* password = "Kk01025975165@";

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

int getRequest(String path) {
  int result = -1;
  WiFiClientSecure client;

  // wait for WiFi connection
  if ((WiFi.status() == WL_CONNECTED)) {

    client.setTrustAnchors(&cert);

    HTTPClient https;

    Serial.println("[HTTPS] begin..." + String(api_host) + String(path));
    if (https.begin(client, String(api_host) + String(path))) {  // HTTPS

      Serial.print("[HTTPS] GET...\n");
      // start connection and send HTTP header
      int httpCode = https.GET();
      result = httpCode;

      // httpCode will be negative on error
      if (httpCode > 0) {
        // HTTP header has been sent and Server response header has been handled
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

//char toht[10];

void setup() {
  door.attach(16);
  door.write(0);

  //-----------------------------------------------------initialization of wifi and time required by https---------------------------------------------------------
  Serial.begin(9600);
  //Serial.setDebugOutput(true);

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

  if (Serial.available()) {
    // char arr[9];
    // Serial.readBytes(arr, 9);
    String data = Serial.readStringUntil('\t');
    Serial.println("Data:" + data);

    //check if the uer is existed or not?
    String path = "/api/v0/auth/getAuthById?ID=";
    path += data;

    Serial.println("Path: " + path);


    if ((getRequest(path)) == 200) {
      Serial.println("Door is On!");
      for (int i = 0; i <= 180; i++) {  // move from 0 to 180 degrees
        door.write(i);                  // send the angle to the servo
        delay(15);                      // wait for the servo to reach the angle
      }
      delay(5000);  //wait 3 seconds till turning it off
      Serial.println("Door is off!");
      for (int i = 180; i >= 0; i--) {  // move from 180 to 0 degrees
        door.write(i);                  // send the angle to the servo
        delay(15);                      // wait for the servo to reach the angle
      }

    } else {
    }
  }


  delay(500);
}
