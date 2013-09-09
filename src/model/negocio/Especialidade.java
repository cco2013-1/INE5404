package model.negocio;
import java.util.HashMap;
import java.util.List;

import model.bancoDeDados.Database;
import model.bancoDeDados.SQLiteDatabase;

public class Especialidade {
	
	//Constantes
	private static final String TABELA = "especialidade";
	private static final String[] COLUNAS = {"id_tratamento"}; 
	
	
	//Atributos
	private List<Tratamento> tratamento;
	private int idEspecialidade;

	public Especialidade(List<Tratamento> tratamento) {
		this.tratamento = tratamento;
		
	}

	public List<Tratamento> getTratamento() {
		return tratamento;
	}
	
	public void gravarDados(){
		HashMap<String,Object> dados = new HashMap<String, Object>();
		
		for(int i=0; i<tratamento.size();i++){
			dados.put(COLUNAS[0], this.tratamento.get(i).getID());
		}
		Database db = new SQLiteDatabase();
		this.idEspecialidade = db.gravar(Especialidade.TABELA,dados);
	}
	public int getID(){
		return this.idEspecialidade;
	}

}
