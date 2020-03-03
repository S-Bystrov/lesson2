import entity.Author;
import entity.Book;
import entity.Warehouse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ApplicationContext context = new AnnotationConfigApplicationContext("entity");
    public static void main(String[] args) {
        List<Book> bookA = Arrays.asList(
                createBook("qwe", 1199),
                createBook("qrwe", 1543),
                createBook("asdf", 2000),
                createBook("trey", 1998));
        List<Book> bookB = Arrays.asList(
                createBook("tyu", 1464),
                createBook("dfhg", 1657),
                createBook("dfcvn", 567));
        List<Book> bookC = Arrays.asList(
                createBook("wttr", 1314),
                createBook("uiouo", 1877),
                createBook("gnbnv", 1982),
                createBook("utoo", 1566));
        List<Book> bookD = Arrays.asList(
                createBook("terte", 1199),
                createBook("fsfsf", 19988));

        List<Author> authorA = Arrays.asList(
                createAuthor("Asdaf", "Cdsdsc", bookA),
                createAuthor("Baat", "Cdasda", bookB),
                createAuthor("Casfa", "Yete", bookC),
                createAuthor("Dere", "Neeew", bookD));

        Warehouse warehouse = context.getBean(Warehouse.class);
        warehouse.setAuthorList(authorA);
        boolean t = true;
        while(t){
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Вывести список авторов" + '\n' + "2. Вывести список книг автора");
            int element = scanner.nextInt();
            if (element == 1){
                System.out.println(warehouse);
            } else {
                if(element == 2){
                    System.out.println("Введите имя автора");
                    Scanner scanner2 = new Scanner(System.in);
                    String name = scanner2.nextLine();
                    Author authorFind = warehouse.getAuthorList().stream().filter(x ->name.equals(x.getName()))
                            .findAny().orElse(null);
                    if(authorFind == null){
                        System.out.println("Неверное имя");
                    } else {
                        System.out.println(authorFind.getBookList());
                        System.out.println("1.Закончить работу" + '\n' + "2.Начать заново");
                        int elementSecond = scanner.nextInt();
                        switch (elementSecond) {
                            case 1 :
                                t = false;
                                break;
                        }
                    }
                }
            }
        }

    }

    private static Book createBook(String name, int year){
        Book book = context.getBean(Book.class);
        book.setYear(year);
        book.setName(name);
        return book;
    }

    private static Author createAuthor(String name, String surname, List<Book> bookList){
        Author author = context.getBean(Author.class);
        author.setName(name);
        author.setSurname(surname);
        author.setBookList(bookList);
        return author;
    }
}
