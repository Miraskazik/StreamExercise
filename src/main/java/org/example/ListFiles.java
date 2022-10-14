package org.example;

import org.example.pojo.MyJavaFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ListFiles {
    public static List<MyJavaFiles> listFilesNew(Path path, String s) {
        List<MyJavaFiles> filesList;
        try (Stream<Path> filesStream = Files.walk(path)) {
            filesList = filesStream
                    .filter(Files::isRegularFile)
                    .filter(path1 -> path1.getFileName().toString().endsWith(s))
                    .map(path2 -> {
                        try {
                            return MyJavaFiles.builder()
                                    .fileName(String.valueOf(path2.getFileName()))
                                    .fileSize(Files.size(path2))
                                    .path(path2)
                                    .build();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filesList;
    }

    public static Optional<Long> checkAllSize(Path path) {
        List<MyJavaFiles> filesList;
        try (Stream<Path> filesStream = Files.walk(path)) {
            filesList = filesStream
                    .map(path2 -> {
                        try {
                            return MyJavaFiles.builder()
                                    .fileName(String.valueOf(path2.getFileName()))
                                    .fileSize(Files.size(path2))
                                    .build();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return filesList
                .stream()
                .map(MyJavaFiles::getFileSize)
                .reduce(Long::sum);
    }

}
