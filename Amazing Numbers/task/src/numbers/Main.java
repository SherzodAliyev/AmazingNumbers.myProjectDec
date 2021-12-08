package numbers;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        welcomeUser();
        requestInput();
    }

    private static void requestInput() {
        while (true) {
            System.out.print("\nEnter a request: ");
            String[] searchQueryArray = scan.nextLine().split(" ");
            System.out.println();

            boolean firstNatural = true;
            boolean secondNatural = true;
            try {
                Long.parseLong(searchQueryArray[0]);
            } catch (Exception e) {
                System.out.println("The first parameter should be a natural number or zero.");
                firstNatural = false;
            }
            if (!firstNatural && searchQueryArray.length >= 2) {
                try {
                    Long.parseLong(searchQueryArray[1]);
                } catch (Exception e) {
                    System.out.println("The second parameter should be a natural number.");
                    secondNatural = false;
                }
            }

            if (firstNatural && secondNatural) {

                if (Long.parseLong(searchQueryArray[0]) == 0) break;
                switch (searchQueryArray.length) {
                    case 1:
                        NumberProcessor.processOneNumber(Long.parseLong(searchQueryArray[0]));
                        break;
                    case 2:
                        NumberProcessor.processConsecutiveList(Long.parseLong(searchQueryArray[0]), Long.parseLong(searchQueryArray[1]));
                        break;
                    default:
                        NumberProcessor.processQuery(Long.parseLong(searchQueryArray[0]), Long.parseLong(searchQueryArray[1]), searchQueryArray);
                        break;
                }
            }
        }
        System.out.println("Goodbye!");
    }

    public static void welcomeUser() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know it's properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }
}