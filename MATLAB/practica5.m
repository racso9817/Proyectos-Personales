Gs=tf(10,[1 11 10])
T=0.02
Gz=c2d(Gs,T,'zoh')

Gw=d2c(Gz,'tustin')
zero=tf(1,[1,0])
G2w=series(Gw, zero)

ess=0.5
Kv=1/ess

syms s
f=(-3.652e-05*s^2 - 0.09601*s + 9.966)/(s^2 + 10.97*s+9.966)
Kd=Kv/double(limit(f,s,0))

G3w=series(G2w,Kd)



zeta=-log(10/100)/(sqrt((pi.^2)+(log(10/100)).^2))
Ts=1
wn=4/(Ts*zeta)

mf=100*zeta
phi=mf-180

[Gm,Pm,Wcg,Wcp] = margin(G3w)

phin=phi-Pm+8
alpha=(1-sin(phin))/(sin(phin)+1)

corte=-20*log10(1/sqrt(alpha))
bode(G3w)
vm=1.84
tao=1/(vm*sqrt(alpha))

Gd=zpk([-1/tao],[-1/(tao*alpha)],[Kd])
Gd=zpk([-1/tao],[-1/(tao*alpha)],[1])

Gf=series(G3w,Gd)

[Gm,Pm,Wcg,Wcp] = margin(Gf)
