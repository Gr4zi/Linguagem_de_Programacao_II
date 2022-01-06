/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 06 - Classe Aluno.java
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

public class Aluno {
    public String nome, objetivo;
    public int idade;
    public float peso, altura;
    
    public Aluno(){
        this.nome="";
        this.idade=0;
        this.peso=0;
        this.altura=0;
        this.objetivo="";
    }
    
    public Aluno(String nome, int idade, float peso, float altura, String objetivo){
        this.nome=nome;
        this.idade=idade;
        this.peso=peso;
        this.altura=altura;
        this.objetivo=objetivo;
    }
    
}
