/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 01 - Exercicio 3
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */
public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee){
        super(name, address);
        this.program=program;
        this.year=year;
        this.fee=fee;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program=program;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year=year;
    }

    public double getFee(){
        return fee;
    }

    public void setFee(double fee){
        this.fee=fee;
    }

    public String toString(){
        return "Student [Person [name= "+this.name+", address= "+this.address+"], program= "+this.program+", year= "+this.year+", fee= "+this.fee+"]\n";
    }
}
