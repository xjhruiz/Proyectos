'''
Created on 24 feb. 2018

@author: Jhonatan
'''
#hacer  23  y 16 
repetido = False
cont=0
datos = [0,0,0,0,0,0,0,0,0,0]
for i in range(0,10):
    datos[i]=input("Introduzca el numeros {} ".format(i+1))
    
    
    
print datos
    
for i in  range(len(datos)-1,0,-1):
    if datos[i] in datos[:i]:
            repetido =True
    

            
if  repetido == False:
    print "no hay ningun numero repetido"
else:
    print"hay algun numero repetido"
    

    