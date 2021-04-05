# -*- coding: UTF-8 *-*
'''
Created on 24 feb. 2018

@author: Jhonatan
'''
"""Ejercicio 16:
Leer 10 n�meros enteros. Debemos mostrarlos en el siguiente orden: 
el primero, el �ltimo, el segundo, el pen�ltimo, el tercero, etc."""

datos = [0,0,0,0,0,0,0,0,0,0]

for i in range(0,10):
    datos[i]=input( "Introduzca el numero {} ".format(i+1))
    

for i in range (0,5,):
    print datos[i] , "" , datos[9-i] ,"",
    

   
