package service.impl;

import entities.TicketBook;
import service.IServiceLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class TicketBookServiceImpl implements IServiceLibrary<TicketBook> {

    @Override
    public TicketBook insert(ArrayList<TicketBook> list, Scanner scanner) {
        return null;
    }

    @Override
    public void edit(TicketBook ticketBook, Scanner scanner) {

    }

    @Override
    public void delete(ArrayList<TicketBook> list, Scanner scanner) {

    }

    @Override
    public void deleteById(Scanner scanner, int count, ArrayList<TicketBook> list) {

    }

    @Override
    public void deleteByName(Scanner scanner, int count, ArrayList<TicketBook> list) {

    }
}
