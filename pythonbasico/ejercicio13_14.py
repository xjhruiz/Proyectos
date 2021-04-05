'''
Created on 24 feb. 2018

@author: Jhonatan
'''
n = input("Introduzca los lados del cuadrado")

# Ejercicio 13: cuadrado 
for s in range (n):
    print s ,"*" * n
   
for s in range (0 ,n):
    print  "*" * n
    
# Ejercicio 14: cuadrado hueco
n = input("Introduzca un numero ")
#con if  
for i in range (0,n):
    if i==0 or i == n-1 :
        print "*"*n
    if i>0 and i< n-1:
        print "*" + " " * (n-2)+"*"
        
#sin if
print ("*"  * n) 
for j in range(n-2):
    print "*" + " " * (n-2)+"*"
print "*"*n