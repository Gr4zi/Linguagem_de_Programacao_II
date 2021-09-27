/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 01 - Exercicio 3
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */
public class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay){
        super(name, address);
        this.school=school;
        this.pay=pay;
    }

    public String getSchool(){
        return school;
    }

    public void setSchool(String school){
        this.school=school;
    }

    public double getPay(){
        return pay;
    }

    public void setPay(double pay){
        this.pay=pay;
    }

    public String toString(){
        return "Staff [Person [name= "+this.name+", address= "+this.address+"], school= "+this.school+", pay= "+this.pay+"]\n";
    }
}
