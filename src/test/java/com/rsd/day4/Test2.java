package com.rsd.day4;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Test2 {
    void printJavaFileName(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                printJavaFileName(f.getPath());
            } else {
                if (f.getName().endsWith(".java")) {
                    System.out.println(f.getName());
                }
            }
        }
    }

    void searchFile(String path, String fileName) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                searchFile(f.getPath(), fileName);
            } else {
                if (f.getName().equals(fileName)) {
                    System.out.println(f.getName() + "\t" + f.getPath());
                }
            }
        }
    }


    @Test
    public void test1() {
        printJavaFileName("D:\\IntelliJ IDEA project");
    }

    @Test
    public void test2() {
        searchFile("D:\\IntelliJ IDEA project", "SysUser.java");
    }
}
