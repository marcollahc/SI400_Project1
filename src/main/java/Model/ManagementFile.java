package Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.List;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
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
     * @param file absolute file path
     * @return file object that makes it possible read the file
     */
    public static Path openFile(String file) {
        return Path.of(file);
    }

    public void writeFile(String path) {
        
    // first create file object for file placed at location
    // specified by filepath
    File file = new File(path);
    try {
        // create FileWriter object with file as parameter
        FileWriter outputfile = new FileWriter(file);
  
        // create CSVWriter object filewriter object as parameter
        CSVWriter writer = new CSVWriter(outputfile);
        
        String delimiter = ",";
        
		String result = "", prefix = "";
		for (String s: file.list())
		{
			result += prefix + s;
			prefix = delimiter;
		}
      
        writer.writeNext(result);

        // closing writer connection
        writer.close();
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
   
    }
}
