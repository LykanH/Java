package Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/13 21:09
 * 案例：自定义book类，里边包含name和price，按照price排序（从大到小）。
 * 要求使用两种方式排序，有一个Book[] books = 4本书对象
 * <p>
 * 使用前面学过的传递，实现Comparator接口匿名内部类，也称定制排序
 */
public class PriceSort {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅20版", 90);
        books[2] = new Book("青年文摘2021年", 5);
        books[3] = new Book("java", 300);

        //按照价格从大到小

//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book i1 = (Book) o1;
//                Book i2 = (Book) o2;
//                return i2.getPrice() - i1.getPrice();
//            }
//        });

        //按照价格从小到大

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book i1 = (Book) o1;
                Book i2 = (Book) o2;
                return i1.getPrice() - i2.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));
        //按照书名长度从长到短

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book i1 = (Book) o1;
                Book i2 = (Book) o2;
                return i1.getName().length() - i2.getName().length();
            }
        });

        System.out.println(Arrays.toString(books));
    }

//    public static void sort(Book[] books, Comparator c) {
//        Book tempb1;
//        for (int i = 0; i < books.length - 1; i++) {
//            for (int j = 0; j < books.length - i - 1; j++) {
//                if (c.compare(books[j].getPrice(), books[j + 1].getPrice()) > 0) {
//                    tempb1 = books[j];
//                    books[j] = books[j + 1];
//                    books[j + 1] = books[j];
//                }
//            }
//        }
//    }
}

class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}