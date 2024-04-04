import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Driver{
    public static void main(String[] args) {
        
        //ITree englishTree = new BinarySearchTree<String,String>(Comparator<String> comparator);
        ITree<String, ArrayList<String>> englishTree = new BinarySearchTree<>(Comparator.comparing(String::toString));


    }

    public void loadDictionary(String fileName, BinarySearchTree englishTree, BinarySearchTree spanishTree, BinarySearchTree frenchTree) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                Association association = new Association(words[0], words[1], words[2]);
                
                englishTree.insert(words[0], association);
                spanishTree.insert(words[1], association);
                frenchTree.insert(words[2], association);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}