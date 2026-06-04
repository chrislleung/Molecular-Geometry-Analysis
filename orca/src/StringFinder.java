import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StringFinder {
    Scanner input;
    File f;
    public StringFinder(File file) throws IOException {
        f = file;
    }
    public int find(String phrase) throws IOException{
        input = new Scanner(f);
        int count = 0;
        while (input.hasNextLine()){
            if(input.nextLine().contains(phrase)){
                //System.out.println("a");
                return count;
            }
            count++;

        }
        return -1;
    }
}
