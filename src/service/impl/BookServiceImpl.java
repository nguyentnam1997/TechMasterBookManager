package service.impl;

import entities.Book;
import service.IServiceLibrary;
import service.utils.Utils;
import service.view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class BookServiceImpl implements IServiceLibrary<Book> {
    public Book createBook(Scanner scanner) {
        System.out.println("Input book's name:");
        String name = scanner.nextLine();
        System.out.println("Input book's topic:");
        String topic = scanner.nextLine();
        System.out.println("Input book's author:");
        String author = scanner.nextLine();
        do {
            System.out.println("Input number of book in the library:");
            try {
                int countBook = Integer.parseInt(scanner.nextLine());
                if (countBook < 1) {
                    System.out.println("Must exist at least 1 book, please try again!");
                    continue;
                }
                return new Book(name, topic, author, countBook);
            }
            catch (Exception e) {
                System.out.println("Invalid value, please try again!");
            }
        }
        while (true);
    }
    @Override
    public void insert(ArrayList<Book> listBook, Scanner scanner) {
        listBook.add(createBook(scanner));
        System.out.println("Insert successful!");
    }

    @Override
    public void edit(ArrayList<Book> listBook, Scanner scanner) {
        do {
            int count = 0;
            System.out.println("Type the name of book you want to edit:");
            String inputName = scanner.nextLine();
            for (Book b : listBook) {
                if (b.getName().equalsIgnoreCase(inputName)) {
                    modifyBook(b, scanner);
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("No book with this name exists");
                continue;
            }
            break;
        }
        while (true);

    }
    public void modifyBook(Book book, Scanner scanner) {
        System.out.println("===============================");
        System.out.println("1. Name");
        System.out.println("2. Topic");
        System.out.println("3. Author");
        Utils utils = new Utils();
        do {
            System.out.println("Choose the option you want to edit:");
            int choose = utils.checkValidInt(scanner);
            if (choose == 0) continue;
            switch (choose) {
                case 1 -> {
                    System.out.println("Type the new name for the book:");
                    String newName = scanner.nextLine();
                    book.setName(newName);
                }
                case 2 -> {
                    System.out.println("Type the new topic for the book:");
                    String newTopic = scanner.nextLine();
                    book.setTopic(newTopic);
                }
                case 3 -> {
                    System.out.println("Type the new author for the book:");
                    String newAuthor = scanner.nextLine();
                    book.setAuthor(newAuthor);
                }
                default -> {
                    System.out.println("Invalid input, do you want to continue? (Y/N)");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) continue;
                }
            }
            break;
        }
        while (true);
    }

    @Override
    public void delete(ArrayList<Book> listBook, Scanner scanner) {
        do {
            int count = 0;
            String deleteByName = scanner.nextLine();
            System.out.println("Type the name of book you want to delete:");
            for (Book bookDelete : listBook) {
                if (bookDelete.getName().equalsIgnoreCase(deleteByName)) {
                    listBook.remove(bookDelete);
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("No book with this name exists");
                continue;
            }
            break;
        }
        while (true);
    }

    public void booksManagement(Scanner scanner, Menu menu, ArrayList<Book> listBook, Utils utils) {
        do {
            menu.showOptionBookMenu();
            int chooseBookMenu = utils.checkValidInt(scanner);
            if (chooseBookMenu == 0) continue;
            switch (chooseBookMenu) {
                case 1 -> {
                    insert(listBook, scanner);
                    continue;
                }
                case 2 -> {
                    edit(listBook, scanner);
                    continue;
                }
                case 3 -> {
                    delete(listBook, scanner);
                    continue;
                }
                default -> {
                    System.out.println("Invalid input, do you want to continue? (Y/N)");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) continue;
                }
            }
            break;
        }
        while (true);
    }
}
