package model.auxiliar;

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
	 * Constrói novo objeto hora, a partir de objeto hora
	 * fornecido. Aplicável quando se deseja cópia profunda
	 * e não cópia de ponteiro.
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
		String hora = "" + this.get(Calendar.HOUR_OF_DAY);
		hora = (hora.length() == 1) ? hora = "0" + hora : hora;
		String minutos = "" + this.get(Calendar.MINUTE);
		minutos = (minutos.length() == 1) ? "0" + minutos : minutos;
		return hora + ":" + minutos;
	}
}
