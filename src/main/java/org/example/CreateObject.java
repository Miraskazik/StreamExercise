package org.example;

import org.example.pojo.MyJavaFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateObject {

    public static MyJavaFiles createObject(Path path){
        try {
            return MyJavaFiles.builder()
                    .fileName(String.valueOf(path.getFileName()))
                    .fileSize(Files.size(path))
                    .path(path)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
