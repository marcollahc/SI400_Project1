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
     * @param Path file Locale of file on the disk.
     * @return String Full text without special characters, trimmed and all letters in lower case.
     * @throws IOException
     */
    public static String filterText(Path file) throws IOException {
        String file_content = Files.readString(file);
        String[] lyrics = file_content.split("\n\n");
        String without_specials = lyrics[0].replaceAll("\\p{Punct}", "");
        String trimmed_text = without_specials.trim();
        String all_letters_lower = trimmed_text.toLowerCase();
        return all_letters_lower;
    }

    /**
     * This method is responsible for transforming a simple text into a vector to facilitate the construction of the digraph.
     *
     * @param String text Plain text sanitezed in the filterText.
     * @return List<List<String>> Text gerenerated in filterText transformed in arrays of arrays.
     */
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
