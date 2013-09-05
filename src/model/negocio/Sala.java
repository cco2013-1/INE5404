package model.negocio;

public class Sala {
	
	//Atributos
	private String nome;
	private int idSala;
	
	public Sala(String nome){
		this.nome = nome;
	}
	
	public String nomeSala(){
		return nome;
	}
	public int getID(){
		return this.idSala;
	}
	
}
