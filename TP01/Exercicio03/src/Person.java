/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 01 - Exercicio 3
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */


public class Person{
    protected String name;
    protected String address;

    public Person(String name, String address){
        this.name=name;
        this.address=address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String toString(){
    return "Person [name="+this.name+", address="+this.address+"]\n";
    }
}