package model;

public class Paciente extends Pessoa {
	private String tratamento;
	private Profissional profissional;
	
	public Paciente(String vNome, int vCPF, int vTelefoneMovel,
			int vTelefoneFixo, String vNascimento, String vEmail, String vTratamento, Profissional vProfissional) {
		super(vNome, vCPF, vTelefoneMovel, vTelefoneFixo, vNascimento, vEmail);
		tratamento = vTratamento;
		profissional = vProfissional;
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
