import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class CenterFinder { //modified CenterFinder to fit the pyramidal program
    private ArrayList<Double> x = new ArrayList<Double>();
    private ArrayList<Double> y = new ArrayList<Double>();
    private ArrayList<Double> z = new ArrayList<Double>();
    private int count;

    public CenterFinder(String filename, ArrayList<Integer> atomList) throws IOException{
        File in = new File(filename);
        Scanner fileIn = new Scanner(in);
        load(fileIn, atomList);
    }

    private void load(Scanner fileIn, ArrayList<Integer> atomList){
        //skips the first line
        fileIn.nextLine();


        int lineNum = 0;
        for (int i = 0; i<atomList.size(); i++){
            while (lineNum!=atomList.get(i)){
                fileIn.nextLine();
                lineNum++;
            }
            fileIn.next();
            x.add(fileIn.nextDouble());
            y.add(fileIn.nextDouble());
            z.add(fileIn.nextDouble());
        }


        //older input type
        //xyz file type
        //skips the first 2 lines
        /*for (int i = 0; i<start; i++){
            fileIn.nextLine();
        }
        for (int i = 0; i<fin-start; i++){
            fileIn.next();
            x.add(fileIn.nextDouble());
            y.add(fileIn.nextDouble());
            z.add(fileIn.nextDouble());
        }

        /*do{
            fileIn.next();
            x.add(fileIn.nextDouble());
            y.add(fileIn.nextDouble());
            z.add(fileIn.nextDouble());
        }while(fileIn.hasNext());*/



        /* //gjf file type
        //skips the first 8 lines
        fileIn.nextLine();fileIn.nextLine();fileIn.nextLine();fileIn.nextLine();fileIn.nextLine();fileIn.nextLine();fileIn.nextLine();

        do{
            fileIn.next();
            fileIn.next();
            x.add(fileIn.nextDouble());
            y.add(fileIn.nextDouble());
            z.add(fileIn.nextDouble());
            fileIn.next();
        }while(fileIn.hasNext());*/
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

    public double getX(){
        return findAvg(x);
    }
    public double getY(){
        return findAvg(y);
    }
    public double getZ(){
        return findAvg(z);
    }
}
