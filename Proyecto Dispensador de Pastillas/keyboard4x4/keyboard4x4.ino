#include "Sodaq_DS3231.h"  //Se incluyen las librerías adecuadas para el proyecto
#include <Keypad.h>
#include <Wire.h>
#include <LiquidCrystal.h>
DateTime now;  // Se define una variable tipo DateTime para manejar el tiempo actual
uint32_t old_timeStamp; // el tiempo se va a manejar como un caracter de 32 bits
const int rs = 52, en = 53, d4 = 50, d5 = 51, d6 = 48, d7 = 49; // puertos donde está conectado el LCD
LiquidCrystal lcd(rs, en, d4, d5, d6, d7); // incializo el LCD
bool h12, PM;                                 //Se definen las variables
int horaA, horaB, minutA, minutB;             //
#define buz 46                                //    
int in1 = 11;                                 //  
const int PIRPin= 32;                         //    necesarias para  
int in2 = 12;
int in3 = 30;
int in4 = 31;
int ENA = 10;
int ENB = 13;
int ABS = 150;                                //   este proyecto
const byte ROWS = 4; //four rows        // Filas para el teclado 4x4
const byte COLS = 4; //threecolumns     // Columnas para el teclado 4x4
char keys[4][4] = {
    {'1','2','3','A'},
    {'4','5','6','B'},
    {'7','8','9','C'},
    {'*','0','#','D'}
  };                                    // Se define cómo está situado cada pulsador en el teclado
byte rowPins[ROWS] = {9,8,7,6};         // Pines a los que está conectado el teclado.
byte colPins[COLS] = {5,4,3,2};

Keypad keypad = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );  // Se inicializa el teclado

int alarmaA = 0;
int alarmaB = 0;
int A = 0;
int B = 0;

void ImprimirTiempo(){        //Método utilizado para imprimir el tiempo en el LCD
      now = rtc.now();
      uint32_t ts = now.getEpoch();
      if(old_timeStamp == 0 || old_timeStamp != ts){
      old_timeStamp = ts;
      lcd.setCursor(0,0);
      char misik[80];
      sprintf(misik, "Time: %02d:%02d:%02d", now.hour(), now.minute(), now.second());
      lcd.print(misik);
      }
  }

void BuzzerOn()       // Método utilizado para encender el buzzer
{
digitalWrite(buz,HIGH);
delay(500);
digitalWrite(buz, LOW);
delay(500);
}
 
void _mForwardA()     //manera de mover hacia adelante el motor de las pastillas A
{
 analogWrite(ENA,ABS);
 //analogWrite(ENB,ABS);
  digitalWrite(in1,HIGH);//digital output
  digitalWrite(in2,LOW);
}

void _mForwardB()     //manera de mover hacia adelante el motor de las pastillas B
{
 //analogWrite(ENA,ABS);
 analogWrite(ENB,ABS);
  digitalWrite(in3,HIGH);//digital output
  digitalWrite(in4,LOW);
}

void _mBackA()      //manera de mover hacia atrás el motor de las pastillas A
{
 analogWrite(ENA,ABS);
 //analogWrite(ENB,ABS);
  digitalWrite(in1,LOW);
  digitalWrite(in2,HIGH);
}

void _mBackB()      //manera de mover hacia atrás el motor de las pastillas B
{
 //analogWrite(ENA,ABS);
 analogWrite(ENB,ABS);
  digitalWrite(in3,LOW);
  digitalWrite(in4,HIGH);
}

void _mStop()  //Método usado para detener los motores
{
  digitalWrite(ENA,LOW);
  digitalWrite(ENB,LOW);
}

void setup() {
  Serial.begin(9600);
  pinMode(buz, OUTPUT);       //Aquí se inicializan todods los pines que son necesarios
  pinMode(in1,OUTPUT);
  pinMode(in2,OUTPUT);
  pinMode(in3, OUTPUT);
  pinMode(in4, OUTPUT);
  pinMode(ENA,OUTPUT);
  pinMode(ENB,OUTPUT);
  pinMode(PIRPin, INPUT);
  Wire.begin();
  rtc.begin();
  lcd.begin(16, 2);   //Se inicializa el LCD
  _mStop();
}
 
void loop(){
  int h2, h3, restaA, restaB, h4, h5, posA, posB;     //Variables locales para el programa
  int m2, m3;
  int sensor, flagA, flagB;
  char k1;
  String hora1;
  char key = keypad.getKey();     //Manera de obtener la tecla que es aplastada en el teclado 4x4
  char k;
  if(key == NO_KEY){
      ImprimirTiempo();
      lcd.setCursor(0,1);
      char marA[80];
      sprintf(marA, "A:%02d:%02d", horaA, minutA);
      lcd.print(marA);
      lcd.setCursor(8,1);
      char marB[80];
      sprintf(marB, "B:%02d:%02d", horaB, minutB);
      lcd.print(marB);
      delay(100);
      if (now.hour() == horaA && now.minute() == minutA && alarmaA == 0){   //Validar que se active el motor A si la hora que ingresó el usuario para la pastilla A es iguala la actual
             alarmaA=1;
             sensor = 0;
             flagA = 1;
              while(sensor < 7){
                ImprimirTiempo();
                if (flagA%2 == 0){
                  _mForwardA();  
                  delay(500);}
                else{
                  _mBackA();
                  delay(500);}
                flagA = flagA+1;
             sensor = sensor + 1;
                }
             _mStop();
             while((k = keypad.getKey()) == NO_KEY){
                ImprimirTiempo();
                BuzzerOn();
              }
            }
      if (now.hour() == horaB && now.minute() == minutB && alarmaB == 0){  //Validar que se active el motor B si la hora que ingresó el usuario para la pastilla B es iguala la actual
             Serial.println("ADENTRO DE B");
             alarmaB=1;
             sensor = 0;
             flagB = 1;
              while(sensor < 7){
                ImprimirTiempo();
                if (flagB%2 == 0){
                  _mForwardB();  
                  delay(500);}
                else{
                  _mBackB();
                  delay(5-00);}
                flagB = flagB+1;
             sensor = sensor + 1;
                }
             _mStop();
             while((k = keypad.getKey()) == NO_KEY){
                ImprimirTiempo();
                BuzzerOn();
              }
            }
    }
    
    else {  
    Serial.println(key);
    switch(key) {
      case '*':
      Serial.println("Seleccione A o B:");
      k = 'C';
      while(k != 'A' && k != 'B'){
      while((k = keypad.getKey()) == NO_KEY);
      }
      switch(k){
        case 'A':
          Serial.println("Ingrese la hora de la capsula A: ");
          k1 = 'F';
          hora1 = "";
          posA=1;
          while(k1 != '#'){
          while((k1 = keypad.getKey()) == NO_KEY);
          posA=posA+1;
          if(posA == 4){
            posA = 5;
            }
          if(k1 != '#'){
          lcd.setCursor(posA,1);
          lcd.print(k1);
          Serial.print(k1);
          hora1 = hora1+k1;
            }
          }
          alarmaA=0;
          h3 = hora1.toInt();
          h2 = h3/100;
          m2 = h3-h2*100;
          /*Serial.println();
          Serial.println(h2);
          Serial.println(m2);*/
          horaA = h2;
          minutA = m2;
          break;
        case 'B':
          Serial.println("Ingrese la hora de la capsula B: ");
          k1 = 'F';
          hora1 = "";
          posB = 9;
          while(k1 != '#'){
          while((k1 = keypad.getKey()) == NO_KEY);
          posB=posB+1;
          if(posB == 12){
            posB = 13;
            }
          if(k1 != '#'){
          lcd.setCursor(posB,1);
          lcd.print(k1);
          Serial.print(k1);
          hora1 = hora1+k1;
            }
          }
          alarmaB = 0;
          h4 = hora1.toInt();
          h5 = h4/100;
          m3 = h4-h5*100;
          horaB = h5;
          minutB = m3;
          break;
        }
      }
    }  
    
            
}
