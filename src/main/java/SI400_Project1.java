import Model.ContentFile;
import static Model.ManagementFile.openFile;
import Controller.Digraph;
import Model.TextProcess;

public class SI400_Project1 {
    public static void main(String[] args) { 
        String str = openFile("src/Texto01.txt");
        
        TextProcess processor = new TextProcess();
        String stringToFormat = "Prepare o seu coração pras coisas que eu vou contar contar vou";
        processor.transformStringToList(stringToFormat);
        
        ContentFile content = new ContentFile();
        content.filterText(str);
        System.out.println(str);
    }
}