#Validacion Menu
def validar_menu():
    validacion=0
    while validacion == 0:
        opcion = input("Menú Debate Presidencial:\n1. Top 10 por candidato\n2. Estadísticas candidato"
                        "\n3. Estadísticas generales\n4. Salir\nIngrese su opción: ")
        try:
            opcion=int(opcion)
            if 1<=opcion<=4:
                validacion=1
                return opcion
            else:
                print("Debe ingresar un número entre 1 y 4")
        except:
            print("Debe ingresar un número entre 1 y 4")
def validar1():
    validacion=0
    while validacion==0:
        name=input("Ingrese el nombre del candidato que desea consultar: ")
        try:
            name=str(name)
            if name=="Michele Bachelet" or name=="Sebastián Piñeira" or name=="Tomás Hirsch" or name=="Joaquín Lavin":
                return name
            else:
                print("Debe ingresar Michele Bachelet, Sebastián Piñeira, Tomás Hirsch o Joaquín Lavin")
        except:
            print("Debe ingresar Michele Bachelet, Sebastián Piñeira, Tomás Hirsch o Joaquín Lavin")