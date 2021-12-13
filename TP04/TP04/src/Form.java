/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 04 - Form.java
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Form extends Frame implements ActionListener{
    Button pesquisar, anterior, proximo;
    TextField pnome, txtnome, txtsalario, txtcargo;
    Label lblpnome, lblnome, lblsalario, lblcargo;
    ResultSet rs;
    ResultSet rs2;
    String sql="SELECT * FROM tbfuncs WHERE tbfuncs.nome_func=?";
    PreparedStatement preparedStatement;
    String sql2="SELECT * FROM tbcargos WHERE tbcargos.cd_cargo=?";
    PreparedStatement preparedStatement2;

    public Form(){
        JPanel a=new JPanel();
        JPanel b=new JPanel();
        JPanel c=new JPanel();
        JPanel d=new JPanel();

        a.setLayout(new BorderLayout());
        a.add(b,BorderLayout.NORTH);
        a.add(c, BorderLayout.CENTER);
        a.add(d, BorderLayout.SOUTH);
        a.setVisible(true);

        b.setLayout(new FlowLayout());
        lblpnome=new Label("Nome: ");
        pnome=new TextField("",20);
        b.add(lblpnome);
        b.add(pnome);
        b.setVisible(true);

        c.setLayout(new FlowLayout());
        pesquisar=new Button("Pesquisar");
        c.add(pesquisar);
        pesquisar.addActionListener(this);
        c.setVisible(true);

        d.setLayout(new GridLayout(4,2));
        lblnome=new Label("Nome: ",Label.LEFT);
        txtnome=new TextField("");
        txtnome.setEditable(false);
        lblsalario=new Label("Salario: ",Label.LEFT);
        txtsalario=new TextField("");
        txtsalario.setEditable(false);
        lblcargo=new Label("Cargo: ",Label.LEFT);
        txtcargo=new TextField("");
        txtcargo.setEditable(false);
        anterior=new Button("Anterior");
        proximo=new Button("Proximo");
        d.add(lblnome);
        d.add(txtnome);
        d.add(lblsalario);
        d.add(txtsalario);
        d.add(lblcargo);
        d.add(txtcargo);
        d.add(anterior);
        anterior.addActionListener(this);
        d.add(proximo);
        proximo.addActionListener(this);

        JFrame frame=new JFrame("TP04");
        frame.setSize(350,200);
        frame.add(a);
        frame.addWindowListener(new FechaJanela());
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        try{
            String url="jdbc:sqlserver://localhost\\SQLEXPRESS; databaseName=aulajava;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con;
            con = DriverManager.getConnection(url);
            System.out.println ("Conexao OK");
            DatabaseMetaData db = con.getMetaData();
            System.out.println("Conectado a "+db.getURL());
            System.out.println("Conexao "+db.getConnection());
            System.out.println("Driver "+db.getDriverName());
            System.out.println("Usuario "+db.getUserName());
            System.out.println("----------------------------------");
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }

        //new InserirTabela(); Código usado apenas uma vez, para preenchimento das tabelas do banco de dados aulajava
        new Form();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(preparedStatement==null){
            try{
                String url="jdbc:sqlserver://localhost\\SQLEXPRESS; databaseName=aulajava;integratedSecurity=true";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con;
                con = DriverManager.getConnection(url);
                preparedStatement=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                preparedStatement2=con.prepareStatement(sql2,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            }
            catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
        if(ae.getSource().equals(pesquisar)){
            try{
                preparedStatement.setString(1,pnome.getText());
                rs=preparedStatement.executeQuery();
                rs.next();
                txtnome.setText(rs.getString(2));
                txtsalario.setText(rs.getString(3));
                preparedStatement2.setString(1,rs.getString(4));
                rs2=preparedStatement2.executeQuery();
                rs2.next();
                txtcargo.setText(rs2.getString(2));
            }
            catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
        if(ae.getSource().equals(proximo)){
            try{
                rs.next();
                txtnome.setText(rs.getString(2));
                txtsalario.setText(rs.getString(3));
                preparedStatement2.setString(1,rs.getString(4));
                rs2=preparedStatement2.executeQuery();
                rs2.next();
                txtcargo.setText(rs2.getString(2));
            }
            catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
        if(ae.getSource().equals(anterior)){
            try{
                rs.previous();
                txtnome.setText(rs.getString(2));
                txtsalario.setText(rs.getString(3));
                preparedStatement2.setString(1,rs.getString(4));
                rs2=preparedStatement2.executeQuery();
                rs2.next();
                txtcargo.setText(rs2.getString(2));
            }
            catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
