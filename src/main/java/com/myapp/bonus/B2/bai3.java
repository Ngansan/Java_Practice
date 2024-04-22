
package com.myapp.bonus.B2;

import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class bai3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = scanner.nextInt();
        double[][] matrix = new double[rows][cols];
        Random rand = new Random();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = rand.nextDouble();
            }
        }

        PrintWriter writer = new PrintWriter(new FileWriter("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B2\\btvn.txt"));
        for (double[] row : matrix) {
            for (double num : row) {
                writer.print(num + " ");
            }
            writer.println();
        }
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B2\\btvn.txt"));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
