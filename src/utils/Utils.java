package utils;

import java.util.Scanner;

public class Utils {
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

}
