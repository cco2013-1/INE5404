package model;

/**
 * Interface DatabaseObject
 * Esta interface define métodos comuns a todos os objetos
 * que serão gravados em banco de dados.
 * 
 * Estes métodos incluem: gravarDados e consultar dados (por parametros
 * e por id)
 * @author vinicius
 *
 */
public interface DatabaseObject {
	
	/**
	 * Método getID()
	 * Este método deverá retornar o id atribuído
	 * a um objeto após sua gravação em um banco de dados.
	 * @return id Atribuído ao objeto gravado
	 */
	public int getID();
}
