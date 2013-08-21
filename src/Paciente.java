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
	
	public Paciente(String nome, int cpf, int telefoneMovel,
			int telefoneFixo, String nascimento, String email, String tratamento, 
			Profissional profissional) {
		super(nome, cpf, telefoneMovel, telefoneFixo, nascimento, email);
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
