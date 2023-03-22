package ru.hard2code.openbudsk;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hard2code.jni.StrCmpLogicalWComparator;

import java.nio.file.Path;
import java.util.List;

@Data
@NoArgsConstructor
class HtmlLinksGenerator {

    private List<Path> files;
    private String directoryOnServer;

    public HtmlLinksGenerator(List<Path> files, String directoryOnServer) {
        this.files = files.stream().sorted(StrCmpLogicalWComparator.WINDOWS_NATIVE_ORDER).toList();
        this.directoryOnServer = directoryOnServer;
    }

    public String generateHtml() {
        var result = new StringBuilder();
        result.append("<ul>").append("\n");

        for (var file : files) {
            var fileName = file.getFileName().toString();

            result.append(String.format("   <li><a href='%s' download>%s<a></li>%n",
                    directoryOnServer + fileName, fileName));
        }

        result.append("<ul>").append("\n");

        return result.toString();
    }
}
