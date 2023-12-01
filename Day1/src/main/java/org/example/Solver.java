package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solver {

    public static int solve() {
        try {

            File file = new File("C:\\Users\\Myrthe\\ws\\git\\advent-of-code-2023\\Day1\\src\\main\\resources\\input.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int solution = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                int number = findNumberPart2(line);
                solution += number;
            }

            return solution;

        } catch (Exception ex) {
            System.out.println("OH NO! Something went horribly wrong");
        }
        return 0;
    }

    private static int findNumberPart1(String line) {
        Pattern regex = Pattern.compile("\\d");
        Matcher matcher = regex.matcher(line);


        List<String> allNumbers = new ArrayList<>();
        while (matcher.find()) {
            allNumbers.add(matcher.group());
        }

        return findFullNumber(allNumbers);

    }

    private static int findNumberPart2(String line) {
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9",
                "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine"};

        String firstNumber = "";
        String lastNumber = "";

        int firstIndex = line.length();
        int lastIndex = 0;

        for (String number: numbers) {
            if (line.contains(number)) {

                if (line.indexOf(number) < firstIndex) {
                    firstNumber = transformNumber(number);
                    firstIndex = line.indexOf(number);
                }

                if (line.lastIndexOf(number) > lastIndex) {
                    lastNumber = transformNumber(number);
                    lastIndex = line.lastIndexOf(number);
                }
            }
        }

        if (lastNumber.isEmpty()){
            String fullNumber = firstNumber + firstNumber;
            return Integer.parseInt(fullNumber);
        } else {
            String fullNumber = firstNumber + lastNumber;
            return Integer.parseInt(fullNumber);
        }
    }

    private static int findFullNumber(List<String> allNumbers) {
        if (allNumbers.size() == 1) {
            String firstNumber = allNumbers.get(0);
            String fullNumber = firstNumber + firstNumber;
            return Integer.parseInt(fullNumber);
        } else {
            String firstNumber = allNumbers.get(0);
            String secondNumber = allNumbers.get(allNumbers.size() - 1);
            String fullNumber = firstNumber + secondNumber;
            return Integer.parseInt(fullNumber);
        }
    }

    private static String transformNumber(String number) {
        return switch (number) {
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> number;
        };
    }
}
