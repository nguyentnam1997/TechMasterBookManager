package entities;

import java.time.LocalDate;

public class TicketBook {
    private int autoId;
    private int id;
    private Reader reader;
    private Book book;
    private LocalDate startDate;
    private LocalDate endDate;

    public TicketBook(Reader reader, Book book, LocalDate startDate, LocalDate endDate) {
        this.id = ++autoId;
        this.reader = reader;
        this.book = book;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
