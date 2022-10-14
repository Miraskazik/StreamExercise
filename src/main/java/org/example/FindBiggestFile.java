package org.example;

import org.example.pojo.MyJavaFiles;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindBiggestFile {

    public static Optional<MyJavaFiles> findBiggest(List<MyJavaFiles> filesList){
        return filesList.stream().max(Comparator.comparingLong(MyJavaFiles::getFileSize));
    }
}
