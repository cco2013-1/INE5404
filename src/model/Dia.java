package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Classe Dia
 * @author vinicius
 *
 * Representa conjunto de hor‡rios de determinado dia, para determinada sala
 *
 */

public class Dia {

	//Atributos
	private ArrayList<Horario> horarios; //Lista dos hor‡rios
	
	public Dia(GregorianCalendar horarioInicio, GregorianCalendar horarioFinal, int duracao, Sala sala){
		horarios = new ArrayList<Horario>();
		
		GregorianCalendar inicioAula = horarioInicio;
		GregorianCalendar fimAula = inicioAula;
		
		fimAula.add(GregorianCalendar.MINUTE, duracao);
		
		while(fimAula.getTime().compareTo(horarioFinal.getTime() ) < 0 ){
			horarios.add(new Horario(inicioAula, fimAula, sala));
			inicioAula = fimAula;
			fimAula.add(GregorianCalendar.MINUTE, duracao);
		}
	}
	
	public ArrayList<Horario> getHorarios(){
		return this.horarios;
	}
	
	public static void main(String[] args){
		GregorianCalendar inicio = new GregorianCalendar(2013, 8, 27, 8, 0);
		GregorianCalendar fim = new GregorianCalendar(2013, 8, 27, 21, 0);
		
		System.out.println("Inicio: " + inicio.get(GregorianCalendar.HOUR) + ":" + inicio.get(GregorianCalendar.MINUTE) + "   " + 
				inicio.get(GregorianCalendar.DAY_OF_MONTH) + "/" + inicio.get(GregorianCalendar.MONTH) + "/" + inicio.get(GregorianCalendar.YEAR) );
		
		Sala s = new Sala("Sala 1");
		
		Dia d = new Dia(inicio,fim, 50, s);
		
		ArrayList<Horario> h = d.getHorarios();
		
		for(int i = 0; i < h.size(); i++){
			GregorianCalendar comeco = h.get(i).getInicio();
			GregorianCalendar fin = h.get(i).getFim();
			System.out.println("Inicio: " + comeco.get(GregorianCalendar.HOUR) + ":" + comeco.get(GregorianCalendar.MINUTE) + "   " + 
					comeco.get(GregorianCalendar.DAY_OF_MONTH) + "/" + comeco.get(GregorianCalendar.MONTH) + "/" + comeco.get(GregorianCalendar.YEAR) );
			System.out.println("Fim: " + fin.get(GregorianCalendar.HOUR) + ":" + fin.get(GregorianCalendar.MINUTE) + "   " + 
					fin.get(GregorianCalendar.DAY_OF_MONTH) + "/" + fin.get(GregorianCalendar.MONTH) + "/" + fin.get(GregorianCalendar.YEAR) );
			System.out.println("\n");
		}
		
	}
}
