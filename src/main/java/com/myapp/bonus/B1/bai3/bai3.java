
package com.myapp.bonus.B1.bai3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int count = scanner.nextInt();
        scanner.close();

        Random rand = new Random();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B1\\bai3\\bufftest.txt"));
        for (int i = 0; i < count; i++) {
            int randomNum = rand.nextInt();
            bos.write((randomNum + "\n").getBytes());
        }
        bos.close();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B1\\bai3\\bufftest.txt"));
        byte[] contents = new byte[1024];
        int bytesRead = 0;
        String strFileContents = "";
        while((bytesRead = bis.read(contents)) != -1) { 
            strFileContents += new String(contents, 0, bytesRead);              
        }
        System.out.print(strFileContents);
        bis.close();
    }
}
