OS = 10; %Sobrenivel porcentual
G = zpk([],[-1 -10],10); %Funcion de transferencia en tiempo continuo
Gz = c2d(G,0.02,'zoh'); %Funcion de transferencia en tiempo discreto
Gw = d2c(Gz,'tustin'); %Funcion de transferencia con transformada bilineal
PI = tf([1],[1 0]); %Controlador PI
G2w = series(Gw, PI); %Funcion de transferencia con controlador PI incluido
ess = 0.5; %Error de estado estable
Kv = 1/ess; %Constante de velocidad
syms s a tao 
f = (((-3.6519e-05)*(s+2729)*(s-100))/((s+1)*(s+9.967))); %Funcion de transferencia G2w
lim = double(limit(f,s,0)); %Limite de la funcion G2w cuando s tiende a 0
Kd = Kv/lim; %Constante Kd para el compensador
G3w = series(G2w, Kd); %Funcion de transferencia con la constante del compensador
[Gm,Pm]=margin(G3w); %Margen de ganancia y margen de fase de G3w
zita = double(((-log(OS/100))/(sqrt(pi^2+(log(OS/100)^2))))); %Obtencion del factor de amortiguamiento
Mfd = 100*zita; %Margen de fase deseado
desfase = Mfd-180; %Obtencion del angulo de desfase
desfase2=desfase-Pm+8; %Angulo de desfase mas el valor de seguridad
wn = 4/zita; %Obtencion de la frecuencia natural
c=sin(desfase2)==(1-a)/(1+a); %Ecuacion para obtener el factor alfa
alfa=double(solve(c,a)); %Obtencion del factor alfa
bode(G3w) %Diagrama de bode del sistema
mcruce = -20*log10(1/sqrt(alfa)); %Magnitud donde intercepta con la frecuencia de cruce de ganancia
fcg = 1.8; %Nueva frecuencia de cruce de ganancia
taon = double(solve((fcg == 1/((sqrt(alfa))*tao)),tao)); %Obtencion del factor tao
zca = -1/taon; %zero del compensador en adelanto
pca = -1/(alfa*taon); %polo del compensador en adelanto
compensador = zpk([zca],[pca],1); %Funcion de transferencia del compensador
G4w = series(G3w, compensador); %Funcion de transferencia compensada
[Gm4,Pm4]=margin(G4w); %Margen de fase de la función compensada
ti = ScopeData(:,1);
in = ScopeData(:,2);
out = ScopeData(:,3);
plot(ti,in,ti,out), grid on, title('Comportamiento con entrada escalon'),legend('Entrada','Salida'), xlabel('Tiempo'),ylabel('Entrada y Salida')
