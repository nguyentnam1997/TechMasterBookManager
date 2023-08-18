package service.view;

public class Menu {
    public void showOptionMainMenu() {
        System.out.println("======== Techmaster book management =======");
        System.out.println("1. Books management");
        System.out.println("2. Readers management");
        System.out.println("3. Borrowing and returning books");
        System.out.println("Please choose:");
    }
    public void showOptionBookMenu() {
        System.out.println("======== Books management =======");
        System.out.println("1. Insert book");
        System.out.println("2. Edit book");
        System.out.println("3. Delete book");
        System.out.println("Please choose:");
    }
    public void showOptionReaderMenu() {
        System.out.println("======== Readers management =======");
        System.out.println("1. Insert reader");
        System.out.println("2. Edit reader");
        System.out.println("3. Delete reader");
        System.out.println("Please choose:");
    }
}
