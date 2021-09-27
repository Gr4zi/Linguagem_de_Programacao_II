/*
 * IFSP - Campus Cubatão - ADS471
 * Linguagem de Programacao LP2I4 - Prof Tuler
 * Trabalho Pratico 01 - Exercicio 2
 * Alunos: Grazielle da Silva Ribeiro CB3007316 e Josuel Joao dos Santos CB3005542
 */

 public class Book{
     private String name;
     private Author authors[];
     private double price;
     private int qty=0;

     public Book(String name, Author authors[],double price){
        this.name=name;
        this.authors=authors;
        this.price=price;
     }

     public Book(String name, Author authors[],double price, int qty){
        this.name=name;
        this.authors=authors;
        this.price=price;
        this.qty=qty;
     }

     public String getName(){
         return name;
     }

     public Author[] getAuthors(){
         return authors;
     }

     public double getPrice(){
         return price;
     }

     public void setPrice(double price){
         this.price=price;
     }

     public int getQty(){
         return qty;
     }

     public void setQty(int qty){
         this.qty=qty;
     }

     public String toString(){
        String fullauthors="Authors= ";
        for(int i=0; i<authors.length;i++){
            fullauthors+="[name= "+authors[i].getName()+", email= "+authors[i].getEmail()+", gender="+authors[i].getGender()+"] ";
        }
        return "Book[name="+this.name+", authors={"+fullauthors+"}, price="+this.price+", qty="+this.qty+"]\n";
     }

     public String getAuthorNames(){
        String nome="";    
        for(int i=0;i<authors.length;i++){
             nome+=authors[i].getName()+", ";
         }
         return nome;
     }
 }