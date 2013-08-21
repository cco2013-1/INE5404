/**
 * Class Pessoa
 * @author Matheus Ben-Hur
 * @author Vinicius Teixeira
 * 
 * Classe que representa uma pessoa, no
 * âmbito do projeto de softwar para clínica
 * de fisioterapia.
 *
 */
public abstract class Pessoa {
	
	//Atributos
	private String nome;
	private int cpf;
	private int telefoneMovel;
	private int telefoneFixo;
	private String nascimento;
	private String email;

	//Construtor
	public Pessoa (String nome, int cpf, int telefoneMovel, int telefoneFixo, 
			String nascimento, String email) {
		this.nome = nome;
		this.cpf=cpf;
		this.telefoneMovel=telefoneMovel;
		this.telefoneFixo=telefoneFixo;
		this.nascimento = nascimento;
		this.email=email;
	}
	
	/**
	 * Método toString
	 * Fornece representação do objeto em forma de 
	 * string
	 */
	@Override
	public String toString(){
		String mensagem = "Nome: "+this.nome+
				"\n"+"CPF: "+this.cpf+
				"\n"+"Data de Nascimento: "+this.nascimento+
				"\n"+"Telefone Celular: "+this.telefoneMovel+" Telefone Fixo: "+this.telefoneFixo+
				"\n"+"E-mail: "+this.email;
		return mensagem;
	}
	
	//Getters & Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return this.cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTelefoneMovel() {
		return this.telefoneMovel;
	}
	public void setTelefoneMovel(int telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}
	public int getTelefoneFixo() {
		return this.telefoneFixo;
	}
	public void setTelefoneFixo(int telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getNascimento() {
		return this.nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
