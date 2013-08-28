package model;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Hora extends java.util.GregorianCalendar {
	
	public Hora(int ano, int mes, int diaDoMes, int hora, int minuto) {
		super(TimeZone.getDefault(), new Locale("pt", "BR"));
		super.set(Calendar.YEAR, ano);
		super.set(Calendar.MONTH, mes);
		super.set(Calendar.DAY_OF_MONTH, diaDoMes);
		super.set(Calendar.HOUR_OF_DAY, hora);
		super.set(Calendar.MINUTE, minuto);
	}
	
	/**
	 * Constr—i novo objeto hora, a partir de objeto hora
	 * fornecido. Aplic‡vel quando se deseja c—pia profunda
	 * e n‹o c—pia de ponteiro.
	 * @param h
	 */
	public Hora(Hora h){
		super(TimeZone.getDefault(), new Locale("pt", "BR"));
		super.set(Calendar.YEAR, h.get(Calendar.YEAR));
		super.set(Calendar.MONTH, h.get(Calendar.MONTH));
		super.set(Calendar.DAY_OF_MONTH, h.get(Calendar.DAY_OF_MONTH));
		super.set(Calendar.HOUR_OF_DAY, h.get(Calendar.HOUR_OF_DAY));
		super.set(Calendar.MINUTE, h.get(Calendar.MINUTE));
	}

	public void avancaMinutos(int min){
		super.add(Calendar.MINUTE, min);
	}
	
	public String toString(){
		return "" + this.get(Calendar.HOUR_OF_DAY) + ":" + this.get(Calendar.MINUTE);
	}
	
	public static void main(String[] args){
		Hora h = new Hora(2013, 8, 27, 23, 30);
		System.out.println(h);
		h.avancaMinutos(50);
		System.out.println(h);
	}
}
