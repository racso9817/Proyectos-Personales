import validaciones as val
import numpy as np
#funcion 1
def stopWords(archivo):
    l=[]
    doc=open(archivo,"r")
    borrar=['\n']
    for line in doc:
        for caracter in borrar:
            texto=line.replace(caracter,"")
            l.append(texto)
    doc.close()
    return set(l)
#funcion 2
def removeWords(palabras,conjunto): #palabras es una lista
    sin_repetir=[]
    conjuntos=list(conjunto)
    a=palabras.split()
    for i in a:
        if i not in conjuntos:
            if i not in sin_repetir:
                sin_repetir.append(i)
    return sin_repetir
#funcion 3
def frecuencia(archivo):
    dic={}
    y = stopWords("stopwords.txt")
    lx=[]
    doc=open(archivo,"r")
    borrar=['\n','.',',','¿','?']
    candidatos=["MB","SP","TH","JL"]
    for line in doc:
        l=line.split(": ",2)
        for i in candidatos:
            if i==l[0]:
                if l[0] not in dic:
                    dic[l[0]]={}
                    for re in borrar:
                        l[1]=l[1].replace(re,"").lower()
                    z=removeWords(l[1],y)
                    for xi in range(len(z)):
                        if z[xi] not in dic[l[0]]:
                            dic[l[0]][z[xi]]=1
                        else:
                            dic[l[0]][z[xi]] += 1
                else:
                    for re in borrar:
                        l[1]=l[1].replace(re,"").lower()
                    z=removeWords(l[1],y)
                    for xi in range(len(z)):
                        if z[xi] not in dic[l[0]]:
                            dic[l[0]][z[xi]]=1
                        else:
                            dic[l[0]][z[xi]] += 1
    return dic
#funcion 4
def top10(dic,iniciales):
    ltupla=[]
    for i in range(0,10):
        max=0
        word=None
        if iniciales in dic:
            for palabra in dic[iniciales]:
                n=dic[iniciales][palabra]
                if (palabra,n) not in ltupla:
                    if n>max:
                        max=n
                        word=palabra
        tupla=(word,max)
        ltupla.append(tupla)
    return ltupla
#FUNCION 5
def guardarTop10(archivo_name,listawf):
    if ".txt" not in archivo_name:
        archivo_name=archivo_name+".txt"
    f=open(archivo_name,"w")
    for i in range(len(listawf)):
        print(listawf[i][0],listawf[i][1],file=f)
    f.close()
#FUNCION 6
def matrix(diccionario): # diccionario es el diccinario de la funcion 3
    palabras=set()
    candidatos=[]
    for candidato in diccionario:
        candidatos.append(candidato)
        for keyword in diccionario[candidato]:
            palabras.add(keyword)
    matrix=np.zeros((len(palabras),len(candidatos)),dtype=int)
    palabras = list(palabras)
    for x in range(len(candidatos)):
        for candidatodic in diccionario:
            if candidatos[x]==candidatodic:
                for y in range(len(palabras)):
                    for palabradic in diccionario[candidatodic]:
                        if palabras[y] in diccionario[candidatodic]:
                            if palabras[y]==palabradic:
                                matrix[y,x]=diccionario[candidatodic][palabradic]
    return matrix
#menu
def menu():
    flag=0
    while flag==0:
        a=val.validar_menu()
        if a == 1:
            print('\n')
            nombre_candidato=val.validar1()
            dic=frecuencia("debate.txt")
            ini=nombre_candidato.split()
            list=top10(dic,ini[0][0]+ini[1][0])
            for i in range(len(list)):
                a=list[i]
                print(a[0]+": ",a[1],"veces")
            guardarTop10(nombre_candidato+"_top10",list)
            print('\n')
            enter=input("Presione enter para continuar")
        elif a ==2:
            print('\n')
            nombre_candidato=val.validar1()
            dic=frecuencia("debate.txt")
            nr=matrix(dic)
            maximo=nr.max(axis=0)
            print('\n')
            enter = input("Presione enter para continuar")
        elif a==3:
            print('\n')
            dic=frecuencia("debate.txt")
            nr=matrix(dic)
            num_palabras=nr.sum()
            print("Número de palabras dichas:",num_palabras)
            print("Candidato que más palabras habló:")
            print("Candidato que menos palabras habló:")
            print("Palabra más usada:")
            print('\n')
            enter = input("Presione enter para continuar")
        elif a==4:
            print("\n")
            print("Gracias")
            flag=1