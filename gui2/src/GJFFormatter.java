import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GJFFormatter {
    public GJFFormatter(String eightLines, int files) throws IOException {
        /*Scanner input = new Scanner(System.in);
        System.out.println("Enter the first 8 lines: ");
        String header = input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine();

        System.out.print("Enter number of files to write -> ");
        int numFiles = input.nextInt();*/

        String header = eightLines;
        int numFiles = files;
        ArrayList<File> fileList = new ArrayList<File>();
        ArrayList<String> writtenFile = new ArrayList<String>();

        //load
        for (int i = 0; i<numFiles; i++){
            fileList.add(new File(i+".xyz"));
        }

        //write
        for (int i = 0; i<numFiles; i++){
            Scanner fileIn = new Scanner(fileList.get(i));
            String temp = "";
            fileIn.nextLine(); fileIn.nextLine();
            do{
                temp += fileIn.nextLine() +"\n";
            }while(fileIn.hasNext());
            writtenFile.add(header +"\n" +temp +"\n \n");
            //System.out.println(writtenFile.get(i));
        }

        ArrayList<PrintWriter> fileOutputs = new ArrayList<PrintWriter>();

        for (int i = 0; i<numFiles; i++){
            String temp = writtenFile.get(i);
            fileOutputs.add(new PrintWriter(i+".gjf"));
            fileOutputs.get(i).print(temp);
            fileOutputs.get(i).close();
        }
    }
}