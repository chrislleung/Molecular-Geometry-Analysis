import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CoordinateIncrements {
    public static void inc(String filename, String plane, double increment, int reps) throws IOException{
        diff d = new diff(filename, increment, reps, plane);
    }
}

class diff {
    double increment;
    int reps;
    private ArrayList<String> files = new ArrayList<String>();
    String name;
    public diff(String filename, double i, int r, String plane) throws IOException {
        increment = i;
        reps = r;
        name = plane;
        if (plane.equals("x")){
            load1(filename);
        }else if (plane.equals("y")){
            load2(filename);
        }else {
            load3(filename);
        }

    }
    private void load1(String filename)throws IOException{
        File in = new File(filename);
        for (int i = 0; i<reps; i++){
            Scanner fileIn = new Scanner(in);
            double inc = increment*i;
            String temp = "";
            temp += fileIn.nextLine()+"\n";     //System.out.print(temp);
            temp += fileIn.nextLine()+"\n";
            while (fileIn.hasNext()){
                temp += fileIn.next() + "\t";
                temp += (fileIn.nextDouble()+inc +"\t");
                temp += fileIn.nextDouble() +"\t";
                temp += fileIn.nextDouble() +"\t"  +"\n";
            }
            files.add(temp);
        }
        printer();
    }
    private void load2(String filename)throws IOException{
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
                temp += (fileIn.nextDouble()+inc +"\t");
                temp += fileIn.nextDouble() +"\t"  +"\n";
            }
            files.add(temp);
        }
        printer();
    }
    private void load3(String filename)throws IOException{
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
            p.add(new PrintWriter( name +i +".xyz"));
            p.get(i).print(files.get(i));
            p.get(i).close();
        }
    }
}

