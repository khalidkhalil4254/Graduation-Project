#include <Arduino.h>
#include <ESP32QRCodeReader.h>
#include <HardwareSerial.h>

//QRCode-Reader Object:
ESP32QRCodeReader reader(CAMERA_MODEL_AI_THINKER);
struct QRCodeData qrCodeData;

void setup() {
  Serial.begin(9600);
  //------------------------------------------->QRCodeReader
  reader.setup();
  reader.beginOnCore(1);
}

void loop() {
  if (reader.receiveQrCode(&qrCodeData, 250)) {
    if (qrCodeData.valid) {
      // char arr[9]=(const char*) qrCodeData.payload;
      String qrCode_reading = (const char*) qrCodeData.payload;
      // Serial.println( (const char*) qrCodeData.payload);
      Serial.print( qrCode_reading+'\t');
      // Serial.write(qrCode_reading.c_str(), 9);
    } else {
    }
  }
  delay(250);
}