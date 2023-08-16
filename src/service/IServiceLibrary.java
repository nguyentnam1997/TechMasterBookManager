package service;

import entities.Book;

import java.util.ArrayList;
import java.util.Scanner;

public interface IServiceLibrary<T> {

    T insert(ArrayList<T> list, Scanner scanner);
    void edit(T t, Scanner scanner);
    void delete(ArrayList<T> list, Scanner scanner);
}
