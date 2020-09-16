%% proyecto parte 1

close all
clear
clc

%% constantes del problema
Kb=30;
r=0.0318;
Lf=0.01;
Rf=100;
Mc=0.5;
m=1;
J=0.1;
b=0.367;
T=0.01

os=5
Ts=3
ess=0.1

%% funciones de transferencia incluida la de la aproximación de pade
Gs=series(tf([Kb*r],[Lf Rf]),tf([1],[(r.^2*(Mc+m))+J b]))
Gppade=series(Gs,tf([-0.1/2 1],[0.1/2 1]))
Gp=series(Gs,tf([1],[1],'InputDelay',0.1))


figure();
hold on
title('Aproximación de Pade y funcion original')
step(Gppade)
step(Gp)
% segun por la gráfica observada, la aproximación es muy buena

%% gz via zoh
Gz=c2d(Gppade,T,'zoh')

%% calculo de constantes
zeta=abs(log(os/100))/(sqrt(pi.^2 + (log(os/100)).^2))
wn=4/(zeta*3)

%% calculo de controlador via frecuencia
%% calculo de valores para compensador
Kp=((1/ess)-1)

syms z
f=(-0.0007433*z^2 + 0.0009032*z + 7.453e-06*10^-06)/(z^3 + 1.783*z^2 - 0.7897*z)
limite=double(limit(f,z,1))
K=Kp/limite

%% gw via tustin
Gw=d2c(Gz,'tustin')
G2w=series(Gz,K)

[Gm,Pm]=margin(G2w)

%% calculo de alpha
mf=100*zeta
teta=mf-Pm+12
alpha=(1-(sin(teta)))/(1+(sin(teta)))

mag=10*log10(alpha)
figure(2)
bode(G2w)
vm=(61.9+72.3)/2

tao=1/(vm*sqrt(alpha))

%% controlador final gd por frecuencia
Gd=tf([tao*K K],[tao*alpha 1])
Gd=c2d(Gd,T,'tustin')


%% controlador PID por sisotool
%sisotool(Gppade)


%% Controlador via LGR
sisotool(Gz)

