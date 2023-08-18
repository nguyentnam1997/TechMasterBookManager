package service;

import entities.Book;

import java.util.ArrayList;
import java.util.Scanner;

public interface IServiceLibrary<T> {

    void insert(ArrayList<T> list, Scanner scanner);
    void edit(ArrayList<T> list, Scanner scanner);
    void delete(ArrayList<T> list, Scanner scanner);
    void deleteById(Scanner scanner, int count, ArrayList<T> list);
    void deleteByName(Scanner scanner, int count, ArrayList<T> list);
}
