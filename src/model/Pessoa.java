package model;
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
	DadosPessoais dadosPessoais;
	private int telefoneMovel;
	private int telefoneFixo;
	private String email;

	//Construtor
	public Pessoa (DadosPessoais dadosPesoais, int telefoneMovel, int telefoneFixo, String email) {
		this.dadosPessoais = dadosPessoais;
		this.telefoneMovel=telefoneMovel;
		this.telefoneFixo=telefoneFixo;
		this.email=email;
	}
	
	/**
	 * Método toString
	 * Fornece representação do objeto em forma de 
	 * string
	 */
	@Override
	public String toString(){
		String mensagem = "Nome: "+this.dadosPessoais.getNome()+
				"\n"+"CPF: "+ this.dadosPessoais.getCPF()+
				"\n"+"Data de Nascimento: "+ this.dadosPessoais.getDataNascimento() +
				"\n"+"Telefone Celular: "+this.telefoneMovel+" Telefone Fixo: "+this.telefoneFixo+
				"\n"+"E-mail: "+this.email;
		return mensagem;
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
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
