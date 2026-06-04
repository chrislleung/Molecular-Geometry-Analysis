import java.io.IOException;
import java.util.Scanner;

public class runner {
    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Input file name -> ");
        String filename = input.nextLine();
        Decombiner d = new Decombiner(filename);
        d.print();
    }
}
