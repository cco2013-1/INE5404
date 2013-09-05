package model.negocio;

/**
 * Classe Horario
 * Representa um intervalo de tempo no qual os pacientes são atendidos em determinada sala
 * Contém lista de pacientes atendidos no determinado horário
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.bancoDeDados.Database;
import model.negocio.Horario;
import model.bancoDeDados.SQLDatabase;
import model.auxiliar.Hora;
import model.pessoas.Paciente;
import model.pessoas.Profissional;

public class Horario {
	//Constantes
		private static final String TABELA_H = "horarios";
		private static final String TABELA_PH = "pacientes_horarios";
		private static final String[] COLUNAS_H = {"id_profissional","horario_inicio","horario_fim","id_sala","comentarios"};
		private static final String[] COLUNAS_PH= {"id_paciente","id_horario"};
	
	//Atributos
	private Hora inicio; //hora de início da sessão
	private Hora fim;	//hora do fim da sessão
	private List<Paciente> pacientes;
	private Sala sala;
	private Profissional profissional;
	private String comentarios; //Comentários que podem ser adicionados a determinado horário
	//tais como: confirmado, cancelado, etc
	private int idHorario;
	
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
	public int getID(){
		return this.idHorario;
	}
	private void gravarDados(){
		HashMap<String, Object> dados = new HashMap<String, Object>();
		
		dados.put(COLUNAS_H[0],  this.profissional.getID());
		dados.put(COLUNAS_H[1], this.inicio.toStringDB());
		dados.put(COLUNAS_H[2], this.fim.toStringDB());
		dados.put(COLUNAS_H[3], this.sala.getID());
		dados.put(COLUNAS_H[4], this.comentarios);
		
		Database db = new SQLDatabase();
		this.idHorario = db.gravar(Horario.TABELA_H,dados);
	}
	private void gravarDados1(){
		HashMap<String, Object> dados1 = new HashMap<String, Object>();
		
		for(int i=1; i<this.pacientes.size();i++){
			dados1.put(COLUNAS_PH[i], this.pacientes.get(i).getID());
		}
		dados1.put(COLUNAS_PH[this.pacientes.size()+1], this.idHorario);
	}
}
