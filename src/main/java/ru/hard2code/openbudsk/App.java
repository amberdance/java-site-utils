package ru.hard2code.openbudsk;

import ru.hard2code.util.Directory;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

    }

    //Driver code
    public static void renderHtmlForLinks() {
        try (var scanner = new Scanner(System.in)) {
            System.out.println("Enter path to the directory:");
            var htmlLinksGenerator = new HtmlLinksGenerator();

            htmlLinksGenerator.setFiles(Directory.getFilesFromDirectory(scanner.nextLine()));
            System.out.println("Enter the relative path to href src attribute:");
            htmlLinksGenerator.setDirectoryOnServer(scanner.nextLine());

            System.out.println("--------------------------");
            System.out.println(htmlLinksGenerator.generateHtml());
        }
    }
}
