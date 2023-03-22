package ru.hard2code.openbudsk;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.hard2code.util.Directory;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HtmlLinksGeneratorTest {

    private static HtmlLinksGenerator instance;

    @BeforeAll
    static void setup() {
        instance = new HtmlLinksGenerator();
    }

    @Test
    void whenRenderedShouldContainsHtml() {
        String linkSrc = "/test/";

        instance.setDirectoryOnServer(linkSrc);
        instance.setFiles(Directory.getFilesFromDirectory("src/test/resources/testfiles/"));

        String html = instance.generateHtml();

        for (Path file : instance.getFiles()) {
            assertTrue(html.contains(linkSrc + file.toFile().getName()));
        }
    }

}