package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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

        return trimmed_text.toLowerCase();
    }
    
    public static List<List<String>> textSplit(String text) {
        List<List<String>> splited_lines = new ArrayList<>();

        List<String> lines = List.of(text.split("\n"));

        for (String item:lines) {
            List<String> words = List.of(item.split(" "));
            splited_lines.add(new ArrayList<>(words));
        }

        return splited_lines;
    }
}
