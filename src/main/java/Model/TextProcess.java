package Model;

import java.util.*;

public class TextProcess {
    private String plain_text;
    private List<String> full_vector;
    private List<String> unique_words;
    private List<List<String>> graphRow;

    public String getPlainText() {
        return this.plain_text;
    }

    public void setPlainText(String plain_text) {
        this.plain_text = plain_text;
    }

    public List<String> getFullVector() {
        return full_vector;
    }

    public void setFullVector(List<String> full_vector) {
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
        List<String> wordsList = this.getFullVector();

    	Set<String> unique_words = new HashSet<>(wordsList);
        List<String> list = new ArrayList<>(unique_words);

        Collections.sort(list);
        this.setUniqueWords(list);
    }
    
    public void fillRowsWords(String text) {}
    public void fillColumnsWords(List<String> text) {}

    public void mountDigraph() {
        for (String item:this.getUniqueWords()) {

        }
    }
}
