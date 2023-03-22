package ru.hard2code.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Directory {

    private Directory() {
        throw new UnsupportedOperationException();
    }

    public static List<Path> getFilesFromDirectory(String path) {
        try (var stream = Files.list(Path.of(path))) {
            return stream.toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
