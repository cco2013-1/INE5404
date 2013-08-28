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
	
	@Override
	public String toString(){
		String ano = "" + this.get(Calendar.YEAR);
		String mes = "" + this.get(Calendar.MONTH);
		mes = (mes.length() == 1) ? "0" + mes : mes;
		String dia = "" + this.get(Calendar.DAY_OF_MONTH);
		dia = (dia.length() == 1) ? "0" + dia : dia;
		
		return ano + "-" + mes + "-" + dia;
	}
}
