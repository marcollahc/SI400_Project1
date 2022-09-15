package Model;

import java.util.List;

public class ContentFile {
    private String text_file;
    private List<String> text_vector;

    public String getText() {}
    public void setText(String text) {}
    public List<String> getVector() {}
    public void setVector(List<String> text) {}
    
    public String filterText(String firtAux) {
        String secondAux = firtAux.replaceAll("\\p{Punct}", "");
        String thirdAux = secondAux.replaceAll("\n", " ");
        System.out.println("\nSEM PONTUAÇÃO:\n");
        String result = thirdAux.toLowerCase();
        
        return result;
    }
    
    public List<String> textSplit(List<String> text) {}
}
