/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 02 - Classe Aluno.java
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

import java.util.UUID;

public class Aluno{
    private String endereço;
    private int idade;
    private String nome;
    private UUID uuid;

    public String getEndereço() {
        return endereço;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Aluno(String endereco, int idade, String nome){
        this.endereço=endereco;
        this.idade=idade;
        this.nome=nome;
        this.uuid=UUID.randomUUID();
    }

    public Aluno(){
        this.endereço="";
        this.idade=0;
        this.nome="";
        this.uuid=UUID.randomUUID();
    }

    @Override
    public String toString(){
        return "ID: "+this.uuid+" Nome: "+this.nome+"\n";
    }

}