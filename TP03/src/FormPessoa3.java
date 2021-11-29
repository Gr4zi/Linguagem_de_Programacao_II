/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 03 - FormPessoa3.java
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class FormPessoa3 extends Frame implements ActionListener{
    Button btnok,btnlimpar,btnmostrar,btnsair;
    TextField txtnumero,txtnome,txtidade;
    JRadioButton rb1,rb2;

    List<Pessoa> pessoas=new ArrayList<Pessoa>();
    Pessoa UmaPessoa=new Pessoa();

    public FormPessoa3(){
        JPanel a=new JPanel();
        JPanel b=new JPanel();
        JPanel c=new JPanel();

        a.setLayout(new BorderLayout());
        a.add(b,BorderLayout.NORTH);
        a.add(c,BorderLayout.SOUTH);

        b.setLayout(new GridLayout(4,2));
        b.add(new Label("Numero: "));
        txtnumero=new TextField();
        txtnumero.setEditable(false);
        txtnumero.setText(String.valueOf(Pessoa.getKp()));
        b.add(txtnumero);
        b.add(new Label("Nome: "));
        txtnome=new TextField();
        b.add(txtnome);
        //b.add(new Label("Sexo: "));
        rb1=new JRadioButton("Sexo Feminino");
        rb2=new JRadioButton("Sexo Masculino");
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);bg.add(rb2);
        b.add(rb1);b.add(rb2);
        b.add(new Label("Idade: "));
        txtidade=new TextField();
        b.add(txtidade);
        b.setVisible(true);

        c.setLayout(new GridLayout(1,4));
        btnok=new Button("OK");
        c.add(btnok);
        btnok.addActionListener(this);
        btnlimpar=new Button("Limpar");
        c.add(btnlimpar);
        btnlimpar.addActionListener(this);
        btnmostrar=new Button("Mostrar");
        c.add(btnmostrar);
        btnmostrar.addActionListener(this);
        btnsair=new Button("Sair");
        c.add(btnsair);
        btnsair.addActionListener(this);
        c.setVisible(true);

        JFrame frame=new JFrame("TP03 - FormPessoa3");
        frame.setSize(350,160);
        frame.add(a);
        frame.addWindowListener(new FechaJanela());
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        
        new FormPessoa3();     
    }

    public void cadastrarPessoa(){
        if(txtnome.getText().isEmpty()||txtidade.getText().isEmpty()||(!rb1.isSelected()&&!rb2.isSelected())){
            JOptionPane.showMessageDialog(null, "Não pode haver campos em branco. Digite os dados!");
        }
        else{
            if(isStringItrynteger(txtidade.getText())){
                JOptionPane.showMessageDialog(null, "O campo 'Idade' deve estar com um número inteiro!");
            }
            else{
                char sexoescolhido;
                if(rb1.isSelected()){
                    sexoescolhido='F';
                }
                else{
                    sexoescolhido='M';
                }
                Pessoa UmaPessoa=new Pessoa((txtnome.getText()),sexoescolhido,(Integer.parseInt(txtidade.getText())));
                pessoas.add(UmaPessoa);
                txtnumero.setText(Integer.toString(Pessoa.getKp()));
                JOptionPane.showMessageDialog(null, "Pessoa Cadastrada com sucesso!");
            }
        }
    }

    public void limparRegistro(){
        txtnome.setText("");
        txtidade.setText("");
    }

    public void mostrarRegistro(){
        String mensagem="Quantidade de pessoa(s) cadastrada(s): "+Pessoa.getKp()+"\n";
        for(Pessoa pessoa: pessoas){
            mensagem+="Nome: "+pessoa.getNome()+" - Sexo: "+pessoa.getSexo()+" - Idade: "+String.valueOf(pessoa.getIdade()+"\n");
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public static boolean isStringItrynteger(String number){
        try{
            Integer.parseInt(number);
        }catch(Exception e ){
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(btnok)){
            cadastrarPessoa();
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
