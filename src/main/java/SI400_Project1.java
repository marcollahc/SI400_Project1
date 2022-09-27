import Controller.Digraph;

import java.io.IOException;

/**
 * Class responsible for initializing the program that will create the digraphs from the provided files.
 *
 * @author Marcos César Medeiros
 * @version 1.0
 */
public class SI400_Project1 {
    /**
     * Method responsible for initializing the project.
     *
     * @param args default parameter list for the main method.
     */
    public static void main(String[] args) {
        try {
            Digraph digraph = new Digraph();
            digraph.makeDigraph();
        } catch (Exception e) {
            System.out.println("Unexpected error in application " + e);
        }
    }
}