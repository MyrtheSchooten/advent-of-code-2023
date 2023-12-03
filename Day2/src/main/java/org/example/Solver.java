package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solver {
    public static final int MAX_RED = 12;
    public static final int MAX_GREEN = 13;
    public static final int MAX_BLUE = 14;

    public static int solve1() throws IOException {
        File file = new File("C:\\Users\\Myrthe\\ws\\git\\advent-of-code-2023\\Day2\\src\\main\\resources\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int total = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            boolean isPossibleGame = determineIfPossible(line);
            if (isPossibleGame) {
                total += getGameNumber(line);
            }
        }

        return total;
    }

    public static int solve2() throws IOException {
        File file = new File("C:\\Users\\Myrthe\\ws\\git\\advent-of-code-2023\\Day2\\src\\main\\resources\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int total = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            total += powerOfMinimum(line);
        }

        return total;
    }

    private static int powerOfMinimum(String line) {
        int minimumRed = 0;
        int minimumGreen = 0;
        int minimumBlue = 0;

        String[] parts = line.split(";|,|:");
        for (String part : parts) {
            if (!part.contains("Game")) {
                int numberOfStones = getNumberOfStones(part);
                if (part.contains("red")) {
                    if (numberOfStones > minimumRed) {
                        minimumRed = numberOfStones;
                    }
                } else if (part.contains("green")) {
                    if (numberOfStones > minimumGreen) {
                        minimumGreen = numberOfStones;
                    }
                } else {
                    if (numberOfStones > minimumBlue) {
                        minimumBlue = numberOfStones;
                    }
                }
            }
        }

        return (minimumRed * minimumGreen * minimumBlue);
    }


    private static int getGameNumber(String line) {
        String gameHeader = Arrays.stream(line.split(":")).findFirst().get();
        String number = gameHeader
                .replace("Game ", "")
                .replace(";", "");

        return Integer.parseInt(number);
    }

    private static boolean determineIfPossible(String line) {
        String[] parts = line.split(";|,|:");

        for (String part : parts) {
            if (!part.contains("Game")) {

                int numberOfStones = getNumberOfStones(part);
                if (part.contains("red")) {
                    if (numberOfStones > MAX_RED) {
                        return false;
                    }
                } else if (part.contains("green")) {
                    if (numberOfStones > MAX_GREEN) {
                        return false;
                    }
                } else {
                    if (numberOfStones > MAX_BLUE) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int getNumberOfStones(String part) {
        String[] numberTexts = part.trim().split("[a-zA-Z]");
        String number = "";
        for (String numberText : numberTexts) {

            number = number.concat(numberText.trim());
        }

        return Integer.parseInt(number);
    }


}
