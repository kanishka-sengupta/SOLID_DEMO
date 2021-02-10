package ToDo.UtilityPackage;

import java.util.Scanner;

public class Input {
    private static Scanner inputScanner;

    static {
        inputScanner = new Scanner(System.in);
    }

    public static String takeStringInput() {
        return inputScanner.nextLine();
    }

    public static int takeIntInput() {
        System.out.print("Enter Option Index: ");
        return inputScanner.nextInt();
    }
}
