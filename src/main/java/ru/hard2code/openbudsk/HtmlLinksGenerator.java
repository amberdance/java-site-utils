package ru.hard2code.openbudsk;

import com.google.common.io.Files;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import ru.hard2code.jni.StrCmpLogicalWComparator;

import java.nio.file.Path;
import java.util.List;

@Data
@NoArgsConstructor
class HtmlLinksGenerator {

    private List<Path> files;
    private String directoryOnServer;

    public HtmlLinksGenerator(List<Path> files, String directoryOnServer) {
        setFiles(files);
        this.directoryOnServer = directoryOnServer;
    }

    public void setFiles(List<Path> files) {
        this.files = files.stream().sorted(StrCmpLogicalWComparator.WINDOWS_NATIVE_ORDER).toList();
    }


    public String generateHtml() {
        var result = new StringBuilder();
        result.append("<ul>").append("\n");

        for (var file : files) {
            var fileName = file.getFileName();

            result.append(String.format("   <li><a href='%s' download>%s</a></li>%n",
                    directoryOnServer + fileName,
                    StringUtils.capitalize(Files.getNameWithoutExtension(fileName.toString()))));
        }

        result.append("</ul>").append("\n");

        return result.toString();
    }
}
