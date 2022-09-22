package Model;

import java.util.*;
import java.util.stream.Collectors;

public class TextProcess {
    private String plain_text;
    private List<List<String>> full_vector;
    private List<String> unique_words;

    private List<List<String>> graph;

    public String getPlainText() {
        return this.plain_text;
    }

    public void setPlainText(String plain_text) {
        this.plain_text = plain_text;
    }

    public List<List<String>> getFullVector() {
        return this.full_vector;
    }

    public void setFullVector(List<List<String>> full_vector) {
        this.full_vector = full_vector;
    }

    public List<String> getUniqueWords() {
        return unique_words;
    }

    public void setUniqueWords(List<String> unique_words) {
        this.unique_words = unique_words;
    }

    /* public void transformStringToList(String plain_text) {
    	splitTextToList(plain_text);
    } */

    /* public void splitTextToList(String stringToSplit) {
    	String[] wordsList = Arrays.asList(stringToSplit.split(" "));
        System.out.println(wordsList);

        fillUniqueWords(wordsList);
    } */
    
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

    public String nextWord(List<String> row) {
        return "";
    }

    public void mountDigraph() {
        this.graph = new ArrayList<>();

        List<String> row_digraph = null;

        for (String unique_word : this.getUniqueWords()) {
            row_digraph = new ArrayList<>();
            row_digraph.add(unique_word);

            boolean add_next = false;

            for (int line_count = 0; line_count < this.getFullVector().size(); line_count++) {
                List<String> full_line = this.getFullVector().get(line_count);

                /* if (add_next) {
                    String next_word = full_line.get(0);

                    if (row_digraph.indexOf(next_word) < 0) {
                        row_digraph.add(next_word);
                    }

                    add_next = false;
                } */

                int limit_line = full_line.size();

                for (int word_count = 0; word_count < full_line.size(); word_count++) {
                    String word = full_line.get(word_count);

                    if (word == unique_word) {
                        System.out.printf("word: " + word + "| ");
                        if ((word_count + 1) == limit_line) {
                            add_next = true;
                        } else {
                            String next_word = full_line.get(word_count + 1);

                            System.out.printf("word: " + word + " -> next_word: " + next_word + "\n");

                            if (row_digraph.indexOf(next_word) < 0) {
                                row_digraph.add(next_word);
                            }
                        }
                    }
                }
                System.out.printf("\n");
            }

            if (row_digraph.size() > 1) {
                this.graph.add(row_digraph);
            }
        }

        /* for (List<String> row:this.graph) {
            for (String column:row) {
                System.out.printf(column + ", ");
            }
            System.out.printf("\n");
        } */
    }
}
