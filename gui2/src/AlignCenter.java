import java.io.IOException;
import java.util.Scanner;

public class AlignCenter {
    public static void centerAlignment(String filename, int[] points, String newName) throws IOException {
        //int start = 0;
        //int end = 0;
        double[] cenOne = new double[3];
        double[] cenTwo = new double[3];
        for (int i = 0; i<2; i++){
            /*
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the starting line: " );
            start = input.nextInt();
            System.out.print("enter the ending line: ");
            end = input.nextInt();
             */
            if (i == 0){
                CenterFinder o = new CenterFinder("0.xyz", points[0], points[1]);
                System.out.println("The first center is: " +o.toString());
                cenOne = o.find();
            }
            else{
                CenterFinder o = new CenterFinder("0.xyz", points[2], points[3]);
                System.out.println("The second center is: " +o.toString());
                cenTwo = o.find();
            }
        }
        double diffX = cenTwo[0]-cenOne[0];
        double diffY = cenTwo[1]-cenOne[1];

        newCen n = new newCen(newName, diffX, diffY, points[2], points[3]);
    }
}
