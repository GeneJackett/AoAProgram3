package com.company;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static void knapsack(int W, String[] items, Integer[] cost, Integer[] val, int n) {
        // i == how many items are you allowed to use
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        // Build table K in bottom up manner

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (cost[i - 1] <= w) {
                    K[i][w] = max(val[i - 1] + K[i - 1][w - cost[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        int optiValue = K[n][W];
        System.out.print("Optimal Value : ");
        System.out.println(optiValue);

        w = W;
        List<String> selectedItems = new ArrayList<>();

        for (i = n; i > 0 && optiValue > 0; i--) {

            if (optiValue == K[i - 1][w])
                continue;
            else {
                selectedItems.add(items[i - 1]);
                optiValue = optiValue - val[i - 1];
                w = w - cost[i - 1];
            }
        }

        for (i = selectedItems.size() - 1; i >= 0; i--) {
            System.out.println(selectedItems.get(i));
        }

    }

    public static void main(String[] args) {

        String file = "items.csv";
        String delimiter = ",";
        String line;

        List<String> item = new ArrayList<>();
        List<Integer> cost = new ArrayList<>();
        List<Integer> val = new ArrayList<>();
        int flag = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                if (flag == 1) {
                    flag = 0;
                    continue;
                }
                String[] values = line.split(delimiter);
                item.add(values[0]);
                cost.add(Integer.parseInt(values[1]));
                val.add(Integer.parseInt(values[2]));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        int n = item.size();
        String[] itemArray = item.toArray(new String[n]);
        Integer[] costArray = cost.toArray(new Integer[n]);
        Integer[] valArray = val.toArray(new Integer[n]);

        int W = 100;
        knapsack(W, itemArray, costArray, valArray, n);

    }
}