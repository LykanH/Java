package exer.Test;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/22 16:12
 */
public class Test {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.isbn = 99;
        book1.author = "wqe";
        book1.title = "dada";
        book1.price = 110.99;
        System.out.println("序列号：" + book1.isbn + "\t作者：" + book1.author + "\t标题：" + book1.title);

//        Book book2 = new Book(98,"钢铁","人生","adad");
//        System.out.println(book2.toString());
    }
}

class Book{
    int isbn;
    String title,author,press;
    double price;
    public Book(){

    }
//    public Book(int isbn,String title,String author,String press){
//        this.isbn = isbn;
//        this.author = author;
//        this.press = press;
//        this.title = title;
//
//    }
    public String toString(){
        return "序列号：" + isbn + "\t作者：" + author + "\t标题：" +title;
    }

}
