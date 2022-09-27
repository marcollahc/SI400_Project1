package Controller;

import Model.ContentFile;
import Model.ManagementFile;
import Model.TextProcess;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

/**
 * Controller class responsible for coordinating the modeling classes to perform the task of reading the files and writing a digraph in csv format.
 *
 * @author Carolina Noda Morishita
 * @author Gustavo Ramos Romagnolo
 * @author Marcos César Medeiros
 * @author Mariana Pereira Araújo
 * @author Thamires de Melo Prado
 * @version 1.0
 */
public class Digraph {
    /**
     * Method responsible for coordinating the project classes to obtain and generate the files, resulting in the digraph.
     *
     */
    public void makeDigraph() {
        ManagementFile management_file = ManagementFile.getInstance();

        List<File> arrayFiles = management_file.getFiles();

        arrayFiles.forEach(element -> {
            try {
                String filetostring = element.toString();
                Path file = management_file.openFile(filetostring);

                ContentFile content_file = ContentFile.getInstance();
                String text_content = content_file.filterText(file);
                List<List<String>> text_vector = content_file.textSplit(text_content);

                TextProcess processor = new TextProcess();
                processor.setFullVector(text_vector);
                processor.fillUniqueWords();
                processor.mountDigraph();
                processor.transformListToString();
                String digraph = processor.getPlainText();

                String new_filename = management_file.getFilename(filetostring);
                management_file.writeFile(new_filename, digraph);
            } catch (Exception e) {
                System.out.println("Unexpected error in file " + element + ": " + e);
            }
        });
    }
}