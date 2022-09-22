package Model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagementFile {
    private static ManagementFile instance = null;

    public ArrayList<String> getFiles() {
        ArrayList<String> files_list = new ArrayList<>();

        System.out.println("Please enter the archive name and press Enter: ");
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(line.isEmpty()) {
                break;
            }
            files_list.add(line);
        }
        input.close();
        return files_list;
    }

    public static ManagementFile getInstance() {
        if (instance == null) {
            instance = new ManagementFile();
        }
        return instance;
    }

    public static Path openFile(String file) {
        return Path.of(file);
    }

    public void writeFile(String path) {}
}
