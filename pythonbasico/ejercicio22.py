'''
Created on 24 feb. 2018

@author: Jhonatan
'''
array = [] 

for i in range(1,8):
    n= input("Introduzca el numero {} ".format(i))
    array.append(n)



print array
    
for j in range(2):
    n= input("Introduzca el numero: {}")
    indice = input("En que posicion quiere introducirlo: ")
    if indice>=0 and indice<len(array):
        array.insert(indice, n)
        print array
    else:
        print"Este indice no existe"
        
    

    