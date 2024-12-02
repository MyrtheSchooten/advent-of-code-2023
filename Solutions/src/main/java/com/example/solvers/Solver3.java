package com.example.solvers;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.solvers.ReaderUtil.getBufferedReader;

public class Solver3 {

    public static int solve(String type) {
        try {
            BufferedReader reader = getBufferedReader(type);
            int solution = 0;

            String line;
            while ((line = reader.readLine()) != null) {

          /*      if (isSafe(line)) {
                    solution++;
                }*/
            }

            return solution;

        } catch (Exception ex) {
            System.out.println("OH NO! Something went horribly wrong");
            System.out.println(ex.getMessage());
        } return 0;
    }
}
