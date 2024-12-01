package com.example.solvers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReaderUtil {

    public static BufferedReader getBufferedReader(String type) throws FileNotFoundException {
        File file;
        if (type.equalsIgnoreCase("E")) {
            file = new File("C:\\Users\\Myrthe\\ws\\git\\advent-of-code-2024\\Solutions\\src\\main\\resources\\example.txt");
        } else if (type.equalsIgnoreCase("I")) {
            file = new File("C:\\Users\\Myrthe\\ws\\git\\advent-of-code-2024\\Solutions\\src\\main\\resources\\input.txt");
        } else {
            throw new IllegalArgumentException("Not a type");
        }

        return new BufferedReader(new FileReader(file));
    }


}
