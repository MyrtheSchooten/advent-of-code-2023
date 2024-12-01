package com.example.solvers;

import java.io.BufferedReader;

import static com.example.solvers.ReaderUtil.getBufferedReader;

public class Solver2 {

    public static int solve(String type) {
        try {
            BufferedReader reader = getBufferedReader(type);
            int solution = 0;

            String line;
            while ((line = reader.readLine()) != null) {

            }


            //solution = calculateSimilarity(list1, list2);

            return solution;

        } catch (Exception ex) {
            System.out.println("OH NO! Something went horribly wrong");
        }
        return 0;
    }

}
