package model;

public class Hora extends java.util.GregorianCalendar {
	
	public Hora(int ano, int mes, int dia_do_mes, int hora, int minuto) {
		super(ano, mes, dia_do_mes, hora, minuto);
	}

	public void add(int FIELD, int t){
		super.add(FIELD, t);
	}
}
