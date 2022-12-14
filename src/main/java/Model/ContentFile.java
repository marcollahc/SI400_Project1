package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for reading the file and performing cleaning operations, removing special characters, removing unnecessary spaces and leaving all lowercase letters, in addition to being able to transform this same text into a two-dimensional vector.
 *
 * @author Thamires de Melo Prado
 * @version 1.0
 */
public class ContentFile {
    private static ContentFile instance = null;

    /**
     * Class constructor
     * @return ContentFile instance of ContentFile class.
     */
    public static ContentFile getInstance() {
        if (instance == null) {
            instance = new ContentFile();
        }
        return instance;
    }

    /**
     * This method is responsible for reading the text file and sanitizing some characters.
     *
     * @param file Path Locale of file on the disk.
     * @return String Full text without special characters, trimmed and all letters in lower case.
     * @throws IOException Exception thrown when there is a problem reading the file.
     */
    public static String filterText(Path file) throws IOException {
        String file_content = Files.readString(file);
        String[] lyrics = file_content.split(System.getProperty("line.separator") + System.getProperty("line.separator"));
        String without_specials = lyrics[1].replaceAll("\\p{Punct}", "");
        String trimmed_text = without_specials.trim();
        String all_letters_lower = trimmed_text.toLowerCase();
        return all_letters_lower;
    }

    /**
     * This method is responsible for transforming a simple text into a vector to facilitate the construction of the digraph.
     *
     * @param text String Plain text sanitezed in the filterText.
     * @return Text gerenerated in filterText transformed in arrays of arrays.
     */
    public static List<List<String>> textSplit(String text) {
        List<List<String>> splited_lines = new ArrayList<>();

        List<String> lines = List.of(text.split(System.getProperty("line.separator")));

        for (String item:lines) {
            List<String> words = List.of(item.split(" "));
            splited_lines.add(new ArrayList<>(words));
        }

        return splited_lines;
    }
}
