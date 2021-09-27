/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 01 - Exercicio 2
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */
public class TestBook {
    public static void main(String[] args) throws Exception {
    // Crie e aloque o array de autores.
    Author[] authors = new Author[2];
    authors[0] = new Author("Autor01", "autor01@somewhere.com.br", 'm');
    authors[1] = new Author("Autor02", "autor02@nowhere.com.br", 'm');
    // Declarar e alocar a instância de um booking.
    Book testeBook = new Book("Java for Dummy", authors, 19.99, 99);
    System.out.println(testeBook); // toString()
        }
}
