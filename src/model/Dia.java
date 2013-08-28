package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Classe Dia
 * @author vinicius
 *
 * Representa conjunto de hor�rios de determinado dia, para determinada sala
 *
 */

public class Dia {
	
	//Atributos
	private List<Horario> horarios;
	
	/**
	 * Construtor Dia
	 * Cria objeto Dia, com hor�rios a partir de horarioInicio,
	 * cada horario com a duracao especificada, at� o horarioFinal.
	 * Deve ser definida a Sala para qual este dia se refere.
	 * @param horarioInicio Hor�rio de in�cio de atendimento em dada sala
	 * @param horarioFinal Hor�rio final de atendimento
	 * @param duracao Dura��o de cada intervalo
	 * @param sala Sala para o qual os hor�rios se referem
	 */
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
	
	public Horario get(int i){
		return this.horarios.get(i);
	}
	
	/**
	 * M�todo get(hora)
	 * Retorna Hor�rio de forma que a hora fornecida no construtor � maior ou igual
	 * � hora de in�cio do hor�rio retornado.
	 * Ex. Fornecida hora: 15h30.
	 * Hor�rios contidos na lista de hor�rios do dia: (14h00 - 14h50) (14h50 - 15h40) (15h40 - 16h30)
	 * Ser� retornado o segundo hor�rio na lista, ou seja, (14h50 - 15h40) pois 15h30 >= 14h50 
	 * @param h
	 * @return
	 */
	public Horario get(Hora h){
		Horario hor = null;
		
		for ( int i = 0; i < this.horarios.size(); i++){
			if ( h.getTime().compareTo(this.get(i).getInicio().getTime() ) >= 0) {
				hor = this.get(i);
				break;
			}
		}
		
		return hor;
	}
	
	/**
	 * M�todo numHorarios
	 * Retorna o n�mero de hor�rios criados no
	 * objeto Dia
	 * @return
	 */
	public int numHorarios(){
		return this.horarios.size();
	}
	
	public static void main(String[] args){
		Hora inicio = new Hora(2013, 8, 27, 8, 0);
		Hora fim = new Hora(2013, 8, 27, 21, 0);
		
		Sala s = new Sala("Sala 1");
		
		Dia d = new Dia(inicio, fim, 50, s);
		
		for(int i = 0; i < d.numHorarios(); i++){
			Hora comeco = d.get(i).getInicio();
			Hora fin = d.get(i).getFim();
			System.out.println("Inicio: " + comeco );
			System.out.println("Fim: " + fin );
			System.out.println("\n");
		}
		
	}
}
