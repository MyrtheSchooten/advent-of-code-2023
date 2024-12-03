package com.example.solvers;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.solvers.ReaderUtil.getBufferedReader;

public class Solver3 {

    public static int solve(String type) {
        try {
            BufferedReader reader = getBufferedReader(type);

            String line;
            StringBuilder input = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                input.append(line);
            }

            return calculateResult(input);

        } catch (Exception ex) {
            System.out.println("OH NO! Something went horribly wrong");
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    private static int calculateResult(StringBuilder input) {
        ArrayList<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)")
                .matcher(input);

        while (m.find()) {
            allMatches.add(m.group());
        }

        int result = 0;
        boolean doMul = true;
        for (String match : allMatches) {
            if (match.equals("do()")) {
                doMul = true;
            }

            if (match.equals("don't()")) {
                doMul = false;
            }

            if (doMul && match.contains("mul")) {
                int firstNum = Integer.parseInt(match.substring(match.indexOf("(") + 1, match.indexOf(",")));
                int secondNum = Integer.parseInt(match.substring(match.indexOf(",") + 1, match.indexOf(")")));

                int mulResult = firstNum * secondNum;
                result += mulResult;
            }
        }

        return result;
    }

}
