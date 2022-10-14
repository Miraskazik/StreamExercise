package org.example;

import org.example.pojo.MyJavaFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindBiggestFile {

    public static Optional<MyJavaFiles> findBiggest(List<MyJavaFiles> filesList){
        return filesList.stream().max(Comparator.comparingLong(MyJavaFiles::getFileSize));
    }
}
