package model.negocio;

import model.bancoDeDados.DatabaseObject;

public class Sala implements DatabaseObject {
	
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
