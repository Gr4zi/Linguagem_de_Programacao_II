/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 01 - Exercicio 3
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */
public class Test {
    public static void main(String[] args) throws Exception {
        
        Student student=new Student("Joaquim", "Bairro do Limoeiro", "Oceanografia", 1, 1500); //Criando e alocando instância da classe Student
        System.out.println(student.toString()); //Método toString da classe Student

        student.setProgram("Historia"); //Setter do atributo program
        System.out.println(student.getProgram()); //Getter do atributo program

        student.setYear(2); //Setter do atributo year
        System.out.println(student.getYear()); //Getter do atributo year

        student.setFee(2000);//Setter do atributo
        System.out.println(student.getFee()); //Getter do atributo

        System.out.println("");

        Staff staff=new Staff("João", "Tangamandápio", "IFSP", 3800); //Criando e alocando instância da classe Staff
        System.out.println(staff.toString());//Método toString da classe Staff

        staff.setSchool("ETEC"); //Setter do atributo school
        System.out.println(staff.getSchool()); //Getter do atributo school

        staff.setPay(7500); //Setter do atributo pay
        System.out.println(staff.getPay()); //Getter do atributo pay
    }
}
