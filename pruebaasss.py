#!C:/Program Files/Python39/python.exe

import xlsxwriter
import pymysql.cursors

DB_CONF = {
        'host' : 'localhost',
        'port': 3306,
        'user': 'root',
        'passwd': '',
        'db': 'osticketcajeros'
}
# Creo la conexion a db.

# connection = pymysql.connect(host='localhost', user='root', password='', db='mydb') # SERVIDOR
connection = pymysql.connect(**DB_CONF) # 2Forma

try:
	# Creo un libro de trabajo (workbook) y le a�ado una hoja de trabajo (worksheet).
	workbook = xlsxwriter.Workbook('C:/Users/Desktop/pruebasCSV/pruebasIncidenciasPy2.xlsx') # LOCAL ruta absoluta
	# workbook = xlsxwriter.Workbook('./tmp/total.xlsx') # SERVIDOR
	worksheet = workbook.add_worksheet("InformeIncidenciasCerradas")

	# Establesco la cabecera
	cell_format = workbook.add_format({'bold': True, 'bg_color': '#f48942', 'align': 'center'})	# Formato celda.
		
	worksheet.write('A1', 'ID_INCIDENCIA', cell_format)
	worksheet.write('B1', 'ENTIDAD', cell_format)
	worksheet.write('C1', 'ID_CAJERO_LOGICO', cell_format)
	worksheet.write('D1', 'NUMERO_SERIE', cell_format)
	worksheet.write('E1', 'CAJERO_DESPLAZADO', cell_format)
	worksheet.write('F1', 'TIPOLOGIA_DE_INCIDENCIA', cell_format)
	worksheet.write('G1', 'SUBTIPOLOGIA_DE_INCIDENCIA', cell_format)
	worksheet.write('H1', 'STATUS_DE_INCIDENCIA', cell_format)
	worksheet.write('I1', 'FECHA_DE_INCIDENCIA', cell_format)
	worksheet.write('J1', 'DURACION_DE_LA_INCIDENCIA', cell_format)
	worksheet.write('K1', 'FECHA_DE_ALTA', cell_format)
	worksheet.write('L1', 'ESTADO_DE_APERTURA', cell_format)
	worksheet.write('M1', 'FECHA_MODIFICACION', cell_format)
	worksheet.write('N1', 'ESTADO_DE_CIERRE', cell_format)
	worksheet.write('O1', 'ESTADO_DE_VIGIA', cell_format)
	worksheet.write('P1', 'USUARIO_ASIGNADO', cell_format)
	worksheet.write('Q1', 'NUMERO_DE_AVERIA', cell_format)
	worksheet.write('R1', 'FECHA_DE_ACTUALIZACION_CARGA', cell_format)
	worksheet.write('S1', 'IDENTIDAD', cell_format)
	worksheet.write('T1', 'MODELO_DEL_CAJERO', cell_format)
	worksheet.write('U1', 'MARCA', cell_format)
	worksheet.write('V1', 'SISTEMA_OPERATIVO', cell_format)
	worksheet.write('W1', 'ESTADO_CAJERO', cell_format)
	worksheet.write('X1', 'SUBTIPO_DE_ESCALADO', cell_format)
	worksheet.write('Y1', 'FECHA_CIERRE', cell_format)
	worksheet.write('Z1', 'COMENTARIO_AVERIA', cell_format)
	worksheet.write('AA1', 'COMENTARIOS_CIERRE', cell_format)
	worksheet.write('AB1', 'INTENTOS_CONTACTOS', cell_format)
	worksheet.write('AC1', 'FECHA_PRIMER_CAMBIO_ESTADO_APERTURA', cell_format)
	worksheet.write('AD1', 'ACCIONES_EJECUTADAS', cell_format)
	worksheet.write('AE1', 'RESUMEN_DE_LAS_ACCIONES_EJECUTADAS', cell_format)



	# Empezamos desde la primera celda de cada fila. Filas y columnas comienzan indexadas desde 0.
	row = 1
	col = 0

	#Creo el cursor con el que recorrer la sentencia.
	with connection.cursor() as cursor:
		# Solicito los datos a guardar en la hoja.
		sql = """ MYQUERY """
			# -- AND averias.fecha_creacion_averia BETWEEN %s AND %s 
		cursor.execute(sql)
		result = cursor.fetchall()
	
	# tupla = ('2021-06-10','2021-06-15')
	# cursor.execute(sql, tupla)
		
	format2= workbook.add_format({'num_format' : 'dd/mm/yy hh:mm:ss'})
	cont = 0
	# Iteramos cada dato y escribimos en el excel fila a fila.
	# for id_averia, id_cajero_logico, numero_serie, duracion, estado_apertura_accion, fecha_modificacion , estado_de_cierre , usuarioAsignado in (result):
	for id_averia, entidad, id_cajero_logico, numero_serie, cajero_desplazado, tipologia_de_incidencia, subtipologia_de_incidencia, status_de_incidencia, fecha_de_incidencia, duracion_de_la_incidencia, fecha_de_alta, estado_de_apertura, fecha_modificacion, estado_de_cierre, estado_de_vigia, usuario_asignado, numero_de_averia, fecha_de_actualizacion_carga, idEntidad, modelo_del_cajero, marca, sistema_operativo, estado_cajero, subtipo_de_escalado, fecha_cierre, comentario_averia in (result):
		
		# worksheet.write(row, col + 2, numero_serie)
		# worksheet.write(row, col , id_averia)
		# worksheet.write(row, col + 1, entidad)
		# worksheet.write(row, col + 2, id_cajero_logico)
		# worksheet.write(row, col + 3, numero_serie)
		# worksheet.write(row, col + 4, cajero_desplazado)
		# worksheet.write(row, col + 5, tipologia_de_incidencia)
		# worksheet.write(row, col + 6, subtipologia_de_incidencia)
		# worksheet.write(row, col + 7, status_de_incidencia)
		# worksheet.write(row, col + 8, fecha_de_incidencia)
		# worksheet.write(row, col + 9, duracion_de_la_incidencia)
		# worksheet.write(row, col + 10, fecha_de_alta)
		# worksheet.write(row, col + 11, estado_de_apertura)
		# worksheet.write(row, col + 12, fecha_modificacion)
		# worksheet.write(row, col + 13, estado_de_cierre)
		# worksheet.write(row, col + 14, estado_de_vigia)
		# worksheet.write(row, col + 15, usuario_asignado)
		# worksheet.write(row, col + 16, numero_de_averia)
		# worksheet.write(row, col + 17, fecha_de_actualizacion_carga)
		# worksheet.write(row, col + 18, idEntidad)
		# worksheet.write(row, col + 19, modelo_del_cajero)
		# worksheet.write(row, col + 20, marca)
		# worksheet.write(row, col + 21, sistema_operativo)
		# worksheet.write(row, col + 22, estado_cajero)
		# worksheet.write(row, col + 23, subtipo_de_escalado)
		# worksheet.write(row, col + 24, fecha_cierre)
		# worksheet.write(row, col + 25, comentario_averia)
		# worksheet.write(row, col + cont, comentariosCierres)
		# worksheet.write(row, col + cont, intentosContactos)
		worksheet.write(row, col , id_averia)
		worksheet.write(row, col + 1, entidad)
		worksheet.write(row, col + 2, id_cajero_logico)
		worksheet.write(row, col + 3, numero_serie)
		worksheet.write(row, col + 4, cajero_desplazado)
		worksheet.write(row, col + 5, tipologia_de_incidencia)
		worksheet.write(row, col + 6, subtipologia_de_incidencia)
		worksheet.write(row, col + 7, status_de_incidencia)
		worksheet.write(row, col + 8, fecha_de_incidencia)
		worksheet.write(row, col + 9, duracion_de_la_incidencia)
		worksheet.write(row, col + 10, fecha_de_alta)
		worksheet.write(row, col + 11, estado_de_apertura)
		worksheet.write(row, col + 12, fecha_modificacion)
		worksheet.write(row, col + 13, estado_de_cierre)
		worksheet.write(row, col + 14, estado_de_vigia)
		worksheet.write(row, col + 15, usuario_asignado)
		worksheet.write(row, col + 16, numero_de_averia)
		worksheet.write(row, col + 17, fecha_de_actualizacion_carga)
		worksheet.write(row, col + 18, idEntidad)
		worksheet.write(row, col + 19, modelo_del_cajero)
		worksheet.write(row, col + 20, marca)
		worksheet.write(row, col + 21, sistema_operativo)
		worksheet.write(row, col + 22, estado_cajero)
		worksheet.write(row, col + 23, subtipo_de_escalado)
		worksheet.write(row, col + 24, fecha_cierre)
		worksheet.write(row, col + 25, comentario_averia)
		
		row += 1
		

	# Cerramos la hoja
	workbook.close()
except:
	raise
finally:
	#Por ultimo cerramos la conexi�n
    connection.close()
