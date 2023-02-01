package se311.search;

import java.util.Scanner;

public class ConsoleInput implements Input {

    public String getKeyword() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a keyword to search: ");
        String keyword = scanner.nextLine();
        scanner.close();
        return keyword;

    }

}
