package com.java8.java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FechaJAVA {

	// CALENDER VS LOCALDATE,LOCALTIME,LOCALDATETIME
	public void verificar(int version) {
		if (version == 7) {
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = Calendar.getInstance();
			fecha1.set(1997, 11, 20); // 30 ?/el mes empezaba por el 0
			fecha2.set(2020, 11, 20);
			System.out.println(fecha1.after(fecha2));
		} else if (version == 8) {
			// Solo fechas sin tiempo
			LocalDate fecha1 = LocalDate.of(1997, 12, 20);
			LocalDate fecha2 = LocalDate.now();

			System.out.println(fecha1.isAfter(fecha2));
			System.out.println(fecha1.isBefore(fecha2));

			// Solo tiempo
			LocalTime tiempo1 = LocalTime.of(10, 10, 10);
			LocalTime tiempo2 = LocalTime.now();

			System.out.println(tiempo1.isAfter(tiempo2));
			System.out.println(tiempo1.isBefore(tiempo2));

			// Tiempo y Fechas
			LocalDateTime fechayhora1 = LocalDateTime.of(1997, 12, 20, 10, 10, 10);
			LocalDateTime fechayhora2 = LocalDateTime.now();

			System.out.println(fechayhora1.isAfter(fechayhora2));
			System.out.println(fechayhora1.isBefore(fechayhora2));
		}
	}

	// CURRENTTIMEMILLIS vs INSTANT con duration
	public void medirTiempo(int version) throws InterruptedException {
		if (version == 7) {
			long ini = System.currentTimeMillis();
			Thread.sleep(1000);
			long fin = System.currentTimeMillis();
			System.out.println(ini - fin);
		} else if (version == 8) {
			Instant ini = Instant.now();
			Thread.sleep(1000);
			Instant fin = Instant.now();
			System.out.println(Duration.between(ini, fin).toSeconds());
		}
	}

	public void periodoEntreFechas(int version) {
		if (version == 7) {
			Calendar nacimiento = Calendar.getInstance();
			Calendar fechaActual = Calendar.getInstance();
			nacimiento.set(1997, 11, 20);
			fechaActual.set(2020, 12, 20);
			int anios = 0;

			while (nacimiento.before(fechaActual)) {
				nacimiento.add(Calendar.YEAR, 1);
				if (nacimiento.before(fechaActual)) {
					anios++;
				}
			}
			System.out.println(anios);
		} else if (version == 8) {
			LocalDate nacimiento = LocalDate.of(1997, 12, 20);
			LocalDate fechaActual = LocalDate.now();

			Period periodo = Period.between(nacimiento, fechaActual);

			System.out.println("Tiempo Transcurrido " + periodo.getYears() + " años " + periodo.getMonths() + " meses "
					+ periodo.getDays() + " dias, desde " + nacimiento + " hasta " + fechaActual);
		}
	}
	
	
	public void convertir(int version) throws ParseException {
		if(version == 7) {
			String fecha = "20/12/1997";
			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaConvertida = formateador.parse(fecha);
			System.out.println(fechaConvertida);
			
			Date fechaActual = Calendar.getInstance().getTime();
			formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			String fechaString = formateador.format(fechaActual);
			System.out.println(fechaString); 
		}else if(version == 8) {
			String fecha = "20/12/1997";
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaConvertida = LocalDate.parse(fecha,formateador);
			System.out.println(fechaConvertida);
			System.out.println(formateador.format(fechaConvertida));
		}
	}

	public static void main(String[] args) {

		FechaJAVA app = new FechaJAVA();

		try {
//			app.verificar(8);
//			app.medirTiempo(8);
//			app.periodoEntreFechas(8);
			app.convertir(8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
