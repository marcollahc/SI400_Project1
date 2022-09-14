package Model;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ManagementFile {
    private List<Files> files_list;

    public List<Files> getFiles() {}
    public void setFiles(List<Files>) {}


    // Para fazer rodar na main: colocar o método numa String com o local do arquivo
    // Exemplo: String texto = openFile(src/Texto01.txt);
    // e para printar: System.out.println(texto);
    public static String openFile(String file) {
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace;
        }
        return "";
    }

    public void writeFile(String path) {}
}