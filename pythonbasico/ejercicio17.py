'''
Created on 24 feb. 2018

@author: Jhonatan
'''
asc = False
desc = False
datos = [0,0,0,0,0,0,0,0,0,0]
for i in range(0,10):
    datos[i]=input("Introduzca el numero {} ".format(i+1))   

for i in range(len(datos)-1):
    if (i >datos[1]):
        asc = True
    if (i <datos[1]):
        desc = True


if(asc==True):
    print "Los numeros estan ordenados de forma ascendente"
elif(desc == True):
    print " los numeros estan ordenados de forma descencente"
else:
    print "los numeros estan desordenaados"
        