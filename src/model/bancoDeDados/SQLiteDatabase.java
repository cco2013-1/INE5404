package model.bancoDeDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

/**
 * Classe SQLiteDatabase Implementa a interface Database utilizando SQLite. É
 * utilizado o seguinte JDBC: https://bitbucket.org/xerial/sqlite-jdbc/
 * 
 * @author vinicius
 * 
 */
public class SQLiteDatabase implements Database {

    private static final String NOME_BANCO_DE_DADOS = "topphysio.db";

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
            /*
             * Garantir que foreign_keys estao habilitadas Fonte:
             * http://code-know
             * -how.blogspot.ru/2011/10/how-to-enable-foreign-keys
             * -in-sqlite3.html
             */
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);

            con = DriverManager.getConnection("jdbc:sqlite:"
                    + NOME_BANCO_DE_DADOS, config.toProperties());
        }
        catch (SQLException e) {
            System.out.println("Falha ao abrir banco de dados.");
        }
    }

    @Override
    public int gravar(String tabela, Map<String, Object> dados) {

        String sql = "INSERT INTO " + tabela + " (";

        ArrayList<String> colunas = new ArrayList<String>();
        ArrayList<Object> valores = new ArrayList<Object>();

        for (String s : dados.keySet()) {
            colunas.add(s);
            valores.add(dados.get(s));
        }

        /*
         * Loop para incluir os nomes das colunas na string sql
         */
        for (int i = 0; i < colunas.size() - 1; i++) {
            sql += colunas.get(i) + ", ";
        }
        sql += colunas.get(colunas.size() - 1);

        sql += ") VALUES (";

        /*
         * Loop para incluir os valores associados as colunas na string sql
         */
        for (int i = 0; i < valores.size() - 1; i++) {
            sql += "\"" + valores.get(i).toString() + "\", ";
        }
        sql += "\"" + valores.get(valores.size() - 1).toString() + "\"";

        sql += ")";

        /*
         * Executar o comando SQL
         */
        Statement st;
        try {
            st = con.createStatement();
            st.setQueryTimeout(30); // 30 segundos para timeout
            st.executeUpdate(sql);
            ResultSet rs = st.executeQuery("SELECT last_insert_rowid()");

            while (rs.next()) {
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
