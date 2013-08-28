package model;

import java.util.List;
import java.util.Map;

/**
 * Interface Database
 * Define os métodos a serem implementados por um objeto de banco
 * de dados.
 * 
 * Conceito: Cada objeto deve conhecer sua respectiva tabela no banco
 * de dados e ser capaz de passar para o objeto que implementa a 
 * comunicação um mapa relacionando as colunas com os valores a serem
 * gravados nestas posições.
 * 
 * Para consultar as tabelas, devem ser passadas as colunas, as tabelas
 * e os parâmetros da consulta
 * 
 * Os métodos desta interface não assumem a existência de uma conexão
 * prévia ao banco de dados. Na implementação deve ser avaliada a 
 * necessidade de realizar apenas uma conexão (criando novos métodos
 * na interface para conexão e desconexão) ou se cada método pode
 * iniciar e encerrar sua própria conexão.
 * 
 * @author vinicius
 *
 */

public interface Database {
	
	/**
	 * Método gravar
	 * Este método recebe como parâmetros um mapa que relaciona
	 * colunas com os dados a serem gravados, bem como a tabela
	 * onde estes dados devem ser gravados.
	 * A consulta é da seguinte forma:
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
	 * Método consultar
	 * Recebe como parâmetros uma lista de colunas, lista de tabelas e mapa
	 * de parametros para que seja realizada a consulta ao banco de dados.
	 * É retornado um mapa relacionando as colunas solicitadas com uma possível
	 * lista de objetos retornados da consulta.
	 * A consulta realizada é da forma:
	 * SELECT colunas FROM tabelas WHERE parametros.key = parametros.value
	 * para todas as colunas, tabelas e parametros passados.
	 * Caso a lista de colunas passada esteja vazia, deve ser feita pesquisa
	 * de todas as colunas, ou seja, SELECT *
	 * @param colunas Lista de colunas a serem consultadas
	 * @param tabelas Lista de tabelas onde deve ser feita a consulta
	 * @param parametros Parâmetros da consulta
	 * @return
	 */
	public Map<String, List<Object>> consultar(List<String> colunas, List<String> tabelas, 
			Map<String, Object> parametros);
	
	/**
	 * Método atualizar
	 * Atualiza o valor da coluna na tabela dada, alterando o dado para
	 * valor, caso a linha atenda ao critério passado.
	 * A consulta realizada é da forma
	 * UPDATE tabela SET coluna = valor WHERE colunaCriterio = criterio
	 * @param tabela Tabela a ser atualizada
	 * @param coluna Coluna que terá o valor alterado
	 * @param valor Novo valor a ser gravado na coluna
	 * @param colunaCriterio Coluna onde será pesquisado o critério
 	 * @param criterio 
	 * @return true caso a atualização tenha sido bem sucedida, falso caso contrário
	 */
	public boolean atualizar(String tabela, String coluna, Object valor, String colunaCriterio,
			Object criterio);
	

}
