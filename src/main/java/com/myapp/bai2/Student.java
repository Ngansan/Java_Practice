
package com.myapp.bai2;

public class Student {
    private String mssv;
    private String name;
    private String date;

    public Student() {
    }

    public Student(String mssv, String name, String date) {
        this.mssv = mssv;
        this.name = name;
        this.date = date;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
