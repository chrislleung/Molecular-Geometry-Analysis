import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class diffZ {
    double increment;
    int reps;
    private ArrayList<String> files = new ArrayList<String>();
    public diffZ(String filename, double i, int r) throws IOException {
        increment = i;
        reps = r;
        load(filename);
    }
    private void load(String filename)throws IOException{
        File in = new File(filename);
        for (int i = 0; i<reps; i++){
            Scanner fileIn = new Scanner(in);
            double inc = increment*i;
            String temp = "";
            temp += fileIn.nextLine()+"\n";     //System.out.print(temp);
            temp += fileIn.nextLine()+"\n";
            while (fileIn.hasNext()){
                temp += fileIn.next() + "\t";
                temp += fileIn.nextDouble() +"\t";
                temp += fileIn.nextDouble() +"\t";
                temp += (fileIn.nextDouble()+inc) +"\n";
            }
            files.add(temp);
        }
        printer();
    }

    public void printer() throws IOException{
        ArrayList<PrintWriter> p = new ArrayList<PrintWriter>();

        for (int i = 0; i<files.size(); i++){
            p.add(new PrintWriter("z" +i +".xyz"));
            p.get(i).print(files.get(i));
            p.get(i).close();
        }
    }

}
