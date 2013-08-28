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
	DadosContato dadosContato;

	//Construtor
	public Pessoa (DadosPessoais dadosPesoais, DadosContato dadosContato) {
		this.dadosPessoais = dadosPessoais;
		this.dadosContato = dadosContato;
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
				"\n"+"Telefone Celular: "+this.dadosContato.getTelefoneCelular() + 
				" Telefone Fixo: "+this.dadosContato.getTelefoneFixo()+
				"\n"+"Email: "+this.dadosContato.getEmail();
		return mensagem;
	}
}
