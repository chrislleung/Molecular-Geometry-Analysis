import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class runner {
    public static double[] p1;
    public static double[] p2;
    public static double[] p3;
    public static double[] c1;
    public static double[] c2;
    public static double[] c3;
    public static String filename;
    public static double[] v1;
    public static double[] v2;
    public static double[] v3;
    public static double[] v4;
    public static double[] plane1;
    public static double[] plane2;
    public static double[] atom;

    public static void main(String argsp[]) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the file name: ");
        filename = in.nextLine();

        System.out.print("Please enter the first point number: ");
        p1 = load(in.nextInt());
        System.out.print("Please enter the second point number: ");
        p2 = load(in.nextInt());
        System.out.print("Please enter the third point number: ");
        p3 = load(in.nextInt());
        System.out.println();
        System.out.print("Please enter the first point number: ");
        c1 = load(in.nextInt());
        System.out.print("Please enter the second point number: ");
        c2 = load(in.nextInt());
        System.out.print("Please enter the third point number: ");
        c3 = load(in.nextInt());


        //v1 = p2-p1
        //v2 = p3-p1
        v1 = diffCoords(p1, p2);
        v2 = diffCoords(p1, p3);
        v3 = diffCoords(c1, c2);
        v4 = diffCoords(c1, c3);

        plane1 = crossProduct(v1, v2);
        plane2 = crossProduct(v3, v4);

        //====================================
        double mag1 = magOf(plane1);
        double mag2 = magOf(plane2);

        double[] n1 = by(plane1, mag1);
        double[] n2 = by(plane2, mag2);

        double dotProduct = getDotProduct(n1, n2);

        double angle = Math.acos(dotProduct);

        System.out.println("\nThe angle is: " + angle +" radians");
        angle *= (180/Math.PI);
        System.out.println("\nThe angle is: " + angle +" degrees");

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
    public static double getDotProduct(double[] pl1, double[] pl2){
        double ret;
        int x = 0; int y = 1; int z = 2;

        ret = (pl1[x]*pl2[x]) + (pl1[y]*pl2[y]) + (pl1[z]*pl2[z]);

        return ret;
    }
    public static double magOf(double[] pl){
        int x = 0; int y = 1; int z = 2;

        return Math.sqrt((pl[x]*pl[x]) + (pl[y]*pl[y]) + (pl[z]*pl[z]));
    }
    public static double[] by(double[] pl, double factor){
        double[] ret = new double[3];
        ret[0] = pl[0]/factor;
        ret[1] = pl[1]/factor;
        ret[2] = pl[2]/factor;

        return ret;
    }
}
