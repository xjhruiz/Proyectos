'''
Created on 24 feb. 2018

@author: Jhonatan
'''

n = input("Introduzca un numero ")

for i in range(0,n,1):
    for j in range(0,n-i-1):
        print "",
    for j in range(0,i+1):
        print "*",
   
    print""
    
for i in range (n-1,0,-1):
    for j in range(0,n-i):
        print "",
    for j in range (0,i):
        print "*",
        
    print ""