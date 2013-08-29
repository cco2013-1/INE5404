package model;
import java.util.HashMap;
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
	public static final String[] COLUNAS = {"id_tratamento","id_profissional"};
/*
 * atributos	
 */
	private int idDadosPessoais;
	private int idDadosContato;
	private int idPaciente;
	
	public Paciente(DadosPessoais dadosPessoais, DadosContato dadosContato){
		super(dadosPessoais, dadosContato);
		this.idDadosPessoais=dadosPessoais.getID();
		this.idDadosContato=dadosContato.getID();
		this.gravarDados();
	}
	public void gravarDados(){
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put(COLUNAS[0], this.idDadosPessoais);
		dados.put(COLUNAS[1], this.idDadosContato);
		
		Database db = new SQLDatabase();
		this.idPaciente = db.gravar(Paciente.TABELA,dados);
	}
	@Override
	public int getID() {
		
		return this.idPaciente;
		
	}
 
	
}
