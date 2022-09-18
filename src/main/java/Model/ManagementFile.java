package Model;

import java.nio.file.Path;

public class ManagementFile {
    private static ManagementFile instance = null;

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