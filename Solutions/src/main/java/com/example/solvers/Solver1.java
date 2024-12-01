package com.example.solvers;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.solvers.ReaderUtil.getBufferedReader;

public class Solver1 {

    public static int solve(String type) {
        try {
            BufferedReader reader = getBufferedReader(type);
            int solution;

            String line;
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String firstNum = line.substring(0, line.indexOf(" "));
                String secondNum = line.substring(line.lastIndexOf(" ") + 1);
                list1.add(Integer.parseInt(firstNum));
                list2.add(Integer.parseInt(secondNum));
            }

            //solution = calculateDifference(list1, list2);
            solution = calculateSimilarity(list1, list2);

            return solution;

        } catch (Exception ex) {
            System.out.println("OH NO! Something went horribly wrong");
        }
        return 0;
    }

    private static int calculateSimilarity(List<Integer> list1, List<Integer> list2) {
        int result = 0;

        for (int i = 0; i < list1.toArray().length; i++) {
            int frequency = Collections.frequency(list2, list1.get(i));
            int similarity = list1.get(i) * frequency;
            result += similarity;
        }

        return result;
    }

    private static int calculateDifference(List<Integer> list1, List<Integer> list2) {
        list1 = list1.stream().sorted().toList();
        list2 = list2.stream().sorted().toList();

        int result = 0;

        for (int i = 0; i < list1.toArray().length; i++) {
            int difference = Math.abs(list1.get(i) - list2.get(i));
            result += difference;
        }

        return result;
    }

}
