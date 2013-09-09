package model.negocio;

import java.util.HashMap;

import model.bancoDeDados.Database;
import model.bancoDeDados.SQLiteDatabase;

public class Tratamento {

	//constantes
	private static final String TABELA = "tratamento";
	private static final String[] COLUNAS = {"nome_tratamento"};
	
	
	//atributos
	private String tratamento;
	private int idTratamento;
	
	public Tratamento(String tratamento) {
		this.tratamento=tratamento;
	}
	public void gravarDados(){
		HashMap<String,Object> dados = new HashMap<String,Object>();
		
		dados.put(COLUNAS[0], this.tratamento);
		
		Database db = new SQLiteDatabase();
		this.idTratamento = db.gravar(Tratamento.TABELA,dados);
	}
	public int getID(){
		return this.idTratamento;
	}
	

}
