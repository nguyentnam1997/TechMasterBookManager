package service.utils;

import java.util.Scanner;

public class Utils {
    public int checkValidInt(Scanner scanner) {
        int intCheck = 0;
        try {
            intCheck = Integer.parseInt(scanner.nextLine());
        }
        catch (Exception e) {
            System.out.println("Invalid value, please try again!");
        }
        return intCheck;
    }

}
