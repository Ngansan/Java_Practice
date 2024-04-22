
package com.myapp.bonus.B2;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    String id;
    String name;
    String classRoom;
    Double grade;

    public Student(String id, String name, String classRoom, Double grade) {
        this.id = id;
        this.name = name;
        this.classRoom = classRoom;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.classRoom + " " + this.grade;
    }
}

public class bai2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Student> students = new ArrayList<>();
        System.out.println("Enter the students information in format (id, name, class, grade) (each separated by a space):");
        for (int i = 0; i < n; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            students.add(new Student(inputs[0], inputs[1], inputs[2], Double.parseDouble(inputs[3])));
        }
        PrintWriter writer = new PrintWriter(new File("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B2\\sinhvien.txt"), "UTF-8");
        for (Student student : students) {
            writer.println(student.toString());
        }
        writer.close();

        System.out.print("Enter a student id to remove from the list:");
        String removeId = scanner.next();
        scanner.close();
        List<String> studentLinesAfterRemoving = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File("D:\\code_java\\BTTH3\\src\\main\\java\\com\\myapp\\bonus\\B2\\sinhvien.txt"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (!line.split(" ")[0].equals(removeId)) {
                studentLinesAfterRemoving.add(line);
            }
        }
        fileScanner.close();
        PrintWriter writerAfterRemoving = new PrintWriter("sinhvien.txt", "UTF-8");
        for (String studentLine : studentLinesAfterRemoving) {
            writerAfterRemoving.println(studentLine);
        }
        writerAfterRemoving.close();
    }
}