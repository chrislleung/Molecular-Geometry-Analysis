import java.io.IOException;
import java.util.Scanner;

public class Runner{
    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Input file name -> ");
        String filename = input.nextLine();
        //String filename = "ch3cooh.log";
        System.out.print("Input new file name (without the file type) -> ");
        String newName = input.nextLine();
        Formatter f = new Formatter(filename);
        f.print(newName);
        //Formatter f = new Formatter("test.txt");

    }
}