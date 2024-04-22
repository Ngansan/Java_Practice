
package com.myapp.bonus.B1.bai1;


import java.io.FileInputStream;
import java.io.IOException;

public class bai1c {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B1\\bai1\\b1.txt")) {
            byte[] buffer = new byte[10];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.println(buffer[i] + " " + (char) buffer[i]);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
