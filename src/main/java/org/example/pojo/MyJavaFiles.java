package org.example.pojo;

import lombok.*;

import java.nio.file.Path;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyJavaFiles {
    private String fileName;
    private long fileSize;
    private Path path;
}
