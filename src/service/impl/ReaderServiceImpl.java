package service.impl;

import entities.Reader;
import jdk.jshell.execution.Util;
import service.IServiceLibrary;
import service.utils.Utils;
import service.view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class ReaderServiceImpl implements IServiceLibrary<Reader> {
    public Reader createReader(Scanner scanner, Utils utils) {
        System.out.println("Input reader's name:");
        String name = scanner.nextLine();
        do {
            System.out.println("Input reader's phone number:");
            int phoneNumber = utils.checkValidInt(scanner);
            if (phoneNumber == 0) continue;
            System.out.println("Input reader's address:");
            String address = scanner.nextLine();
            return new Reader(name, phoneNumber, address);
        }
        while (true);

    }
    @Override
    public void insert(ArrayList<Reader> listReader, Scanner scanner) {
        Utils utils = new Utils();
        listReader.add(createReader(scanner, utils));
        System.out.println("Insert successful!");
    }

    @Override
    public void edit(ArrayList<Reader> listReader, Scanner scanner) {
        do {
            int count = 0;
            System.out.println("Type the name of reader you want to edit:");
            String inputName = scanner.nextLine();
            for (Reader r : listReader) {
                if (r.getName().equalsIgnoreCase(inputName)) {
                    modifyReader(r, scanner);
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("No reader with this name exists");
                continue;
            }
            break;
        }
        while (true);

    }
    public void modifyReader(Reader reader, Scanner scanner) {
        System.out.println("===============================");
        System.out.println("1. Name");
        System.out.println("2. Phone number");
        System.out.println("3. Address");
        Utils utils = new Utils();
        do {
            System.out.println("Choose the option you want to edit:");
            int choose = utils.checkValidInt(scanner);
            if (choose == 0) continue;
            switch (choose) {
                case 1 -> {
                    System.out.println("Type the new name for the reader:");
                    String newName = scanner.nextLine();
                    reader.setName(newName);
                }
                case 2 -> {
                    do {
                        System.out.println("Type the new phone number for the reader:");
                        int newPhoneNumber = utils.checkValidInt(scanner);
                        if (newPhoneNumber == 0) continue;
                        reader.setPhoneNumber(newPhoneNumber);
                        break;
                    }
                    while (true);
                }
                case 3 -> {
                    System.out.println("Type the new address for the reader:");
                    String newAddress = scanner.nextLine();
                    reader.setAddress(newAddress);
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
    public void delete(ArrayList<Reader> listReader, Scanner scanner) {
        do {
            int count = 0;
            String deleteByName = scanner.nextLine();
            System.out.println("Type the name of reader you want to delete:");
            for (Reader readerDelete : listReader) {
                if (readerDelete.getName().equalsIgnoreCase(deleteByName)) {
                    listReader.remove(readerDelete);
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("No reader with this name exists");
                continue;
            }
            break;
        }
        while (true);
    }

    public void readersManagement(Scanner scanner, Menu menu, ArrayList<Reader> listReader, Utils utils) {
        do {
            menu.showOptionReaderMenu();
            int chooseReaderMenu = utils.checkValidInt(scanner);
            if (chooseReaderMenu == 0) continue;
            switch (chooseReaderMenu) {
                case 1 -> {
                    insert(listReader, scanner);
                    continue;
                }
                case 2 -> {
                    edit(listReader, scanner);
                    continue;
                }
                case 3 -> {
                    delete(listReader, scanner);
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
