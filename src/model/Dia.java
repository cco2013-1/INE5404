package model;

import java.util.ArrayList;
import java.util.Calendar;
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
	
	public Dia(Hora horarioInicio, Hora horarioFinal, int duracao, Sala sala){
		horarios = new ArrayList<Horario>();
		
		Hora inicioAula = new Hora(horarioInicio);
		Hora fimAula = new Hora(inicioAula);
		
		fimAula.avancaMinutos(duracao);
		
		System.out.println("Horario de inicio das aulas: " + inicioAula);
		System.out.println("Horario fim das aulas: " + fimAula);
		
		while(fimAula.getTime().compareTo(horarioFinal.getTime() ) < 0 ){
			horarios.add(new Horario(new Hora(inicioAula), new Hora(fimAula), sala));
			inicioAula = new Hora(fimAula);
			fimAula.add(GregorianCalendar.MINUTE, duracao);
		}
	}
	
	public ArrayList<Horario> getHorarios(){
		return this.horarios;
	}
	
	public static void main(String[] args){
		Hora inicio = new Hora(2013, 8, 27, 8, 0);
		Hora fim = new Hora(2013, 8, 27, 21, 0);
		
		Sala s = new Sala("Sala 1");
		
		Dia d = new Dia(inicio, fim, 50, s);
		
		ArrayList<Horario> h = d.getHorarios();
		
		for(int i = 0; i < h.size(); i++){
			Hora comeco = h.get(i).getInicio();
			Hora fin = h.get(i).getFim();
			System.out.println("Inicio: " + comeco );
			System.out.println("Fim: " + fin );
			System.out.println("\n");
		}
		
	}
}
