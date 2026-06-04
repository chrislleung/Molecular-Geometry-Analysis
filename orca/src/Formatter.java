import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Formatter {
    StringFinder finder;
    String out = "";
    File in;
    public Formatter(String filename) throws IOException {
        in = new File(filename);
        Scanner fileIn = new Scanner(in);
        finder = new StringFinder(in);
        load();
    }

    private void load() throws IOException{
        Scanner file = new Scanner(in);
        int set = finder.find("Summary of contributions to the inner energy");
        for (int i = 0; i<=set; i++){
            file.nextLine();
        }
        //System.out.println(set);
        out += file.nextLine()+"\n";out += file.nextLine()+"\n";out += file.nextLine()+"\n";out += file.nextLine()+"\n";out += file.nextLine()+"\n";out += file.nextLine()+"\n";out += file.nextLine()+"\n";
        load2();
    }
    private void load2() throws IOException{
        Scanner file = new Scanner(in);
        int set = finder.find("Thermal Enthalpy correction");
        for (int i = 0; i<=set; i++){
            file.nextLine();
        }
        out += file.nextLine()+"\n";out += file.nextLine()+"\n";

    }

    public void print(String filename) throws FileNotFoundException {
        System.out.println(out);
        PrintWriter fileOutput1 = new PrintWriter(filename +".txt");
        fileOutput1.print(out);
        fileOutput1.close();

    }
}
