package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private int idDadosPessoais; //Id dos dados pessoais gravados.
	private int idDadosContato;

	public Profissional( DadosPessoais dadosPessoais, DadosContato dadosContato) {
		super( dadosPessoais, dadosContato);
		this.idDadosPessoais = dadosPessoais.getID();
		this.idDadosContato = dadosContato.getID();
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
		
		dados.put(COLUNAS[0], this.idDadosPessoais);
		dados.put(COLUNAS[1], this.idDadosContato);
		
		Database db = new SQLDatabase();
		
		this.idProfissional = db.gravar(Profissional.TABELA, dados);
	}

	@Override
	public int getID() {
		return this.idProfissional;
	}

}
