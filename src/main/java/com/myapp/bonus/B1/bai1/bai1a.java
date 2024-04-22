
package com.myapp.bonus.B1.bai1;

/**
 *
 * @author Admin
 */

import java.io.FileInputStream;
import java.io.IOException;

public class bai1a {
    public static void main(String[] args) {
        String filePath = "D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B1\\bai1\\b1.txt";
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int character;
            while ((character = fileInputStream.read()) != -1) {
                System.out.println(character + " " + (char) character);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
