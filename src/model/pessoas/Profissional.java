package model.pessoas;

import java.util.HashMap;
import java.util.Map;

import model.bancoDeDados.Database;
import model.bancoDeDados.DatabaseObject;
import model.bancoDeDados.SQLDatabase;

public class Profissional extends Pessoa implements DatabaseObject {
	
	/*
	 * Constantes
	 */
	private static final String TABELA = "profissional";
	private static final String[] COLUNAS = { "id_dados_pessoais", "id_dados_contato" };
	
	
	/*
	 * Atributos
	 */
	private int idProfissional; //Id do profissional, conforme gravado no banco de dados.


	public Profissional( DadosPessoais dadosPessoais, DadosContato dadosContato) {
		super( dadosPessoais, dadosContato);
		this.gravarDados();
	}
	
	/**
	 * Método fromDb
	 * Gera novo objeto da classe Profissional, baseado em uma consulta
	 * ao banco de dados.
	 * @param consultaDb Mapa resultante de consulta ao banco de dados, conforme
	 * inteface Database
	 * @return Profissional resultante da consulta ao banco de dados, null se nenhum
	 * for encontrado
	 */
	public static Profissional fromDb(Map<String, Object> consultaDb){
		//TODO: implementar este método
		return null;
	}
	
	/**
	 * Método fromDb
	 * Gera novo objeto da classe Profissional, consultando o banco de dados
	 * pelo idProfissional passado como argumento ao método.
	 * @param idProfissional id do Profissional armazenado no banco de dados
	 * @return Novo objeto Profissional, ou null caso nao seja encontrado
	 */
	public static Profissional fromDb(int idProfissional){
		//TODO: implementar este método
		return null;
	}
	
	private void gravarDados(){
		HashMap<String, Object> dados = new HashMap<String, Object>();
		
		dados.put(COLUNAS[0], this.dadosPessoais.getID());
		dados.put(COLUNAS[1], this.dadosContato.getID());
		
		Database db = new SQLDatabase();
		
		this.idProfissional = db.gravar(Profissional.TABELA, dados);
	}

	@Override
	public int getID() {
		return this.idProfissional;
	}

}
