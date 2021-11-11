package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String line = "";
        try {

            // Create an object of file reader
            // class with CSV file as a parameter.
            boolean firstLine = true;
            BufferedReader br = new BufferedReader(new FileReader("items.csv"));
            while ((line = br.readLine()) != null) {
                if (firstLine == true) {
                    firstLine = false;
                    continue;
                }
                String[] attributes = line.split(",");
                if (attributes[1].indexOf('"') == 0) {
                    int j = 1;
                    do {
                        j++;
                        attributes[1] += ("," + attributes[j]);
                    } while (attributes[j].indexOf('\"') == -1);
                    attributes[1].replace("\"", "");
                    attributes[2] = attributes[j + 1];
                }
                System.out.println(Arrays.toString(attributes));


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
