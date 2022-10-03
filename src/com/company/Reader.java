package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    private Path path;

    public Reader(Path path) {
        this.path = path;
    }

    public List<String> readToList() throws IOException {
        Stream<String> lines = Files.lines(path);
        return lines.collect(Collectors.toList());
    }
}
