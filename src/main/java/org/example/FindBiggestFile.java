package org.example;

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
    public static String findBiggestFile(Path path, String s) throws IOException {
        List<Path> result = new ArrayList<>();
        long fin = 0;
        Path finalPath = null;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isRegularFile)
                    .filter(path1 -> path1.getFileName().toString().endsWith(s))
                    .collect(Collectors.toList());
        }
        catch (RuntimeException e){
            System.out.println("Path not found");
        }
        for (Path p: result) {
            if(fin<Files.size(p)){
                finalPath = p.getFileName();
                fin = Files.size(p);
        }
        }
        //        return result;
        return "Biggest file is " +  finalPath  + " with " + fin  + " B";
    }
}
