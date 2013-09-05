package model.bancoDeDados;

import java.util.List;
import java.util.Map;

public class SQLDatabase implements Database {

	@Override
	public int gravar(String tabela, Map<String, Object> dados) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, List<Object>> consultar(List<String> colunas,
			List<String> tabelas, Map<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizar(String tabela, String coluna, Object valor,
			String colunaCriterio, Object criterio) {
		// TODO Auto-generated method stub
		return false;
	}

}
