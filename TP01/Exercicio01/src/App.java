import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read=new Scanner(System.in);

        String name;
        String email;
        String teste;
        char gender;

        System.out.println("Digite o nome: ");
        name=read.nextLine();
        System.out.println("");

        System.out.println("Digite o email: ");
        email=read.nextLine();
        System.out.println("");

        do{
            System.out.println("Digite o gênero (m)asculino ou (f)eminino: ");
            teste=read.next();
            gender=teste.charAt(0);
            System.out.println("");
        }while(gender!='m'&&gender!='f');
        
        Author author=new Author(name,email,gender);

        System.out.println(author.toString());

        System.out.println("Digite o novo email: ");
        email=read.next();
        author.setEmail(email);
        System.out.println("");

        System.out.println(author.getName());
        System.out.println("");
        System.out.println(author.getEmail());
        System.out.println("");
        System.out.println(author.getGender());
        System.out.println("");

        read.close();
    }
}