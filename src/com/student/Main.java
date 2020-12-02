package com.student;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Usage: search <pattern> <full path to file>");
        String command = "";
        while (!command.equals("exit")) {
            Scanner scan = new Scanner(System.in);
            command = scan.nextLine();
            String[] commandParts = command.split(" ");

            if (commandParts.length != 3) {
                System.err.println("Command malformed - does not follow format.");
                continue;
            } else if (!commandParts[0].equals("search")) {
                System.err.println("Unknown command - only 'search' is supported.");
                continue;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(commandParts[2]))){
                String line = reader.readLine();
                int lineNumber = 1;
                while (line != null) {
                    if (line.contains(commandParts[1])) {
                        System.out.println(lineNumber + " - " + line);
                    }
                    line = reader.readLine();
                    lineNumber++;
                }
            } catch (IOException ioE) {
                System.err.println("There was a problem opening the requested file:");
                System.err.println(ioE);
            }
        }
    }
}
