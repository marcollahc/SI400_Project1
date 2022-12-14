package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Class responsible for performing the reading and writing of files on disk of the user who is using the application.
 *
 * @author Carolina Noda Morishita
 * @author Mariana Pereira Araújo
 * @version 1.0
 */
public class ManagementFile {
    private static ManagementFile instance = null;

    /**
     * Class constructor
     * @return ManagementFile instance of ManagementFile class.
     */
    public static ManagementFile getInstance() {
        if (instance == null) {
            instance = new ManagementFile();
        }
        return instance;
    }

    /**
     * Obtaining files in txt format through a graphical interface.
     *
     * @return List with all files selected in the operational system files management.
     */
    public List<File> getFiles() {
        JFileChooser chooser = new JFileChooser();
        List<File> files_list = new ArrayList<File>();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File .txt", "txt");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(filter);
        chooser.setMultiSelectionEnabled(true);

        int outputChooser = chooser.showOpenDialog(null);

        if (outputChooser == chooser.APPROVE_OPTION) {
            File[] selectedFiles = chooser.getSelectedFiles();
            files_list = Arrays.asList(selectedFiles);
        } else {
            System.out.println("No file selected");
        }
        return files_list;
    }

    /**
     * Get the name of the original file to create a new one with the csv extension.
     *
     * @param path String Absolute file path.
     * @return String Same filename, but with extension changed.
     */
    public static String getFilename(String path) {
        return path.replaceAll(".txt", ".csv");
    }

    /**
     * Method responsible for instantiating the object to read the file.
     *
     * @param file String Absolute file path.
     * @return file Path Object that makes it possible read the file.
     */
    public static Path openFile(String file) {
        return Path.of(file);
    }

    /**
     * @param path String Path where the file will persist on disk
     * @param content String Text that will be stored inside the file
     * @throws IOException Exception thrown when there is a problem writing the file.
     */
    public void writeFile(String path, String content) throws IOException {
        FileWriter file = new FileWriter(path);
        file.write(content);
        file.close();
    }
}
