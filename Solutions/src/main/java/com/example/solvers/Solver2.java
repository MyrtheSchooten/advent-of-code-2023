package com.example.solvers;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.solvers.ReaderUtil.getBufferedReader;

public class Solver2 {

    public static int solve(String type) {
        try {
            BufferedReader reader = getBufferedReader(type);
            int solution = 0;

            String line;
            while ((line = reader.readLine()) != null) {

                if (isSafe(line)) {
                    solution++;
                }
            }

            return solution;

        } catch (Exception ex) {
            System.out.println("OH NO! Something went horribly wrong");
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    private static boolean isSafe(String line) {
        List<String> levels = new ArrayList<>(Arrays.asList(line.split(" ")));
        List<Integer> intLevels = new ArrayList<>(levels.stream().map(Integer::parseInt).toList());

        if (checkLine(intLevels)) {
            return true;
        } else {
            for (int i = 0; i < intLevels.size(); i++) {
                ArrayList<Integer> listWithout = new ArrayList<>(List.copyOf(intLevels));
                listWithout.remove(i);
                boolean safe = checkLine(listWithout);

                if (safe) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkLine(List<Integer> intLevels) {
        for (int i = 0; i < intLevels.size() - 1; i++) {

            int difference = intLevels.get(i + 1) - intLevels.get(i);

            if (isDecreasing(intLevels) && !(difference == -1 || difference == -2 || difference == -3)) {
                return false;
            } else if (!isDecreasing(intLevels)  && !(difference == 1 || difference == 2 || difference == 3)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDecreasing(List<Integer> intLevels) {
        int compared = intLevels.get(0).compareTo(intLevels.get(1));
        return compared > 0;
    }

}
