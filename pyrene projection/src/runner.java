import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class runner {
    public static double[] p1;
    public static double[] p2;
    public static double[] p3;
    public static String filename;
    public static double[] v1;
    public static double[] v2;
    public static double[] cross;
    public static double[] atom;

    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the file name: ");
        filename = in.nextLine();
        System.out.print("Please enter the first point number: ");
        p1 = load(in.nextInt());
        System.out.print("Please enter the second point number: ");
        p2 = load(in.nextInt());
        System.out.print("Please enter the third point number: ");
        p3 = load(in.nextInt());

        //v1 = p2-p1
        //v2 = p3-p1
        v1 = diffCoords(p1, p2);
        v2 = diffCoords(p1, p3);

        cross = crossProduct(v1, v2);

        System.out.print("Please enter the number of atoms in the pyrene: ");
        int numAtoms = in.nextInt();

        NumberFormat numFormat = new DecimalFormat("0.##########E0");

        String output = numAtoms +"\n" +"\n";
        System.out.println(numAtoms +"\n");
        for (int i = 1; i<=numAtoms; i++){
            atom = load(i);

            //distance
            double distance = getDistance();

            //projected point
            String zPoint;
            double[] pp =getPP(distance);


            if (pp[2] < 0.001){
                pp[2] = 0;
            } else{
                zPoint =  Double.toString(pp[2]);
            }

            output += "c " +pp[0] +"\t " +pp[1] +"\t " +pp[2] +"\n";
            System.out.println("c " +pp[0] +"\t " +pp[1] +"\t " +pp[2]);
        }

        PrintWriter fileOutput = new PrintWriter("001.xyz");
        fileOutput.print(output);
        fileOutput.close();
    }

    public static double[] getPP(double distance){
        double[] ret = new double[3];
        int x = 0; int y = 1; int z = 2;

        ret[x] = atom[x] - distance*cross[x];
        ret[y] = atom[y] - distance*cross[y];
        ret[z] = atom[z] - distance*cross[z];

        return ret;
    }
    public static double[] load(int rowNum) throws IOException {
        File in = new File(filename);
        Scanner file = new Scanner(in);
        double[] coords = new double[3];

        //skips the first line only because the row numbers start at 1
       file.nextLine();

        for (int i = 0; i<rowNum; i++){
            file.nextLine();
        }

        file.next();
        coords[0] = file.nextDouble();
        coords[1] = file.nextDouble();
        coords[2] = file.nextDouble();
        return coords;
    }

    public static double[] diffCoords(double[] c1, double[] c2){
        double[] diff = new double[3];
        diff[0] = c2[0]-c1[0];
        diff[1] = c2[1]-c1[1];
        diff[2] = c2[2]-c1[2];
        return diff;
    }

    public static double[] crossProduct(double[] var1, double[] var2){
        double[] cross = new double[3];
        int x = 0; int y = 1; int z = 2;

        cross[0] = (var1[y]*var2[z]) - (var1[z]*var2[y]);
        cross[1] = (var1[x]*var2[z]) - (var1[z]*var2[x]);
        cross[2] = (var1[y]*var2[x]) - (var1[x]*var2[y]);

        return cross;
    }

    public static double getDistance(){
        double ret;
        int x = 0; int y = 1; int z = 2;

        ret = (atom[x]*cross[x]) + (atom[y]*cross[y]) + (atom[z]*cross[z]);

        return ret;
    }
}
