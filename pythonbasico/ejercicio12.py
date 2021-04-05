'''
Created on 24 feb. 2018

@author: Jhonatan
'''
horas = input("Introduzca las horas que estado trabajando")
salario=0
if horas<=40:
    salario = horas*16
    print "El salario semanal es " , salario , " euros"
if horas>40:
    horasExtas=horas - 40
    salario =(40*16)+(horasExtas*20)
    print "El salario semanal es " , salario , " euros" 
