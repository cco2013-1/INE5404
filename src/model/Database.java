package model;

import java.util.List;
import java.util.Map;

/**
 * Interface Database
 * Define os m�todos a serem implementados por um objeto de banco
 * de dados.
 * 
 * Conceito: Cada objeto deve conhecer sua respectiva tabela no banco
 * de dados e ser capaz de passar para o objeto que implementa a 
 * comunica��o um mapa relacionando as colunas com os valores a serem
 * gravados nestas posi��es.
 * 
 * Para consultar as tabelas, devem ser passadas as colunas, as tabelas
 * e os par�metros da consulta
 * 
 * Os m�todos desta interface n�o assumem a exist�ncia de uma conex�o
 * pr�via ao banco de dados. Na implementa��o deve ser avaliada a 
 * necessidade de realizar apenas uma conex�o (criando novos m�todos
 * na interface para conex�o e desconex�o) ou se cada m�todo pode
 * iniciar e encerrar sua pr�pria conex�o.
 * 
 * @author vinicius
 *
 */

public interface Database {
	
	/**
	 * M�todo gravar
	 * Este m�todo recebe como par�metros um mapa que relaciona
	 * colunas com os dados a serem gravados, bem como a tabela
	 * onde estes dados devem ser gravados.
	 * A consulta � da seguinte forma:
	 * INSERT INTO tabela (dados.keys < nomes das colunas >) 
	 * 		VALUES (dados.values < valores a serem gravados >)
	 * @param tabela Nome da tabela a ser consultado no banco de dados
	 * @param dados Dados a serem gravados na tabela indicada. A estrutura
	 * utilizada relaciona os nomes das colunas com os dados a serem 
	 * gravados em um mapa
	 * @return O id da linha que acaba de ser gravada (PRIMARY KEY 
	 * da linha gravada)
	 */
	public int gravar(String tabela, Map<String, Object> dados);
	
	/**
	 * M�todo consultar
	 * Recebe como par�metros uma lista de colunas, lista de tabelas e mapa
	 * de parametros para que seja realizada a consulta ao banco de dados.
	 * � retornado um mapa relacionando as colunas solicitadas com uma poss�vel
	 * lista de objetos retornados da consulta.
	 * A consulta realizada � da forma:
	 * SELECT colunas FROM tabelas WHERE parametros.key = parametros.value
	 * para todas as colunas, tabelas e parametros passados.
	 * Caso a lista de colunas passada esteja vazia, deve ser feita pesquisa
	 * de todas as colunas, ou seja, SELECT *
	 * @param colunas Lista de colunas a serem consultadas
	 * @param tabelas Lista de tabelas onde deve ser feita a consulta
	 * @param parametros Par�metros da consulta
	 * @return
	 */
	public Map<String, List<Object>> consultar(List<String> colunas, List<String> tabelas, 
			Map<String, Object> parametros);
	
	/**
	 * M�todo atualizar
	 * Atualiza o valor da coluna na tabela dada, alterando o dado para
	 * valor, caso a linha atenda ao crit�rio passado.
	 * A consulta realizada � da forma
	 * UPDATE tabela SET coluna = valor WHERE colunaCriterio = criterio
	 * @param tabela Tabela a ser atualizada
	 * @param coluna Coluna que ter� o valor alterado
	 * @param valor Novo valor a ser gravado na coluna
	 * @param colunaCriterio Coluna onde ser� pesquisado o crit�rio
 	 * @param criterio 
	 * @return true caso a atualiza��o tenha sido bem sucedida, falso caso contr�rio
	 */
	public boolean atualizar(String tabela, String coluna, Object valor, String colunaCriterio,
			Object criterio);
	

}
