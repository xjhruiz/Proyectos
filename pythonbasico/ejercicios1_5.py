# -*- coding: iso-8859-15 -*-
'''
Created on 24 feb. 2018

@author: Jhonatan
'''


a = input("Introduzca el numero 1 ")
b = input("Introduzca el numero 2 ")
c = input("Introduzca el numero 3 ")
 # 1. Introducir tres numeros y mostrarlos ordenados de mayor a menor.
if b > a:
    aux = a 
    a = b 
    b = aux
    
if c > b:
    aux = b
    b = c
    c = aux 
    
if b > a:
    aux = a
    a = b 
    b = aux
print (a , b , c)
#2. Mostrar por pantalla la tabla de multiplicar del 5 usando un while

cont=0
while cont <= 10:
    print("La tabla del 5 * " , cont ," = " ,( cont * 5))
    cont += 1
#3. Introducir un numero en una variable y decir cuantas cifras tiene
num = input("Introduzca un numero")
cifras=0
num1=num
while num > 0:
    num = num /10
    cifras += 1
    
print("El numero" , num1 , " Tiene " , cifras , " cifras")    
     
#4. Introducir un número en una variable y decir si es capicúa
nca = input("Introduzca un numero ")
rest , alreves , hasta = 0 , 0 , nca

while nca > 0:
    rest = nca % 10
    alreves = alreves * 10 + rest
    nca = nca / 10
   
        
if hasta == alreves:
    print ("El numero " , hasta ," es capicua ")
else:
    print("El numero " , hasta , " no es capicua") 

    