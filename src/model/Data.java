package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe Data
 * Representa uma Data (dia, mes e ano)
 * @author vinicius
 *
 */
public class Data extends GregorianCalendar {
	
	public Data(int ano, int mes, int diaDoMes){
		super(ano, mes, diaDoMes);
	}
	
	/**
	 * MŽtodo toStringDB
	 * Retorna uma data formatada conforme ISO8601.
	 * "YYYY-MM-DD"
	 * Ex: "2013-08-28"
	 * Ver: http://pt.wikipedia.org/wiki/ISO_8601
	 */
	public String toStringDB(){
		String ano = "" + this.get(Calendar.YEAR);
		String mes = "" + this.get(Calendar.MONTH);
		mes = (mes.length() == 1) ? "0" + mes : mes;
		String dia = "" + this.get(Calendar.DAY_OF_MONTH);
		dia = (dia.length() == 1) ? "0" + dia : dia;
		
		return ano + "-" + mes + "-" + dia;
	}
	
	/**
	 * MŽtodo toString
	 * Retorna a data formatada como "DD/MM/YYYY"
	 */
	public String toString(){
		String ano = "" + this.get(Calendar.YEAR);
		String mes = "" + this.get(Calendar.MONTH);
		mes = (mes.length() == 1) ? "0" + mes : mes;
		String dia = "" + this.get(Calendar.DAY_OF_MONTH);
		dia = (dia.length() == 1) ? "0" + dia : dia;
		
		return dia + "/" + mes + "/" + ano;
	}
}
