/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 04 - ListaTabela.java
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

import java.sql.*;

public class ListaTabela {
    public static void main(String[] args) throws Exception {
        try{
            String url="jdbc:sqlserver://localhost\\SQLEXPRESS; databaseName=aulajava;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con;
            con = DriverManager.getConnection(url);
            System.out.println ("Conexao OK");
            Statement st=con.createStatement();
            ResultSet rs;
            rs=st.executeQuery("SELECT * FROM tbfuncs WHERE tbfuncs.nome_func LIKE 'João';");
            mostraRS(rs);
            con.close();
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void mostraRS(ResultSet rs) throws SQLException{
        int i;
        ResultSetMetaData rsmd = rs.getMetaData();
        int numcols = rsmd.getColumnCount();
        System.out.println("Total de colunas: "+numcols);
        for (i=1;i<=numcols;i++)
            System.out.print(rsmd.getColumnLabel(i)+" , ");
        System.out.println("\n");
        while(rs.next()){
            for(i=1;i<=numcols;i++){
                System.out.print(rs.getString(i)+" - ");
            }
            System.out.print("\n");
        }
    }
}
