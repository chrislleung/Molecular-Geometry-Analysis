import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class CenterFinder {
    private ArrayList<Double> x = new ArrayList<Double>();
    private ArrayList<Double> y = new ArrayList<Double>();
    private ArrayList<Double> z = new ArrayList<Double>();
    private int count;

    public CenterFinder(String filename, int start, int fin) throws IOException{
        File in = new File(filename);
        Scanner fileIn = new Scanner(in);
        load(fileIn,start, fin);
    }

    private void load(Scanner fileIn, int start, int fin){
        //xyz file type
        //skips the first 2 lines
        for (int i = 0; i<start; i++){
            fileIn.nextLine();
        }
        for (int i = 0; i<fin-start; i++){
            fileIn.next();
            x.add(fileIn.nextDouble());
            y.add(fileIn.nextDouble());
            z.add(fileIn.nextDouble());
        }
    }

    public double findAvg(ArrayList<Double> array){
        double avg = 0;
        for (int i = 0; i<array.size(); i++){
            avg+=array.get(i);
        }
        avg/=array.size();

        return avg;
    }

    public void run(){
        findAvg(x);
        findAvg(y);
        findAvg(z);
    }

    public String toString(){
        return ("(" +findAvg(x) +", " +findAvg(y) +", " +findAvg(z) +")");
    }

    public double[] find(){
        double[] a = {findAvg(x), findAvg(y), findAvg(z)};
        return a;
    }
}
