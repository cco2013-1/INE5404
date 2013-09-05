package model.pessoas;

import java.util.HashMap;

import model.bancoDeDados.Database;
import model.bancoDeDados.DatabaseObject;
import model.bancoDeDados.SQLDatabase;
/**
 * Classe Paciente
 * @author Matheus Ben-Hur
 * @author Vinicius Teixeira
 * 
 * Representa um Paciente no âmbito do projeto
 * de software para clínica de fisioterapia
 *
 */

public class Paciente extends Pessoa implements DatabaseObject {
/*
 * constantes
 */
	public static final String TABELA = "paciente";
	public static final String[] COLUNAS = {"id_dados_pessoais","id_dados_contato"};
/*
 * atributos	
 */

	private int idPaciente;
	
	public Paciente(DadosPessoais dadosPessoais, DadosContato dadosContato){
		super(dadosPessoais, dadosContato);
		this.gravarDados();
	}
	public void gravarDados(){
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put(COLUNAS[0], this.dadosPessoais.getID());
		dados.put(COLUNAS[1], this.dadosContato.getID());
		
		Database db = new SQLDatabase();
		this.idPaciente = db.gravar(Paciente.TABELA,dados);
	}
	@Override
	public int getID() {
		
		return this.idPaciente;
		
	}
 
	
}
