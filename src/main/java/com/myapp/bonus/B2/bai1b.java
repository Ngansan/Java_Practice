
package com.myapp.bonus.B2;


import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class bai1b {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B2\\A2.txt"))) {
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int[] array = list.stream().mapToInt(i -> i).toArray();
    }
}
