import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class CenterFinder2 {
    private ArrayList<Double> x = new ArrayList<Double>();
    private ArrayList<Double> y = new ArrayList<Double>();
    private ArrayList<Double> z = new ArrayList<Double>();

    private ArrayList<String> c = new ArrayList<String>();
    private int count;

    public CenterFinder2(String filename, int start, int fin) throws IOException{
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
        for (int i = 0; i<=fin-start; i++){
            c.add(fileIn.next());
            x.add(fileIn.nextDouble());
            y.add(fileIn.nextDouble());
            z.add(fileIn.nextDouble());
        }
    }

    public ArrayList<Double> getX(){
        return x;
    }
    public ArrayList<Double> getY(){
        return y;
    }
    public ArrayList<Double> getZ(){
        return z;
    }
    public ArrayList<String> getC(){
        return c;
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
