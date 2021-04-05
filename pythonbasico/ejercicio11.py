# -*- coding: utf-8 *-*
'''
Created on 24 feb. 2018

@author: Jhonatan
'''
compra = input("Introduzca el importe de su compra ")
tarjeta = raw_input("Va a pagar con tarjeta ")
compra1 = compra
if compra >100 and compra <200 and tarjeta=="si" :
    des = compra-(compra*0.15)
    print "El cliente debera  pagar " , des , " euros " 
elif compra >100 and compra <200 and tarjeta =="no":
    des = compra-(compra*0.10)
    print "El cliente debera  pagar " , des , " euros "    
if compra > 200 and tarjeta == "si":
    des = compra-(compra*0.25)
    print "El cliente debera  pagar" , des , " euros "     
elif compra > 200 and tarjeta == "no":
    des = compra-(compra*0.20)
    print "El cliente debera  pagar " , des , " euros "
    
        
if compra <= 100:
    print "El cliente debera  pagar  " , compra , " euros"   