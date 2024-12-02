package com.example.solvers;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        String keepGoing = "Y";

        while (keepGoing.equalsIgnoreCase("Y")) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("Welcome! Which day is it?");
            String day = reader.readLine();

            System.out.println("Example (E) or input (I)?");
            String type = reader.readLine();

            int solution =  switch (day) {
                case "1" -> Solver1.solve(type);
                case "2" -> Solver2.solve(type);
                case "3" -> Solver3.solve(type);
                default -> throw new IllegalArgumentException("Nope, not yet implemented");
            };

            System.out.println("Solution is: " + solution);

            System.out.println("Do you want to run something else? Y/N");
            keepGoing = reader.readLine();
        }

    }

}