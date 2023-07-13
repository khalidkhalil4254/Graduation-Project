//Welcome to E for Engineer---SUBSCRIBE Now
#include "ThingSpeak.h"
#include <ESP8266WiFi.h>


//defining names of variables will be used:
#define d0 16
#define d1 5
#define d2 4
#define d3 0
#define d4 2



//Replace your wifi credentials here
const char* ssid     = "Etisalat 4G iModem-DA98";//Replace with your Wifi Name
const char* password = "02463488";// Replace with your wifi Password

//change your channel number here
unsigned long channel = 2214768;//Replace with your own ThingSpeak Account Channle ID

//1,2 and 3 are channel fields. You don't need to change if you are following this tutorial. However, you can modify it according to your application
unsigned int led1 = 1;
unsigned int led2 = 2;
unsigned int led3 = 3;
unsigned int led4 = 4;
unsigned int led5 = 5;

WiFiClient  client;


void setup() {
  Serial.begin(9600);
  delay(100);
  
  pinMode(d0, OUTPUT);
  pinMode(d1, OUTPUT);
  pinMode(d2, OUTPUT);
  pinMode(d3, OUTPUT);
  pinMode(d4, OUTPUT);
  digitalWrite(d0, 0);
  digitalWrite(d1, 0);
  digitalWrite(d2, 0);
  digitalWrite(d3, 0);
  digitalWrite(d4, 0);
  // We start by connecting to a WiFi network
 
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
  
  WiFi.begin(ssid, password);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
 
  Serial.println("");
  Serial.println("WiFi connected");  
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  Serial.print("Netmask: ");
  Serial.println(WiFi.subnetMask());
  Serial.print("Gateway: ");
  Serial.println(WiFi.gatewayIP());
  ThingSpeak.begin(client);

}

void loop() {
 
  //get the last data of the fields from thingspeak:
  int led_1 = ThingSpeak.readFloatField(channel, led1);
  int led_2 = ThingSpeak.readFloatField(channel, led2);
  int led_3 = ThingSpeak.readFloatField(channel, led3);
  int led_4 = ThingSpeak.readFloatField(channel, led4);
  int led_5 = ThingSpeak.readFloatField(channel, led5);
 
  if(led_1 == 1){
    digitalWrite(d0, 1);
    Serial.println("D1 is On..!");
  }
  else if(led_1 == 0){
    digitalWrite(d0, 0);
    Serial.println("D1 is Off..!");
  }
 
  if(led_2 == 1){
    digitalWrite(d1, 1);
    Serial.println("D2 is On..!");
  }
  else if(led_2 == 0){
    digitalWrite(d1, 0);
    Serial.println("D2 is Off..!");
  }
 
  if(led_3 == 1){
    digitalWrite(d2, 1);
    Serial.println("D3 is On..!");
  }
  else if(led_3 == 0){
    digitalWrite(d2, 0);
    Serial.println("D3 is Off..!");
  }

    if(led_4 == 1){
    digitalWrite(d3, 1);
    Serial.println("D4 is On..!");
  }
  else if(led_4 == 0){
    digitalWrite(d3, 0);
    Serial.println("D4 is Off..!");
  }

  if(led_5 == 1){
    digitalWrite(d4, 1);
    Serial.println("D5 is On..!");
  }
  else if(led_5 == 0){
    digitalWrite(d4, 0);
    Serial.println("D5 is Off..!");
  }
  
    
  //printing the LEDs status:
  Serial.println(led_1);
  Serial.println(led_2);
  Serial.println(led_3);
  Serial.println(led_4);
  Serial.println(led_5);

  //waiting some time for the requests:
  delay(5000);
 
}