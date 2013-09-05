package model.negocio;
import java.util.List;

public class Especialidade {
	
	//Constantes
	private static final String TABELA = "especialidades";
	
	
	//Atributos
	private List<Tratamento> tratamento;
	

	public Especialidade(List<Tratamento> tratamento) {

		
	}

	public List<Tratamento> getTratamento() {
		return tratamento;
	}
	

}
