%Oscar Avila Paralelo 1
%Practica 4
%EJERCICIO 1
T = 2.5;
zita = 0.5;
muestras = 10;
z = 2*pi/muestras;
wd = z/T;
wn = wd/sqrt(1-zita^2);
G = tf([1],[1 0.4],'inputdelay',5');
Gz = c2d(G,T,'zoh');
sisotool(Gz)
t = ScopeDataE1(:,1);
in = ScopeDataE1(:,2);
out = ScopeDataE1(:,3);
plot(t,in,t,out), grid on, title('Ejercicio 1 Respuesta a entrada escalón'), legend('entrada','salida'), xlabel('Tiempo'),ylabel('Salida y Entrada')

%EJERCICIO 2
T2 = 0.1;
G2 = tf([1],[1 0 0]);
G2z = c2d(G2,T2,'zoh');
sisotool(G2z)
t2 = ScopeDataE2(:,1);
in2 = ScopeDataE2(:,2);
out2 = ScopeDataE2(:,3);
plot(t2,in2,t2,out2), grid on, title('Ejercicio 2 Respuesta a entrada escalón'), legend('entrada','salida'), xlabel('Tiempo'),ylabel('Salida y Entrada')

