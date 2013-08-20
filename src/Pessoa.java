public class Pessoa {

	private String nome;
	private int cpf;
	private int telefoneMovel;
	private int telefoneFixo;
	private String tratamento;
	private String nascimento;
	private String email;

	public Pessoa (String vNome, int vCPF, int vTelefoneMovel,int vTelefoneFixo, String vTratamento, String vNascimento,String vEmail) {
		nome = vNome;
		cpf=vCPF;
		telefoneMovel=vTelefoneMovel;
		telefoneFixo=vTelefoneFixo;
		tratamento=vTratamento;
		nascimento = vNascimento;
		email=vEmail;
	}
	public String toString(){
		String mensagem = "Nome: "+this.nome+
				"\n"+"CPF: "+this.cpf+
				"\n"+"Data de Nascimento: "+this.nascimento+
				"\n"+"Telefone Celular: "+this.telefoneMovel+" Telefone Fixo: "+this.telefoneFixo+
				"\n"+"E-mail: "+this.email+
				"\n"+"Tratamento: "+this.tratamento;
		return mensagem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTelefoneMovel() {
		return telefoneMovel;
	}
	public void setTelefoneMovel(int telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}
	public int getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(int telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTratamento() {
		return tratamento;
	}
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
