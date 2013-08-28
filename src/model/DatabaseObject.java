package model;

/**
 * Interface DatabaseObject
 * Esta interface define m�todos comuns a todos os objetos
 * que ser�o gravados em banco de dados.
 * 
 * Estes m�todos incluem: gravarDados e consultar dados (por parametros
 * e por id)
 * @author vinicius
 *
 */
public interface DatabaseObject {
	
	/**
	 * M�todo getID()
	 * Este m�todo dever� retornar o id atribu�do
	 * a um objeto ap�s sua grava��o em um banco de dados.
	 * @return id Atribu�do ao objeto gravado
	 */
	public int getID();
}
