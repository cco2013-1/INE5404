package model;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Classe DadosPessoais
 * Gerencia os dados pessoais de Pessoas
 * @author vinicius
 *
 */
public class DadosPessoais implements DatabaseObject {
	
	/*
	 * Constantes:
	 */
	private static final String TABELA = "dados_pessoais";
	private static final String[] COLUNAS = {"nome", "data_nasc", "cpf", "rg"};
	
	/*
	 * Atributos
	 */
	private String nome;
	private Data dataNascimento;
	private String CPF;
	private String RG;
	private int databaseID; //Id atribu�do quando gravado o objeto no banco de dados.
	
	public DadosPessoais(String nome, Data dataNascimento, String CPF, String RG) throws IOException{
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		if(this.validaCPF(CPF)) this.CPF = formataCPF(CPF);
		else throw new IOException("CPF inv�lido");
		this.RG = RG;
		this.gravarDados();
	}
	
	/**
	 * M�todo validaCPF
	 * Verifica se o CPF fornecido � v�lido
	 * Retirado de: http://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097
	 * @param cpf
	 * @return
	 */
	private boolean validaCPF(String CPF){
		
		CPF = formataCPF(CPF);
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (	CPF.equals("00000000000") || CPF.equals("11111111111") || 
				CPF.equals("22222222222") || CPF.equals("33333333333") || 
				CPF.equals("44444444444") || CPF.equals("55555555555") || 
				CPF.equals("66666666666") || CPF.equals("77777777777") || 
				CPF.equals("88888888888") || CPF.equals("99999999999") || 
				(CPF.length() != 11)) 
			return(false);
		
		char dig10, dig11; //D�gitos verificadores
		int sm, i, r, num, peso;
		
		// "try" - protege o codigo para eventuais erros de conversao de tipo (int) 
		try { 
			// Calculo do 1o. Digito Verificador
			sm = 0; peso = 10;
			for (i=0; i<9; i++) { 
				// converte o i-esimo caractere do CPF em um numero: 
				// por exemplo, transforma o caractere '0' no inteiro 0 
				// (48 eh a posicao de '0' na tabela ASCII)
				
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			
			r = 11 - (sm % 11);
			
			if ( (r == 10) || (r == 11) )
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
			
			// Calculo do 2o. Digito Verificador
			
			sm = 0; peso = 11;
			
			for(i=0; i<10; i++) {
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			
			r = 11 - (sm % 11);
			
			if ( (r == 10) || (r == 11) )
				dig11 = '0';
			else dig11 = (char)(r + 48);
			
			// Verifica se os digitos calculados conferem com os digitos informados.
			
			if ( ( dig10 == CPF.charAt(9) ) && ( dig11 == CPF.charAt(10) ) )
				return(true);
			else return(false);
		}
		catch (InputMismatchException erro) { 
			return(false); 
		}
	}
	
	
	private String formataCPF(String CPF){
		while ( CPF.contains(".") )
			CPF = CPF.substring(0, CPF.indexOf(".")) + CPF.substring(CPF.indexOf(".") + 1);
		
		while ( CPF.contains("-") )
			CPF = CPF.substring(0, CPF.indexOf("-")) + CPF.substring(CPF.indexOf("-") + 1);
		
		return CPF;
	}
	
	/**
	 * Grava os dados no banco de dados e 
	 * @return
	 */
	private void gravarDados() {
		HashMap<String, Object> dados = new HashMap<String, Object>();
		
		dados.put(COLUNAS[0], this.nome);
		dados.put(COLUNAS[1], this.dataNascimento.toStringDB());
		dados.put(COLUNAS[2], this.CPF);
		dados.put(COLUNAS[3], this.RG);
		
		Database db = new SQLDatabase();
		
		this.databaseID = db.gravar(DadosPessoais.TABELA, dados);
	}
	
	@Override
	public int getID(){
		return this.databaseID;
	}

	//Getters
	
	public String getNome() {
		return nome;
	}

	public String getDataNascimento() {
		return dataNascimento.toString();
	}

	public String getCPF() {
		return CPF;
	}

	public String getRG() {
		return RG;
	}
}