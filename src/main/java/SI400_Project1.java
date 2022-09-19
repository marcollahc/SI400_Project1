import Model.ContentFile;
import Model.ManagementFile;
import Model.TextProcess;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class SI400_Project1 {
    public static void main(String[] args) throws IOException {
        Path file = ManagementFile.getInstance().openFile("./src/TextoValidacao01.txt");

        ContentFile content_file = ContentFile.getInstance();
        String text_content = content_file.filterText(file);
        List<List<String>> text_vector = content_file.textSplit(text_content);

        System.out.println(text_vector);

        TextProcess processor = new TextProcess();
        processor.setFullVector(text_vector);
        processor.fillUniqueWords();
        processor.mountDigraph();
    }
}