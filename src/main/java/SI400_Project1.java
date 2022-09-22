import Model.ContentFile;
import Model.ManagementFile;
import Model.TextProcess;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SI400_Project1 {
    public static void main(String[] args) throws IOException {
        ManagementFile management = new ManagementFile();
        ManagementFile.getInstance();
        ArrayList<String> arrayTest = management.getFiles();
        arrayTest.forEach(element -> {
            try {
                Path file = ManagementFile.openFile("./src/" + element + ".txt");
    
                ContentFile content_file = ContentFile.getInstance();
                String text_content = content_file.filterText(file);
                List<List<String>> text_vector = content_file.textSplit(text_content);
    
                TextProcess processor = new TextProcess();
                processor.setFullVector(text_vector);
                processor.fillUniqueWords();
                processor.mountDigraph();
            } catch (Exception e) {
                System.out.println("Unexpected error in file " + element + ": " + e);
            }
        });
    }
}
