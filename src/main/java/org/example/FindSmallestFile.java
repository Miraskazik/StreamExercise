package org.example;

import org.example.pojo.MyJavaFiles;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class FindSmallestFile {

    public static Optional<MyJavaFiles> findSmallest(List<MyJavaFiles> filesList){
        return filesList.stream().min(Comparator.comparingLong(MyJavaFiles::getFileSize));
    }

}
