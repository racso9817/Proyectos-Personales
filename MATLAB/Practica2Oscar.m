%% ===============================Practica 2=========================
%% Nombre: Óscar Andrés Ávila Álvarez
%% Paralelo 101
close all
clear
clc

%Constantes
Kiv=1.1;Kpv=5.5;Kdv=0.2;

%pid analogico
K=1.1;Ti=5.5;Td=0.2;

%tiempo de muestreo
T=1;

%Valores de controlador posicional regular
%Ki=K*T/Ti; Kd=K*Td/T; Kp=K;

%valores de controlador posicional trapezoidal
Ki=K*T/Ti; Kd=K*Td/T; Kp=K-Ki/2;

sim('ModeloSimulink2',40)

figure(1), grid on, hold on;
plot(t,ycon,'b.-','Linewidth',2.5);
%plot(t,y1,'r.-','Linewidth' ,2.5);
%stairs(td,y2,'ko-','Linewidth',0.5);
plot(t,y3,'g.-','Linewidth',0.5);
stairs(td,y4,'co-','Linewidth',2.5);
xlabel('Tiempo (s)'), ylabel('Salida'), hold off, legend;