package ru.hard2code.openbudsk;

import ru.hard2code.util.Directory;

public class App {

    public static void main(String[] args) {
        var generator = new HtmlLinksGenerator(Directory.getFilesFromDirectory("C:\\Users\\NotFoundException" +
                "\\Downloads\\1"), "/upload/2023/");

        System.out.println(generator.generateHtml());
    }
}
