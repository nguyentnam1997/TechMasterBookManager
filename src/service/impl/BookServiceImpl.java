package service.impl;

import entities.Book;
import service.IServiceLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class BookServiceImpl implements IServiceLibrary<Book> {
    @Override
    public Book insert(ArrayList<Book> listBook, Scanner scanner) {
        System.out.println("Book's name:");
        String name = scanner.nextLine();
        System.out.println("Book's topic:");
        String topic = scanner.nextLine();
        System.out.println("Book's author:");
        String author = scanner.nextLine();
        do {
            System.out.println("Number of book in the library:");
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
    public void edit(Book book, Scanner scanner) {
        System.out.println("===============================");
        System.out.println("1. Name");
        System.out.println("2. Topic");
        System.out.println("3. Author");
        do {
            System.out.println("Choose the option you want to edit:");
            try {
                int choose = Integer.parseInt(scanner.nextLine());
                if (choose > 3 || choose < 1) {
                    System.out.println("Outside the allowed range, please try again!");
                    continue;
                }
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
                }
                break;
            }
            catch (Exception e) {
                System.out.println("Invalid value, please try again!");
            }
        }
        while (true);

    }

    @Override
    public void delete(ArrayList<Book> listBook, Scanner scanner) {
        int count;
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Topic");
        System.out.println("4. Author");
        do {
            int choose;
            count = 0;
            choose = checkIntInput(scanner, "Choose the option you want to delete the book:");
            if (choose == 0) continue;
            else if (choose > 4 || choose < 1) {
                System.out.println("Outside the allowed range, please try again!");
                continue;
            }
            switch (choose) {
                case 1 -> {
                    deleteById(scanner, count, listBook);
                }
                case 2 -> {
                    deleteByName(scanner, count, listBook);
                }
                case 3 -> {
                    String deleteForTopic = scanner.nextLine();
                    deleteBookByTopic(count, deleteForTopic, listBook);
                }
                case 4 -> {
                    String deleteForAuthor = scanner.nextLine();
                    deleteBookByAuthor(count, deleteForAuthor, listBook);
                }
            }
            break;
        }
        while (true);
    }
    public int checkIntInput(Scanner scanner, String message) {
        int intCheck = 0;
            try {
                System.out.println(message);
                intCheck = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println("Invalid value, please try again!");
            }
        return intCheck;
    }

    @Override
    public void deleteById(Scanner scanner, int count, ArrayList<Book> listBook) {
        do {
            int deleteById;
            deleteById = checkIntInput(scanner, "Type the ID want to delete:");
            if (deleteById == 0) continue;
            else {
                for (Book bookDelete : listBook) {
                    if (bookDelete.getId() == deleteById) {
                        System.out.println("Successfully deleted the book with ID: " + deleteById);
                        listBook.remove(bookDelete);
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    System.out.println("No book with this ID exists");
                    continue;
                }
            }
            break;
        }
        while (true);
    }
    public void deleteByName(Scanner scanner, int count, ArrayList<Book> listBook) {
        do {
            System.out.println("Type the name want to delete:");
            String deleteByName = scanner.nextLine();
            for (Book bookDelete : listBook) {
                if (bookDelete.getName().equalsIgnoreCase(deleteByName)) {
                    listBook.remove(bookDelete);
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("No book with this name exists");
            }
        }
        while (true);
    }
    public void deleteBookByTopic(int count, String deleteByTopic, ArrayList<Book> listBook) {
        System.out.println("Type the topic want to delete:");
        for (Book bookDelete : listBook) {
            if (bookDelete.getTopic().equalsIgnoreCase(deleteByTopic)) {
                listBook.remove(bookDelete);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No book with this topic exists");
        }
    }
    public void deleteBookByAuthor(int count, String deleteByAuthor, ArrayList<Book> listBook) {
        System.out.println("Type the topic want to delete:");
        for (Book bookDelete : listBook) {
            if (bookDelete.getAuthor().equalsIgnoreCase(deleteByAuthor)) {
                listBook.remove(bookDelete);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No book with this author exists");
        }
    }
}
