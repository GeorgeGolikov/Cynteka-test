package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Writer {
    private Path path;

    public Writer(Path path) {
        this.path = path;
    }

    public void writeListToFile(List<String> list) throws IOException {
        Files.write(path, list);
    }
}
