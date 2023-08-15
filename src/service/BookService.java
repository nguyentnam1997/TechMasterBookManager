package service;

import entities.Book;

import javax.xml.namespace.QName;
import java.util.Scanner;

public class BookService {
    public Book createBook(Scanner scanner) {
        System.out.println("Book's name:");
        String name = scanner.nextLine();
        System.out.println("Book's topic:");
        String topic = scanner.nextLine();
        System.out.println("Book's author:");
        String author = scanner.nextLine();
        System.out.println("Number of book in the library:");
        int countBook = Integer.parseInt(scanner.nextLine());
        return new Book(name, topic, author, countBook);
    }
    public void modifyBook(Scanner scanner, Book book) {
        System.out.println("Choose the option you want to modify:");
        System.out.println("1. Name");
        System.out.println("2. Topic");
        System.out.println("3. Author");
        int choose = Integer.parseInt(scanner.nextLine());
    }
}
