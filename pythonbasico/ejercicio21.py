'''
Created on 24 feb. 2018

@author: Jhonatan
'''
import random
array1 = []
array2 = []
repetido = False
for i in range(1,10):
    array1.append(random.randint(1,50))
    array2.append(random.randint(1,50))
    
    
for i in array1:
    for j in array2:
        if i==j:
            repetido = True
            
            
print array1 , array2            
            
            
if repetido== True:
    print " Hay algun numero repetido"
else:
    print "no hay  ningun numero repetido "
 

     
 
    

