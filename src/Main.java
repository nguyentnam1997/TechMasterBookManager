import entities.Book;
import entities.Reader;
import service.impl.BookServiceImpl;
import service.impl.ReaderServiceImpl;
import service.utils.Utils;
import service.view.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> listBook = new ArrayList<>();
        ArrayList<Reader> listReader = new ArrayList<>();
        BookServiceImpl bookService = new BookServiceImpl();
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        Menu menu = new Menu();
        Utils utils = new Utils();
        do {
            menu.showOptionMainMenu();
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    bookService.booksManagement(scanner, menu, listBook, utils);
                case 2:
                    readerService.readersManagement(scanner, menu, listReader, utils);
                case 3:
                default:
                    System.out.println("Invalid input, do you want to continue? (Y/N)");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) continue;
                    break;
            }
        }
        while (true);
    }
}