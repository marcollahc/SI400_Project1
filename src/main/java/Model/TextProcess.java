package Model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class responsible for reading the completely vectorized text and performing operations such as obtaining single words, creating the digraph that puts in sequence the single words, the subsequent words, in addition to converting the digraph vector into plain text.
 *
 * @author Gustavo Ramos Romagnolo
 * @author Marcos César Medeiros
 * @author Mariana Pereira Araújo
 * @version 1.0
 */
public class TextProcess {
    private String plain_text;
    private List<List<String>> full_vector;
    private List<String> unique_words;
    private List<List<String>> graph;

    /**
     * Method to return the state of plain text.
     *
     * @return String All text stored in vector graph converted to string.
     */
    public String getPlainText() {
        return this.plain_text;
    }

    /**
     * Method to save the state of plain text.
     *
     * @param String plain_text Storage of text inside extracted from graph.
     */
    public void setPlainText(String plain_text) {
        this.plain_text = plain_text;
    }

    /**
     * Method to return the state of full text.
     *
     * @return List<List<String>> All text stored in a vector.
     */
    public List<List<String>> getFullVector() {
        return this.full_vector;
    }

    /**
     * Method to save the state of full text.
     *
     * @param List<List<String>>full_vector Storage complete text do comparsion.
     */
    public void setFullVector(List<List<String>> full_vector) {
        this.full_vector = full_vector;
    }

    /**
     * Method to return the state of single words.
     *
     * @return List<String> List of single words taken from the text.
     */
    public List<String> getUniqueWords() {
        return unique_words;
    }

    /**
     * Method to save the state of single words.
     *
     * @param unique_words Storage list with single words taken from the text.
     */
    public void setUniqueWords(List<String> unique_words) {
        this.unique_words = unique_words;
    }

    /**
     * Method to convert the digraph created in the mountDigraph to plain text.
     */
    public void transformListToString() {
        List<String> lines = new ArrayList<>();

        for (List<String> line : this.graph) {
            String row = String.join(", ", line);
            lines.add(row);
        }

        this.setPlainText(String.join("\n", lines));
    }

    /**
     * Method used to get the entire text and keep only single words.
     */
    public void fillUniqueWords() {
        List<List<String>> wordsList = this.getFullVector();

        List<String> oneLineWords = wordsList
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        Set<String> unique_words = new HashSet<>(oneLineWords);
        List<String> list = new ArrayList<>(unique_words);
        Collections.sort(list);

        this.setUniqueWords(list);
    }

    /**
     * Method that uses single words to search for the next word in the full text.
     *
     * @return void
     */
    public void mountDigraph() {
        this.graph = new ArrayList<>();

        List<String> row_digraph;

        for (String unique_word : this.getUniqueWords()) {
            row_digraph = new ArrayList<>();
            row_digraph.add(unique_word);

            boolean add_next = false;

            for (int line_count = 0; line_count < this.getFullVector().size(); line_count++) {
                List<String> full_line = this.getFullVector().get(line_count);

                if (add_next) {
                    String next_word = full_line.get(0);

                    if (!row_digraph.contains(next_word)) {
                        row_digraph.add(next_word);
                    }

                    add_next = false;
                }

                int limit_line = full_line.size();

                for (int word_count = 0; word_count < full_line.size(); word_count++) {
                    String word = full_line.get(word_count);

                    if (word.equals(unique_word)) {
                        if ((word_count + 1) == limit_line) {
                            add_next = true;
                        } else {
                            String next_word = full_line.get(word_count + 1);

                            if (!row_digraph.contains(next_word)) {
                                row_digraph.add(next_word);
                            }
                        }
                    }
                }
            }

            if (row_digraph.size() > 1) {
                this.graph.add(row_digraph);
            }
        }
    }
}