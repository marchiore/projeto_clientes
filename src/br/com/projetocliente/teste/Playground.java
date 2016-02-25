package br.com.projetocliente.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class Playground {
	public static void main(String[] args) {
		
		int days = Days.daysBetween(new DateTime(new Date("01/01/2016")), new DateTime(new Date("01/11/2016"))).getDays();
		
		System.out.println(days);
	}
}
