package org.example;

import org.example.pojo.MyJavaFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FindSmallestFile {

    public static Optional<MyJavaFiles> findSmallest(List<MyJavaFiles> filesList){
        return filesList.stream().min(Comparator.comparingLong(MyJavaFiles::getFileSize));
    }

}
