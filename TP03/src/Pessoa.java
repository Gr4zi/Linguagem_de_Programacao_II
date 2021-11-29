/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 03 - Pessoa.java
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

public class Pessoa {
    private static int kp;
    private String nome;
    private char sexo;
    private int idade;

    public static void setKp() {
        Pessoa.kp = 0;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public static int getKp() {
        return kp;
    }
    public String getNome() {
        return nome;
    }
    public char getSexo() {
        return sexo;
    }
    public int getIdade() {
        return idade;
    }

    public Pessoa(){
        this.nome="";
        this.sexo='x';
        this.idade=0;
    }

    public Pessoa(String nome, char sexo, int idade){
        this.nome=nome;
        this.sexo=sexo;
        this.idade=idade;
        kp++;
    }     
}
