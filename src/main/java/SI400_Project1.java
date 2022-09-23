import Controller.Digraph;
import Model.ContentFile;
import Model.ManagementFile;
import Model.TextProcess;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SI400_Project1 {
    public static void main(String[] args) throws IOException {
        Digraph digraph = new Digraph();
        digraph.makeDigraph();
    }
}
