package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Part2Solver {

    public static long solve() throws IOException {
        File file = new File("C:\\Users\\Myrthe\\ws\\git\\advent-of-code-2023\\Day3\\src\\main\\resources\\example.txt");
        BufferedReader input = new BufferedReader(new FileReader(file));

        char[][] grid = createGrid(input);
        return calculateSum(grid);
    }

    private static long calculateSum(char[][] grid) {
        long sum = 0;
        String firstPart = "";

        for (var row = 0; row < grid.length; row++) { //this loops over the rows
            for (var column = 0; column < grid.length; column++) { //this loops over the columns

                if (Character.isDigit(grid[row][column])) {
                    int columnIndex = column;
                    String fullNumber = "";
                    boolean isPart = false;

                    //find full number
                    while (columnIndex < grid.length && Character.isDigit(grid[row][columnIndex])) {
                        fullNumber = fullNumber.concat(String.valueOf(grid[row][columnIndex]));

                        if (!isPart) {
                            isPart = checkIfPart(grid, row, columnIndex);
                        }
                        grid[row][columnIndex] = '?';
                        ++columnIndex;
                    }

                    if (isPart) {
                        if (firstPart.isEmpty()) {
                            firstPart = fullNumber;
                        } else {
                            long gearRatio = Long.parseLong(firstPart) * Long.parseLong(fullNumber);
                            sum += gearRatio;
                            firstPart = "";
                        }
                    }
                }
            }
        }
        return sum;
    }

    private static boolean checkIfPart(char[][] grid, int rowIndex, int columnIndex) {
        for (int row = getStart(rowIndex); row <= getColumnEnd(grid.length, rowIndex); row++) {
            for (int column = getStart(columnIndex); column <= getColumnEnd(grid.length, columnIndex); column++) {
                Character character = grid[row][column];
                if (character.equals('*')) {
                    int amountOfDirectDigits = 0;
                    for (int row2 = getStart(row); row2 <= getColumnEnd(grid.length, row); row2++) {
                        for (int column2 = getStart(column); column2 <= getColumnEnd(grid.length, column); column2++) {
                            Character character2 = grid[row2][column2];
                            if (Character.isDigit(character2) || character2.equals('?') ) {
                                amountOfDirectDigits++;
                                if (amountOfDirectDigits >= 2) {
                                    return true;
                                }
                            }
                        }
                    }

                }
            }
        }

        return false;
    }

    private static int getColumnEnd(int gridLength, int index) {
        return index < gridLength-1 ? index+1 : gridLength-1;
    }

    private static int getStart(int index) {
        return index > 0 ? index-1 : 0;
    }

    private static char[][] createGrid(BufferedReader input) {
        List<char[]> chars = input.lines().map(String::toCharArray).toList();

        //Find the longest line to bound 2d array
        int columns = chars
                .stream()
                .max(Comparator.comparing(array -> array.length))
                .get()
                .length;

        int rows = chars.size();
        char[][] grid = new char[rows][columns];
        int i = 0;
        for (char[] array : chars) {
            int j = 0;
            for (char c : array) {
                grid[i][j] = c;
                j++;
            }
            i++;
        }

        return grid;
    }


}
