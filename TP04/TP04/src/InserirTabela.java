/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 04 - InserirTabela.java
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

import java.sql.*;

public class InserirTabela {
    public static void main (String args []){
        try{
            String url="jdbc:sqlserver://localhost\\SQLEXPRESS; databaseName=aulajava;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con;
            con = DriverManager.getConnection(url);
            System.out.println ("Conexao OK");
            Statement st=con.createStatement();
            String x="INSERT INTO tbcargos (ds_cargo) VALUES ('Analista de Sistemas');";
            st.executeUpdate(x);

            x="INSERT INTO tbcargos (ds_cargo) VALUES ('Desenvolvedor Junior');";
            st.executeUpdate(x);

            x="INSERT INTO tbcargos (ds_cargo) VALUES ('Desenvolvedor Pleno');";
            st.executeUpdate(x);

            x="INSERT INTO tbcargos (ds_cargo) VALUES ('Desenvolvedor Senior');";
            st.executeUpdate(x);

            x="INSERT INTO tbcargos (ds_cargo) VALUES ('Programador FullStack');";
            st.executeUpdate(x);

            x="INSERT INTO tbfuncs (nome_func,sal_func,cod_cargo) VALUES ('João','5000','1');";
            st.executeUpdate(x);

            x="INSERT INTO tbfuncs (nome_func,sal_func,cod_cargo) VALUES ('Maria','6000','5');";
            st.executeUpdate(x);

            x="INSERT INTO tbfuncs (nome_func,sal_func,cod_cargo) VALUES ('João','3500','2');";
            st.executeUpdate(x);

            x="INSERT INTO tbfuncs (nome_func,sal_func,cod_cargo) VALUES ('Maria','4000','3');";
            st.executeUpdate(x);

            x="INSERT INTO tbfuncs (nome_func,sal_func,cod_cargo) VALUES ('João','6500','4');";
            st.executeUpdate(x);

            x="INSERT INTO tbfuncs (nome_func,sal_func,cod_cargo) VALUES ('Maria','7500','1');";
            st.executeUpdate(x);

            con.close();
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
