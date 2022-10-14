package org.example;

import org.example.pojo.MyJavaFiles;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static org.example.FindBiggestFile.findBiggest;
import static org.example.FindSmallestFile.findSmallest;
import static org.example.ListFiles.checkAllSize;
import static org.example.ListFiles.listFilesNew;


public class Main {
    public static void main(String[] args)  {
        Path path = Paths.get(".");
        List<MyJavaFiles> filesList = listFilesNew(path,".java");
        Optional<MyJavaFiles> smallest = findSmallest(filesList);
        Optional<MyJavaFiles> biggest = findBiggest(filesList);

        filesList.forEach(System.out::println);
        System.out.println("xxxxxxxxxxxxxxxx");
        System.out.print("Biggest file is: ");
        findBiggest(filesList).ifPresent(System.out::println);
        System.out.println("xxxxxxxxxxxxxxxx");
        System.out.print("Smallest file is: ");
        findSmallest(filesList).ifPresent(System.out::println);
        System.out.println("xxxxxxxxxxxxxxxx");
        System.out.print("Size of all files is: ");
        checkAllSize(path).ifPresent(System.out::println);
    }
}