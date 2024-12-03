package com.example.solvers;

import java.io.BufferedReader;

import static com.example.solvers.ReaderUtil.getBufferedReader;

public class Solver4 {

    public static int solve(String type) {
        try {
            BufferedReader reader = getBufferedReader(type);

            String line;
            while ((line = reader.readLine()) != null) {

            }

            return 0; //TODO: fix


        } catch (Exception ex) {
            System.out.println("OH NO! Something went horribly wrong");
            System.out.println(ex.getMessage());
        }
        return 0;
    }

}
