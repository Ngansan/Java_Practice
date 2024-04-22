
package com.myapp.bonus.B2;


import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class bai1a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        try (PrintWriter printWriter = new PrintWriter("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B2\\A2.txt")) {
            for (int i : array) {
                printWriter.println(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
