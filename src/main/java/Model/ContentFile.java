package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ContentFile {
    private static ContentFile instance = null;

    public static ContentFile getInstance() {
        if (instance == null) {
            instance = new ContentFile();
        }
        return instance;
    }
    
    public static String filterText(Path file) throws IOException {
        String file_content = Files.readString(file);
        String[] lyrics = file_content.split("\n\n");
        String without_specials = lyrics[1].replaceAll("\\p{Punct}", "");
        String trimmed_text = without_specials.trim();
        String one_line = trimmed_text.replaceAll("\n", " ");

        return one_line.toLowerCase();
    }
    
    public static List<String> textSplit(String text) {
        return List.of(text.split(" "));
    }
}
