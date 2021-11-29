/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 03 - Form.java
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Form extends Frame implements ActionListener{
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bigual,bsoma,bsub,bdiv,bmult,blimpar,bvirg;
    TextField tela;
    String op, s1, s2;
    float resultado;
    boolean virgula=false;

    public Form(){
        JPanel a=new JPanel();
        JPanel b=new JPanel();
        JPanel c=new JPanel();

        a.setLayout(new BorderLayout());
        a.add(b,BorderLayout.NORTH);
        a.add(c,BorderLayout.SOUTH);  

        b.setLayout(new GridLayout());
        tela=new TextField("");
        tela.setEditable(false);
        b.add(tela);
        b.setVisible(true);

        c.setLayout(new GridLayout(5,4));
        b7=new Button("7");
        c.add(b7);
        b7.addActionListener(this);
        b8=new Button("8");
        c.add(b8);
        b8.addActionListener(this);
        b9=new Button("9");
        c.add(b9);
        b9.addActionListener(this);
        bdiv=new Button("/");
        c.add(bdiv);
        bdiv.addActionListener(this);
        b4=new Button("4");
        c.add(b4);
        b4.addActionListener(this);
        b5=new Button("5");
        c.add(b5);
        b5.addActionListener(this);
        b6=new Button("6");
        c.add(b6);
        b6.addActionListener(this);
        bmult=new Button("*");
        c.add(bmult);
        bmult.addActionListener(this);
        b1=new Button("1");
        c.add(b1);
        b1.addActionListener(this);
        b2=new Button("2");
        c.add(b2);
        b2.addActionListener(this);
        b3=new Button("3");
        c.add(b3);
        b3.addActionListener(this);
        bsub=new Button("-");
        c.add(bsub);
        bsub.addActionListener(this);
        b0=new Button("0");
        c.add(b0);
        b0.addActionListener(this);
        bvirg=new Button(".");
        c.add(bvirg);
        bvirg.addActionListener(this);
        bigual=new Button("=");
        c.add(bigual);
        bigual.addActionListener(this);
        bsoma=new Button("+");
        c.add(bsoma);
        bsoma.addActionListener(this);
        blimpar=new Button("C");
        c.add(blimpar);
        blimpar.addActionListener(this);
        c.setVisible(true);

        JFrame frame=new JFrame("Calculadora");
        frame.setSize(250,175);
        frame.add(a);
        frame.addWindowListener(new FechaJanela());
        frame.setVisible(true);

        op=s1=s2="";
    }

    public static void main(String[] args) throws Exception{
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally{
            new Form();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();

        switch(s){
            case "C":
                op=s1=s2="";
                resultado=0;
                virgula=false;
                tela.setText("0");
            break;

            case ".":
                if(virgula==false){
                    s1=s1+',';
                    tela.setText(s1);
                    virgula=true;
                }                
            break;
            
            case "0":
                s1=s1+'0';
                tela.setText(s1);
            break;
            
            case "1":
                s1=s1+'1';
                tela.setText(s1);
            break;
            
            case "2":
                s1=s1+'2';
                tela.setText(s1);
            break;
            
            case "3":
                s1=s1+'3';
                tela.setText(s1);
            break;
            
            case "4":
                s1=s1+'4';
                tela.setText(s1);
            break;
            
            case "5":
                s1=s1+'5';
                tela.setText(s1);
            break;
            
            case "6":
                s1=s1+'6';
                tela.setText(s1);
            break;
            
            case "7":
                s1=s1+'7';
                tela.setText(s1);
            break;
            
            case "8":
                s1=s1+'8';
                tela.setText(s1);
            break;
            
            case "9":
                s1=s1+'9';
                tela.setText(s1);
            break;

            case "+":
                if(!s1.isEmpty()){
                    if(op.isEmpty()){
                        op="+";
                        s2=s1;
                        s1="";
                        tela.setText("");
                    }
                    else{
                        s2=Resultado();
                        s1="";
                        op="+";
                        tela.setText(s2);
                    }
                }
                else{
                    op="+";
                }
            break;

            case "-":
                if(!s1.isEmpty()){
                    if(op.isEmpty()){
                        op="-";
                        s2=s1;
                        s1="";
                        tela.setText("");
                    }
                    else{
                        s2=Resultado();
                        s1="";
                        op="-";
                        tela.setText(s2);
                    }
                }
                else{
                    op="-";
                }
            break;

            case "*":
                if(!s1.isEmpty()){
                    if(op.isEmpty()){
                        op="*";
                        s2=s1;
                        s1="";
                        tela.setText("");
                    }
                    else{
                        s2=Resultado();
                        s1="";
                        op="*";
                        tela.setText(s2);
                    }
                }
                else{
                    op="*";
                }
            break;

            case "/":
                if(!s1.isEmpty()){
                    if(op.isEmpty()){
                        op="/";
                        s2=s1;
                        s1="";
                        tela.setText("");
                    }
                    else{
                        s2=Resultado();
                        s1="";
                        op="/";
                        tela.setText(s2);
                    }
                }
                else{
                    op="/";
                }
            break;

            case "=":
                if(!s1.isEmpty()){
                    s2=Resultado();
                    s1="";
                    op="";
                    tela.setText(s2);
                }
            break;
        }
        
    }

    public String Resultado(){
        String res="";
        switch(op){
            case "+":
            resultado=Float.parseFloat(s2)+Float.parseFloat(s1);
            res=Float.toString(resultado);
            break;

            case "-":
            resultado=Float.parseFloat(s2)-Float.parseFloat(s1);
            res=Float.toString(resultado);
            break;

            case "*":
            resultado=Float.parseFloat(s2)*Float.parseFloat(s1);
            res=Float.toString(resultado);
            break;

            case "/":
            try{
                resultado=Float.parseFloat(s2)/Float.parseFloat(s1);
            }
            catch(Exception erro){
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
            finally{
                res=Float.toString(resultado);
            }
            break;
        }
        return res;
    }
}
