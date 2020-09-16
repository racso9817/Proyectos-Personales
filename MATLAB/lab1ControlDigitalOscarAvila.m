%Oscar Andres Avila Alvarez
%Paralelo 101
w1 = 1;
Tend = 100;
Tmax = 20;
Ts = 1; %muestreo suficiente
%Ts = 0.5 %muestreo alto
%Ts = 4 %muestreo insuficiente
%Ts = 3 %muestreo multiplo (Aliasing)
rTs = 0.01;
ws = (2*pi)/Ts;
dw1 = 2*w1;
fN = pi/Ts;
sim('sim1OscarAvila', Tend)
%Procedemos a graficar las señales que se obtuvieron, con el comando plot y con
%todas las especificaciones posibles.
figure()
subplot 311
stem(t,p)
xlim([0 Tmax])
title('muestreador')
subplot 312
plot(t,xt)
hold on
stem(t,xs)
hold off
xlim([0 Tmax])
title('Se˜nales originales y muestreada')
subplot 313
tz=0:Ts:Tend;
xz2=interp1(tz,xz,t,'previous');
plot(t,xz2)
xlim([0 Tmax])
title('Señal retenida')
%Se procede a hacer el an´alisis en el dominio de la frecuencia obteniendo el Intervalo
%de frecuencia real.
N=length(xt)
k=1:N
w=2*pi*(k-1)/(rTs*N);
w=w';
%Obtener la transformada de furier con el comando fft (fast furier transform) de
%cada una de las se˜nales continua, muestreada y retenida
XT=fft(xt)
XS=fft(xs)
XZ=fft(xz2)
% Gaficar los datos obtenidos en el dominio de la frecuencia.
wmax=5*pi
figure()
subplot 311
plot(w,abs(XT))
xlim([0 wmax])
title('Señal original en el dominio de la frecuencia')
subplot 312
plot(w,abs(XS))
xlim([0 wmax])
title('Señal muestrada en el dominio de la frecuencia')
subplot 313
plot(w,abs(XZ))
xlim([0 wmax])
title('Señal retenida en el dominio de la frecuencia')