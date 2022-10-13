package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.example.FindBiggestFile.findBiggestFile;
import static org.example.FindSizeOfAll.findAllSize;
import static org.example.FindSmallestFile.findSmallestFile;
import static org.example.ListFiles.listFiles;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get(".");
        String s = ".java";
        List<Path> paths = listFiles(path,s);
        paths.forEach(System.out::println);
        System.out.println("xxxxxxxxxx");
        System.out.println(findSmallestFile(path,s));
        System.out.println(findBiggestFile(path,s));
        System.out.println("Size of project is " + findAllSize(path) + "B");    }
}