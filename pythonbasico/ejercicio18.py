'''
Created on 24 feb. 2018

@author: Jhonatan
'''
# Ejercicio 18:

n =int( input("Introduzca un numero "))

for i in range(0,n):
    print ""
    for j in range(0,i+1):
        print "*",

           
for i in range (n-1,0,-1):
    print " " 
    for j in range (0,i):
        print "*",
          
        