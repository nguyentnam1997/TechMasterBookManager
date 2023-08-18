import entities.Book;
import service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> listBook = new ArrayList<>();
        BookServiceImpl bookService = new BookServiceImpl();
        listBook.add(bookService.insert(listBook, scanner));
        bookService.delete(listBook,scanner);
    }
}