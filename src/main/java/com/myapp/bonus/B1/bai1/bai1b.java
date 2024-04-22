
package com.myapp.bonus.B1.bai1;

import java.io.FileOutputStream;
import java.io.IOException;

public class bai1b {
    public static void main(String[] args) {
        String message = "We are the best group";
        try (FileOutputStream fileOutputStream = new FileOutputStream("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B1\\bai1\\b2.txt")) {
            fileOutputStream.write(message.getBytes());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
