package model;

/**
 * Classe Paciente
 * @author Matheus Ben-Hur
 * @author Vinicius Teixeira
 * 
 * Representa um Paciente no âmbito do projeto
 * de software para clínica de fisioterapia
 *
 */

public class Paciente extends Pessoa {
	private String tratamento;
	private Profissional profissional;
	
	public Paciente(DadosPessoais dadosPessoais, DadosContato dadosContato, String tratamento, 
			Profissional profissional) {
		super(dadosPessoais, dadosContato);
		this.tratamento = tratamento;
		this.profissional = profissional;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
}
