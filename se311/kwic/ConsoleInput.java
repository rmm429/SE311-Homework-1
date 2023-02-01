package se311.kwic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Java program to demonstrate working of Scanner in Java
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInput implements Input {

    public void acceptInput(LineStorage storageObj) {

        Scanner scanner = new Scanner(System.in);
        // ArrayList<String> list = new ArrayList<>();

        System.out.println("Enter your sentences: (enter a blank line to stop)");
        String curSentence = scanner.nextLine();

        while(true) {

            if (curSentence.isEmpty()) {
                break;
            }

            // System.out.println(readString);
            //list.add(readString);
            storageObj.addOneLine(curSentence);
            curSentence = scanner.nextLine();
        }

        scanner.close();

        //        Scanner scanner = new Scanner(System.in);
//        ArrayList<String> list = new ArrayList<String>();
//
//        while(scanner.hasNext()) {
//
//            String line = scanner.next();
//            System.out.println(line);
//
//            if (line.equals("Q")) {
//                scanner.close();
//                break;
//            }
//
//            list.add(line);
//
//        }



//        try {
//
//            // Enter data using BufferReader
//            BufferedReader reader = new BufferedReader(
//                new InputStreamReader(System.in));
//
//            System.out.println("Paste the lines below:");
//
//            // Reading data using readLine
//            String name = reader.readLine();
//
//            // Printing the read line
//            System.out.println("\n" + name);
//
//        } catch (IOException e) {
//
//        }



//        // Using Scanner for Getting Input from User
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Paste the lines below:");
//
//        String s = in.nextLine();
//        System.out.println("You entered string " + s);




//

    }

}
