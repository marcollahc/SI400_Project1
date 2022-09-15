import Controller.Digraph;
import Model.TextProcess;

public class SI400_Project1 {
    public static void main(String[] args) {
        TextProcess processor = new TextProcess();
        String stringToFormat = "Prepare o seu coração pras coisas que eu vou contar contar vou";
        processor.transformStringToList(stringToFormat);
    }
}
