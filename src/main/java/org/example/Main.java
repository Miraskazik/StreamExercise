package org.example;

import org.example.pojo.MyJavaFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.example.FindBiggestFile.findBiggest;
import static org.example.FindSmallestFile.findSmallest;
import static org.example.ListFiles.*;


public class Main {
    public static void main(String[] args)  {
        Path path = Paths.get(".");
        List<MyJavaFiles> filesList = listFilesNew(path,".java");
        Optional<MyJavaFiles> smallest = findSmallest(filesList);
        Optional<MyJavaFiles> biggest = findBiggest(filesList);

        filesList.forEach(System.out::println);
        if (smallest.isPresent() && biggest.isPresent()){
            System.out.println("Biggest file is: " + biggest.get().getFileName() + " " + biggest.get().getFileSize() + "B");
            System.out.println("Smallest file is: " + smallest.get().getFileName() + " " + smallest.get().getFileSize() + "B");
        }
        checkAllSize(path).ifPresent(System.out::println);
    }
}