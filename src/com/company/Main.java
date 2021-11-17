package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    /*public class knapsack{
        static int max(int a, int b){
            return(a>b) ? a : b;
        }
        static int knapSack(int W, int cost[], int value, int n){
            int i,w;
            int K[][] = new int[n+1][W+1];
            //Build table K in bottom up manner
            for(i=0;i<=n; i++){
                for (w=0;w<=W; w++){
                    if(i == 0 || w ==0){
                        K[i][w] = 0;
                    }
                    else if(cost[i-1]<){
                        K[i][w] = max();//not sure
                    }
                    else{
                        K[i][w] = K[i];//not sure
                    }
                }
            }
            return K[n][W];
        }
    }

     */

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
                //make call to function

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
