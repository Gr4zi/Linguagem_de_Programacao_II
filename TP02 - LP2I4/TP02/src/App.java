/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 02 - App
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class App extends Frame implements ActionListener {

    TextField txtnome, txtidade, txtendereço;
    Button btnok, btnlimpar, btnmostrar, btnsair;

    List<Aluno> alunos=new ArrayList<Aluno>();

    public App(){
        JPanel a=new JPanel();
        JPanel b=new JPanel();
        JPanel c=new JPanel();

        a.setLayout(new BorderLayout());
        a.add(b,BorderLayout.NORTH);
        a.add(c,BorderLayout.SOUTH);             
        
        b.setLayout(new GridLayout(3,2,10,10));
        b.add(new Label("Nome:"));
        txtnome=new TextField();
        b.add(txtnome);
        b.add(new Label("Idade:"));
        txtidade=new TextField();
        b.add(txtidade);
        b.add(new Label("Endereço:"));
        txtendereço=new TextField();
        b.add(txtendereço);
        b.setVisible(true);

        c.setLayout(new GridLayout(1,4));
        btnok=new Button("OK");
        c.add(btnok);
        btnok.addActionListener(this);
        btnlimpar=new Button("LIMPAR");
        c.add(btnlimpar);
        btnlimpar.addActionListener(this);
        btnmostrar=new Button("MOSTRAR");
        c.add(btnmostrar);
        btnmostrar.addActionListener(this);
        btnsair=new Button("SAIR");
        c.add(btnsair);
        btnsair.addActionListener(this);
        c.setVisible(true);

        JFrame frame = new JFrame("TP02 - LP2I4");
        frame.setSize(400, 180);
        frame.add(a);
        frame.addWindowListener(new FechaJanela());
        frame.setVisible(true);
    }
    
    public static void main(String[] args) throws Exception {
        new App();     
    }

    public void cadastrarAluno(){
        Aluno aluno=new Aluno();
        aluno.setNome(txtnome.getText());
        aluno.setIdade(Integer.parseInt(txtidade.getText()));
        aluno.setEndereço(txtendereço.getText());
        alunos.add(aluno);
    }

    public void limparRegistro(){
        txtnome.setText("");
        txtidade.setText("");
        txtendereço.setText("");
    }

    public void mostrarRegistro(){
        String mensagem="Resultado: \n";
        for (Aluno aluno : alunos) {
            mensagem+=aluno.toString();
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(btnok)){
            cadastrarAluno();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            limparRegistro();
        }

        if(ae.getSource().equals(btnlimpar)){
            limparRegistro();
        }

        if(ae.getSource().equals(btnmostrar)){
            mostrarRegistro();
        }

        if(ae.getSource().equals(btnsair)){
            System.exit(0);
        }
    }

}
