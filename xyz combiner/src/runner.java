import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class runner {

    public static void main(String args[]) throws IOException {
        ArrayList<File> fileList= new ArrayList<File>();
        Scanner userin = new Scanner(System.in);

        System.out.print("How many files to combine -> ");
        int limit = userin.nextInt();
        for (int i = 0; i<limit; i++){
            fileList.add(new File(i+".xyz"));
        }
        String temp = "";

        for (int i = 0; i<fileList.size(); i++){
            Scanner input = new Scanner(fileList.get(i));
            temp += input.next() +"\n";
            temp += "  "+input.next();
            while(input.hasNextLine()){
                temp += input.nextLine() +"\n";
            }
        }
        //System.out.print(temp);
        PrintWriter fileOutput = new PrintWriter("combined.xyz");
        fileOutput.print(temp);
    }
}
