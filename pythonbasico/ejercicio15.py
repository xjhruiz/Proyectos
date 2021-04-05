'''
Created on 24 feb. 2018

@author: Jhonatan
'''
#Ejercicio 15: Leer 5 numeros y mostrar el mínimo introducido, el máximo introducido y la media.
datos = [0,0,0,0,0]
max , min , media = 0 , 1000 , 0
suma = 0
for i in range(5):
    datos[i] = input("Introduzca el numero {}: ".format(i))

    if(datos[i]>max):
        max = datos[i]
    if(datos[i]<min):
        min = datos[i]
 
for i in range(5):
    suma +=datos[i]
    media = suma / (i +1)
    
    
print "El numero mayor es " ,  max
print "El numero menor es " , min 
print "La media es " , media

