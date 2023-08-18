package service.impl;

import entities.Book;
import entities.Reader;
import entities.TicketBook;
import service.utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketBookServiceImpl {
    public TicketBook createTicketBook(Scanner scanner, Utils utils, Reader reader, ArrayList<Reader> listReader, Book book, ArrayList<Book> listBook) {
        do {
            int count = 0;
            System.out.println("Input the borrower's ID:");
            int borrowerId = utils.checkValidInt(scanner);
            if (borrowerId == 0) continue;
            for (Reader r : listReader) {
                if (r.getId() == borrowerId) {
                    reader = r;
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("This reader does not exist, please try again");
                continue;
            }
            do {
                count = 0;
                System.out.println("Input the borrowed book:");
                String borrowedBook = scanner.nextLine();
                for (Book b : listBook) {
                    if (b.getName().equalsIgnoreCase(borrowedBook)) {
                        book = b;
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    System.out.println("This book does not exist, please try again");
                    continue;
                }
                break;
            }
            while (true);
            LocalDate startDate = LocalDate.now();
            System.out.println("Input the book return date:");
            LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return new TicketBook(reader, book, startDate, endDate);
        }
        while (true);
    }
}
