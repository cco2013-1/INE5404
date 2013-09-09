package model.negocio;

/**
 * Classe Horario
 * Representa um intervalo de tempo no qual os pacientes são atendidos em determinada sala
 * Contém lista de pacientes atendidos no determinado horário
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sun.tools.tree.ThisExpression;
import model.bancoDeDados.Database;
import model.bancoDeDados.DatabaseObject;
import model.negocio.Horario;
import model.bancoDeDados.SQLiteDatabase;
import model.auxiliar.Hora;
import model.pessoas.Paciente;
import model.pessoas.Profissional;

public class Horario implements DatabaseObject {
	//Constantes
		private static final String TABELA = "horario";
		private static final String TABELA_PH = "paciente_horario";
		private static final String[] COLUNAS = { "horario_inicio", "horario_fim", 
			"id_profissional", "id_tratamento", "id_sala", "comentarios" };
		private static final String[] COLUNAS_PH= {"id_horario", "id_paciente",};
	
	//Atributos
	private Hora inicio; //hora de início da sessão
	private Hora fim;	//hora do fim da sessão
	private List<Paciente> pacientes;
	private Sala sala;
	private Tratamento tratamento;
	private Profissional profissional;
	private String comentarios; //Comentários que podem ser adicionados a determinado horário
	//tais como: confirmado, cancelado, etc
	private int idHorario;
	
	
	public Horario(Hora inicio, Hora fim, Sala sala){
		this.inicio = inicio;
		this.fim = fim;
		this.sala = sala;
		this.pacientes = new ArrayList<Paciente>();
		
		//Grava dados no Banco de Dados
		this.gravarDados();
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}
	
	public void adicionaPaciente(Paciente p) {
		pacientes.add(p);
		
		//Grava dados no banco de dados
		HashMap<String, Object> dadosPacienteHorario = new HashMap<String, Object>();
		Database db = new SQLiteDatabase();
		dadosPacienteHorario.put(COLUNAS_PH[0], this.getID());
		dadosPacienteHorario.put(COLUNAS_PH[1], p.getID());
		db.gravar(TABELA_PH, dadosPacienteHorario);
	}

	public Hora getInicio() {
		return inicio;
	}

	public Hora getFim() {
		return fim;
	}
	
	public Sala getSala() {
		return sala;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	public Tratamento getTratamento() {
		return this.tratamento;
	}
	
	public void setTratamento(Tratamento tratamento) {
		this.tratamento=tratamento;
	}
	
	public int getID() {
		return this.idHorario;
	}
	
	private void gravarDados() {
		HashMap<String, Object> dados = new HashMap<String, Object>();
		
		dados.put(COLUNAS[0], this.inicio.toStringDB());
		dados.put(COLUNAS[1], this.fim.toStringDB());
		dados.put(COLUNAS[2], this.profissional.getID());
		dados.put(COLUNAS[3], this.tratamento.getID());
		dados.put(COLUNAS[4], this.sala.getID());
		dados.put(COLUNAS[5], this.comentarios);
	
		Database db = new SQLiteDatabase();
		this.idHorario = db.gravar(Horario.TABELA,dados);
		this.gravarDadosPacienteHorario();
	}
	
	/**
	 * Método gravarDadosPacienteHorario
	 * Grava os dados na tabela pacientes_horario
	 * A tabela é composta de duas entradas apenas
	 * id_pacientes e id_horario
	 * Para cada horário, podem existir vários pacientes.
	 */
	private void gravarDadosPacienteHorario() {
		HashMap<String, Object> dadosPacienteHorario = new HashMap<String, Object>();
		Database db = new SQLiteDatabase();
		
		for (int i = 0; i < this.pacientes.size(); i++) {
			dadosPacienteHorario.put(COLUNAS_PH[0], this.getID());
			dadosPacienteHorario.put(COLUNAS_PH[1], this.pacientes.get(i).getID());
			db.gravar(TABELA_PH, dadosPacienteHorario);
			dadosPacienteHorario.clear();
		}
		
	}
		
}
