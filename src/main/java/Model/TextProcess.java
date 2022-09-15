package Model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextProcess {
    private String plainText;
    private List<String> graphRow;
    private List<String> uniqueWords;

    public String getPlainText() {
    	return plainText;
    }
    
    public void setPlainText(String plainText) {
    	this.plainText = plainText;
    }
    
    public void transformStringToList(String plainText) {
    	splitTextToList(plainText);
    }
    
    public void splitTextToList(String stringToSplit) {
    	List<String> wordsList = Arrays.asList(stringToSplit.split(" "));
        System.out.println(wordsList);
        
        fillUniqueWords(wordsList);
    }
    
    public void fillUniqueWords(List<String> wordsList) {
    	List<String> wordsListToFill = wordsList;
    	Set<String> mySet = new HashSet<String>(wordsListToFill);
        System.out.println(mySet);
    }
    
    public void fillRowsWords(String text) {}
    public void fillColumnsWords(List<String> text) {}
}
