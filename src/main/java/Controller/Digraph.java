package Controller;

import Model.ContentFile;
import Model.ManagementFile;
import Model.TextProcess;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Digraph {
    public void makeDigraph() {
        ManagementFile management_file = ManagementFile.getInstance();

        ArrayList<String> arrayTest = management_file.getFiles();

        arrayTest.forEach(element -> {
            try {
                Path file = management_file.openFile("./src/" + element + ".txt");

                ContentFile content_file = ContentFile.getInstance();
                String text_content = content_file.filterText(file);
                List<List<String>> text_vector = content_file.textSplit(text_content);

                TextProcess processor = new TextProcess();
                processor.setFullVector(text_vector);
                processor.fillUniqueWords();
                processor.mountDigraph();

                /*
                Criar um método para converter o graph dentro da TextProcess para texto,
                removendo respeitando as quebras de linha e concatenando as palavras por vírgula.
                */

                /*
                Obter o texto gerado no passo anterior, e salvar com o mesmo nome do arquivo inserido,
                mas com a a extensão .csv.
                */
            } catch (Exception e) {
                System.out.println("Unexpected error in file " + element + ": " + e);
            }
        });
    }
}
