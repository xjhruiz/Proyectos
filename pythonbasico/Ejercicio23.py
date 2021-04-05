'''
Created on 25 feb. 2018

@author: Jhonatan
'''
datos1=[]
datos2=[]
datos3=[]
arrayAlumnosMedia,arraySuspensosAlumnos = [],[]
array2=[]
nalumno = int (input("Introduzca el numero de alumnos : "))
asi = [0,0,0]
sumAlumnos =0
contSuspenso1, contSuspenso2, contSuspenso3= 0 , 0 , 0
for a in range(1,nalumno+1):
    for j in range(1,4):
        print("introduce la nota del alumno" , a ," y la asignatura ",j)
        datos = int (input())
        if(j==1):#Notas de los alumnos de la asignatura 1
            datos1.append(datos)
        if(j==2):#notas de los alumnos de la asignatura 2
            datos2.append(datos)
        if(j==3):#notas de los alumnos de la asignatura 3
            datos3.append(datos)
           

                  
n,contadorSusAlumnos=0,0;
while nalumno>n:
    sumAlumnos = (datos1[n]+ datos2[n]+datos3[n])
    if(datos1[n]<5 or datos2[n]<5 or datos3[n]<5):
        contadorSusAlumnos+=1     
    print sumAlumnos,datos1[n],datos2[n],datos3[n]
    mediaAlumnos = sumAlumnos/3
    print mediaAlumnos   
    arrayAlumnosMedia.insert(n,mediaAlumnos)
    arraySuspensosAlumnos.insert(n,contadorSusAlumnos)
    n+=1
    
    
      
for a in datos1:
    if(a<5):
        contSuspenso1+=1
        
for a in datos2:
    if(a<5):
        contSuspenso2+=1
        
for a in datos3:
    if(a<5):
        contSuspenso3+=1


print contSuspenso3, contSuspenso2, contSuspenso1         
mediaAsig1 = float( sum(datos1)/len(datos1))
mediaAsig2 = float( sum(datos2)/len(datos2))
mediaAsig3 = float( sum(datos3)/len(datos3))
print "Las notas de la asignatura 1 son : " ,datos1 
print "Las notas de la asignatura 2 son : " ,datos2
print "Las notas de la asignatura 3 son : ",datos3
print "La media de la asignatura 1 es : ", float(mediaAsig1)
print "La media de la asignatura 2 es : ", mediaAsig2
print "La media de la asignatura 3 es : ", mediaAsig3
print "En  la asignatura 1 hay " ,contSuspenso1 , "Suspensos "
print "En  la asignatura 2 hay " ,contSuspenso2 , "Suspensos "
print "En  la asignatura 3 hay " ,contSuspenso3 , "Suspensos "

for j in range (0,nalumno):
    print  "La media del alumno " , (j+1), " es " , arrayAlumnosMedia[j], "El alumno " , (j+1) , "Ha suspendido" , arraySuspensosAlumnos[j],"asignatura"