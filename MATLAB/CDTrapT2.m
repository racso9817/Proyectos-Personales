%Controlador digital trapezoidal T = 2 s
t = ScopeData(:,1);
in = ScopeData(:,2);
out = ScopeData(:,3);
plot(t,in,t,out), grid on, title('Controlador digital (salida y entrada vs tiempo)'), legend('Entrada','Salida')