package model;

/**
 * Classe Horario
 * Representa um intervalo de tempo no qual os pacientes são atendidos em determinada sala
 * Contém lista de pacientes atendidos no determinado horário
 */

import java.util.ArrayList;
import java.util.List;

public class Horario {
	//Atributos
	private Hora inicio; //hora de início da sessão
	private Hora fim;	//hora do fim da sessão
	private List<Paciente> pacientes;
	private Sala sala;
	private Profissional profissional;
	private String comentarios; //Comentários que podem ser adicionados a determinado horário
	//tais como: confirmado, cancelado, etc
	
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

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	public void setProfissional(int idProfissional){
		//TODO: implementar este método ou revisar a necessidade deste.
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
