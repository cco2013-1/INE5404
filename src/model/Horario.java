package model;

/**
 * Classe Horario
 * Representa um intervalo de tempo no qual os pacientes s�o atendidos em determinada sala
 * Cont�m lista de pacientes atendidos no determinado hor�rio
 */

import java.util.ArrayList;
import java.util.List;

public class Horario {
	//Atributos
	private Hora inicio; //hor�rio de in�cio da sess�o
	private Hora fim;	//hor�rio do fim da sess�o
	private List<Paciente> pacientes;
	private Sala sala;
	
	public Horario(Hora inicio, Hora fim, Sala sala){
		this.inicio = inicio;
		this.fim = fim;
		this.sala = sala;
		this.pacientes = new ArrayList<Paciente>();
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}
	
	public void adicionaPaciente(Paciente p){
		pacientes.add(p);
	}

	public Hora getInicio() {
		return inicio;
	}

	public Hora getFim() {
		return fim;
	}
	
	public Sala getSala(){
		return sala;
	}
}
