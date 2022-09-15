import Model.ContentFile;
import static Model.ManagementFile.openFile;

public class SI400_Project1 {
    public static void main(String[] args) { 
        String str = openFile("src/Texto01.txt");
        
        ContentFile content = new ContentFile();
        content.filterText(str);
        System.out.println(str);
}
}