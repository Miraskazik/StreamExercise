package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.FindBiggestFile.findBiggestFile;

public class FindSmallestFile {
    public static String findSmallestFile(Path path, String s) throws IOException {
        List<Path> result = new ArrayList<>();
        Path finalPath = null;
        long fin = Long.MAX_VALUE;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isRegularFile)
                    .filter(path1 -> path1.getFileName().toString().endsWith(s))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Path p : result) {
            if (fin > Files.size(p)) {
                finalPath = p.getFileName();
                fin = Files.size(p);
            }
        }
        return "Smallest file is " +  finalPath  + " with " + fin  + " B";
    }
}
