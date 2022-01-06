/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 06 - Classe Form.java
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

public class Form extends JFrame implements ActionListener {
    JButton incluir, limpar, mostrar, sair;
    JTextField txtnome, txtidade, txtpeso, txtaltura, txtobjetivo;
    JLabel lblnome, lblidade, lblpeso, lblaltura, lblobjetivo;
    
    public Form(){
        JPanel pnla=new JPanel();
        JPanel pnlb=new JPanel();
        JPanel pnlc=new JPanel();
        
        pnla.setLayout(new BorderLayout());
        pnla.add(pnlb,BorderLayout.NORTH);
        pnla.add(pnlc,BorderLayout.SOUTH);
        pnla.setVisible(true);
        
        pnlb.setLayout(new GridLayout(5,2,10,10));
        lblnome=new JLabel("Nome: ");
        pnlb.add(lblnome);
        txtnome=new JTextField();
        pnlb.add(txtnome);
        lblidade=new JLabel("Idade: ");
        pnlb.add(lblidade);
        txtidade=new JTextField();
        pnlb.add(txtidade);
        lblpeso=new JLabel("Peso: ");
        pnlb.add(lblpeso);
        txtpeso=new JTextField();
        pnlb.add(txtpeso);
        lblaltura=new JLabel("Altura: ");
        pnlb.add(lblaltura);
        txtaltura=new JTextField();
        pnlb.add(txtaltura);
        lblobjetivo=new JLabel("Objetivo: ");
        pnlb.add(lblobjetivo);
        txtobjetivo=new JTextField();
        pnlb.add(txtobjetivo);
        pnlb.setVisible(true);
        
        pnlc.setLayout(new GridLayout(1,4));
        incluir=new JButton("Incluir");
        incluir.addActionListener(this);
        pnlc.add(incluir);
        limpar=new JButton("Limpar");
        limpar.addActionListener(this);
        pnlc.add(limpar);
        mostrar=new JButton("Apresentar dados");
        mostrar.addActionListener(this);
        pnlc.add(mostrar);
        sair=new JButton("Sair");
        sair.addActionListener(this);
        pnlc.add(sair);
        pnlc.setVisible(true);
        
        JFrame frame=new JFrame("Academia Boa Forma - Cadastro de alunos");
        frame.setSize(700, 225);
        frame.add(pnla);
        frame.addWindowListener(new FechaJanela());
        frame.setVisible(true);
    }
    
    public static void main(String[] args)throws Exception{
        try{
            String url="jdbc:sqlserver://localhost\\SQLEXPRESS; databaseName=tp05;integratedSecurity=true";
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
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
        new Form();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(incluir)){
            Boolean erro=false;
            String choice=txtidade.getText();
            try{
                Integer.parseInt(choice);
            }
            catch(NumberFormatException e){
                erro=true;
                JOptionPane.showMessageDialog(null, "Erro! Campo idade deve ser um número!");
            }
            choice=txtpeso.getText();
            try{
                Float.parseFloat(choice);
            }
            catch(NumberFormatException e){
                erro=true;
                JOptionPane.showMessageDialog(null, "Erro! Campo Peso deve ser um número decimal! (Utilizar ponto no lugar da vírgula)");
            }
            choice=txtaltura.getText();
            try{
                Float.parseFloat(choice);
            }
            catch(NumberFormatException e){
                erro=true;
                JOptionPane.showMessageDialog(null, "Erro! Campo Altura deve ser um número decimal! (Utilizar ponto no lugar da vírgula)");
            }
            
            if(erro==false){
               String nome=txtnome.getText();
               String idade=txtidade.getText();
               String peso=txtpeso.getText();
               String altura=txtaltura.getText();
               String objetivo=txtobjetivo.getText();
               
                try{
                    String url="jdbc:sqlserver://localhost\\SQLEXPRESS; databaseName=tp05;integratedSecurity=true";
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection con;
                    con = DriverManager.getConnection(url);
                    Statement st=con.createStatement();
                    String x="INSERT INTO tblaluno (Nome,Idade,Peso,Altura,Objetivo) VALUES ('"+nome+"','"+idade+"','"+peso+"','"+altura+"','"+objetivo+"')";
                    st.executeUpdate(x);
                    con.close();
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                }
                catch(ClassNotFoundException | SQLException e){
                    System.out.println("Erro: " + e.getMessage());
                } 
            }
        }
        
        if(ae.getSource().equals(limpar)){
            txtnome.setText("");
            txtidade.setText("");
            txtpeso.setText("");
            txtaltura.setText("");
            txtobjetivo.setText("");
        }
        
        if(ae.getSource().equals(mostrar)){
            List<Aluno> alunos=new ArrayList();
            List<Aluno> alunos2=new ArrayList();
            
            try{
                    String url="jdbc:sqlserver://localhost\\SQLEXPRESS; databaseName=tp05;integratedSecurity=true";
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection con;
                    con = DriverManager.getConnection(url);
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("SELECT * FROM tblaluno;");                    
                    while(rs.next()){
                        alunos.add(new Aluno(rs.getString(1),rs.getInt(2),rs.getFloat(3),rs.getFloat(4),rs.getString(5)));
                    }
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String teste=gson.toJson(alunos);
                    JOptionPane.showMessageDialog(null, teste);
                    con.close();
                }
                catch(ClassNotFoundException | SQLException e){
                    System.out.println("Erro: " + e.getMessage());
                }
        }
        
        if(ae.getSource().equals(sair)){
            System.exit(0);
        }        
    }         
}
