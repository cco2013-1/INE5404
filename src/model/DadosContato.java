package model;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.validator.routines.EmailValidator;

public class DadosContato implements DatabaseObject {

	/*
	 * Constantes
	 */
	private static final String TABELA = "dados_contato";
	private static final String[] COLUNAS = { "tel_fixo", "tel_cel", "email" };
	
	/*
	 * Atributos
	 */
	private int idDadosContato;
	private String telefoneFixo;
	private String telefoneCelular;
	private String email;
	
	public DadosContato(String telefoneFixo, String telefoneCelular, String email) throws IOException{
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		
		/*
		 * Validação de email
		 * Ver: http://stackoverflow.com/questions/2762977/regular-expression-for-email-validation-in-java
		 * e http://commons.apache.org/proper/commons-validator/download_validator.cgi
		 */
		if(email.length() > 0 && EmailValidator.getInstance().isValid(email)) this.email = email;
		else if(email.length() == 0) this.email = email;
		else throw new IOException("Email inválido");
		
		gravarDados();
	}
	
	/**
	 * Grava os dados no banco de dados e 
	 * grava valor do id do objeto gravado
	 * no atribuo idDadosContato
	 * @return
	 */
	private void gravarDados() {
		HashMap<String, Object> dados = new HashMap<String, Object>();
		
		dados.put(COLUNAS[0], this.telefoneFixo);
		dados.put(COLUNAS[1], this.telefoneCelular);
		dados.put(COLUNAS[2], this.email);
		
		Database db = new SQLDatabase();
		
		this.idDadosContato = db.gravar(DadosContato.TABELA, dados);
	}

	@Override
	public int getID() {
		return this.idDadosContato;
	}


	/*
	 * Getters
	 */
	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public String getEmail() {
		return email;
	}
	
}
