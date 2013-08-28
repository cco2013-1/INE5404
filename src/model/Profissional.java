package model;

import java.util.List;
import java.util.Map;

public class Profissional extends Pessoa {

	public Profissional(String nome, int cpf, int telefoneMovel,
			int telefoneFixo, String nascimento, String email) {
		super(nome, cpf, telefoneMovel, telefoneFixo, nascimento, email);
		
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

}
