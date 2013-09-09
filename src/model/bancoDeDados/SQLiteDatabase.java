package model.bancoDeDados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDatabase implements Database {

    private static final String NOME_BANCO_DE_DADOS = "/Users/vinicius/"
            + "Dropbox/ComputerScience/workspace/INE5404/topphysio.db";

    private Connection con;

    public SQLiteDatabase() {
        
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e1) {
            System.out.println("biblioteca JDBC sqlite nao encontrada");
            e1.printStackTrace();
        }
        
        this.con = null;

        try {
            con = DriverManager.getConnection("jdbc:sqlite:"
                    + NOME_BANCO_DE_DADOS);
        }
        catch (SQLException e) {
            System.out.println("Falha ao abrir banco de dados.");
        }
    }

    @Override
    public int gravar(String tabela, Map<String, Object> dados) {
        // TODO Auto-generated method stub

        String sqlStatement = "INSERT INTO " + tabela + " (";

        ArrayList<String> colunas = new ArrayList<String>();
        ArrayList<Object> valores = new ArrayList<Object>();

        for (String s : dados.keySet()) {
            colunas.add(s);
            valores.add(dados.get(s));
        }

        /*
         * Loop para incluir os nomes das colunas na string sqlStatement
         */
        for (int i = 0; i < colunas.size() - 1; i++) {
            sqlStatement += colunas.get(i) + ", ";
        }
        sqlStatement += colunas.get(colunas.size() - 1);

        sqlStatement += ") VALUES (";

        /*
         * Loop para incluir os valores associados as colunas na string
         * sqlStatement
         */
        for (int i = 0; i < valores.size() - 1; i++) {
            sqlStatement += "\"" + valores.get(i).toString() + "\", ";
        }
        sqlStatement += "\"" + valores.get(valores.size() - 1).toString()
                + "\"";

        sqlStatement += ")";

        /*
         * Executar o comando SQL
         */
        Statement st;
        try {
            st = con.createStatement();
            st.setQueryTimeout(30); // 30 segundos para timeout
            st.executeUpdate(sqlStatement);
            ResultSet rs = st.executeQuery("SELECT last_insert_rowid()");
            
            while(rs.next()){
                int id = rs.getInt(1);
                System.out.println("Id: " + id);
                return id;
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
