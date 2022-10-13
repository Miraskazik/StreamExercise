package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindSizeOfAll {

    public static long findAllSize(Path path) throws IOException {
        List<Path> result = new ArrayList<>();
        long t = 0;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
        for (Path p:result) {
            t = t + Files.size(p);
        }
        return t;
    }
}
