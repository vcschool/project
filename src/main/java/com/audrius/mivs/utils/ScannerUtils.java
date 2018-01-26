package com.audrius.mivs.utils;

import com.audrius.mivs.model.Role;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String scanString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static Role scanRole(String message) {
        System.out.println(message);
        String role;
        while (true) {
            try {
                role = scanner.next();
                return Role.valueOf(role);
            } catch (IllegalArgumentException e) {
                System.out.println("Enter role correctly");
                scanner.nextLine();
            }
        }
    }

    public static LocalDate scanDate(String message) {
        System.out.println(message);
        String date;
        while (true) {
            try {
                date = scanner.next();
                return LocalDate.parse(date);
            } catch (DateTimeParseException e) {
                System.out.println("Enter date correctly");
                scanner.nextLine();
            }
        }
    }

    public static int scanInt(int min, int max) {
        int enteredNumber;
        while (true) {
            try {
                enteredNumber = scanner.nextInt();
                if (min <= enteredNumber && enteredNumber <= max) {
                    return enteredNumber;
                } else {
                    System.out.println("Entered number should be between " + min + " and " + max);
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter number");
                scanner.nextLine();
            }
        }
    }
}
