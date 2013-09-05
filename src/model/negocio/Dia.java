package model.negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import model.auxiliar.Hora;

/**
 * Classe Dia
 * @author vinicius
 *
 * Representa conjunto de horários de determinado dia, para determinada sala
 *
 */

public class Dia {
	
	//Atributos
	private List<Horario> horarios;
	
	/**
	 * Construtor Dia
	 * Cria objeto Dia, com horários a partir de horarioInicio,
	 * cada horario com a duracao especificada, até o horarioFinal.
	 * Deve ser definida a Sala para qual este dia se refere.
	 * @param horarioInicio Horário de início de atendimento em dada sala
	 * @param horarioFinal Horário final de atendimento
	 * @param duracao Duração de cada intervalo
	 * @param sala Sala para o qual os horários se referem
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
	 * Método get(hora)
	 * Retorna Horário de forma que a hora fornecida no construtor é maior ou igual
	 * à hora de início do horário retornado.
	 * Ex. Fornecida hora: 15h30.
	 * Horários contidos na lista de horários do dia: (14h00 - 14h50) (14h50 - 15h40) (15h40 - 16h30)
	 * Será retornado o segundo horário na lista, ou seja, (14h50 - 15h40) pois 15h30 >= 14h50 
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
	 * Método numHorarios
	 * Retorna o número de horários criados no
	 * objeto Dia
	 * @return
	 */
	public int numHorarios(){
		return this.horarios.size();
	}
}
