def numeros(archivo1,archivo2):
    dic={}
    lista=[]
    frances=open("frances.txt","r")
    for linea in frances:
        l=linea.split(",")
        dic[l[1]]=l[0]
    frances.close()
    num=open(archivo1,"r")
    for line in num:
        if line in dic:
            lista.append(dic[line])
    num.close()
    traduccion=open(archivo2,"w")
    for i in lista:
        traduccion.write(i+'\n')
    traduccion.close()

def almacenarRentasEstudiantes(nombreArchivo,horaInicio,horaFinal):
    reporte = {}
    rentas=open(nombreArchivo,"r")
    for line in rentas:
        s=line.split("|")
        matricula=s[0]
        nombre=s[1]
        bicicleta=int(s[2])
        hinicio=int(s[3])
        hfinal=int(s[4])
        multa=float(s[5])
        if (hinicio>=horaInicio) and (hfinal<=horaFinal):
            if matricula not in reporte:
                reporte[matricula]={'veces':0,'num_multas':0,'valor_multa':0.0}
            reporte[matricula]['veces']+=1
            if multa>0:
                reporte[matricula]['num_multas']+=1
                reporte[matricula]['valor_multa']+=1
    return reporte
def reporteIndividual(prefijo,diccionario):
    for matricula in diccionario:
        nombre=prefijo+'_'+matricula
        f=open(nombre,"w")
        f.write(str(diccionario[matricula]['veces'])+"|"+str(diccionario[matricula]['num_multas'])
                +"|"+str(diccionario[matricula]['valor_multa']))
