'''
Created on 28 feb. 2018

@author: Jhonatan
'''
class Dni():
    letra =""
    numero= 0
    
    def pasarDni(self, dni):
        self.numero=dni
        letra = self.calcularLetra()
        self.letra=letra
        return dni, " - "
    
    def leer(self):
        numero = input("Introduzca el numero del dni : ")
        self.numero=numero 
        return "Su Dni es"     
    def calcularLetra(self):
        letras = ["T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"]
        letra =""
        posicion = 0
        posicion = self.numero%23
        for j in range(0,len(letras)):
            if(j==posicion):
                letra = letras[j]
                self.letra=letra
                
        return letra
         
    def mostrarDNI(self):
        letra = self.calcularLetra()
        return self.numero,"-",letra
    
    def valirdarnumDni(self):
        num = self.numero
        cont =0;
        valido = False 
        while num>0:
            num/10
            cont+=1
        if(cont!=8):
            return True   
        else:
            print"Introduzca un numero de 8 digitos "
            return False
            
dni = Dni()
dni2 = Dni()
print dni.leer(),dni.mostrarDNI()
dni2.pasarDni(87654321),
print "Su DNI es",dni2.mostrarDNI()


        
           
