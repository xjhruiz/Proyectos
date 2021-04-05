# -*- coding: iso-8859-15 -*-
'''
Created on 24 feb. 2018

@author: Jhonatan
'''
# 5. Crear un array con los siguientes datos "perro", "gato", 1, 100
array =["perro" , "gato" , 1 ,100]
print array

#6. Mostrar de la segunda a la cuarta letra de la primera palabra del array anterior.
print array[0][1:4]

#7. Mostrar la penúltima letra de la segunda palabra

print array[1][2:-1]

#8. En la tercera posicion del array guardar el siguiente texto con este formato:
"""En un 
    lugar de 
    la mancha..."""
    
array[2] = """En un 
    lugar de 
    la mancha..."""
print array[2]
#9. sumar al contenido de la cuarta posibcion la primera cifra de esta misma posicion
array[3]+= array[3]/100
print array[3]

#10. agregar al final del array otro array: "tortuga", 200
array.append(['tortuga' , 200])
print array 
print len(array)