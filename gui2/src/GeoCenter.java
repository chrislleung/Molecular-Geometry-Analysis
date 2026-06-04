import java.io.IOException;
import java.util.Scanner;

public class GeoCenter {
//    public static void main(String args[])throws IOException {
//        int start;
//        int end;
//        centerAlignment();
//        System.out.println();
//
//    }
    public static void centerAlignment(String fn, int s1, int e1, int s2, int e2) throws IOException{
        int start = 0;
        int end = 0;
        double[] cenOne = new double[3];
        double[] cenTwo = new double[3];
        for (int i = 0; i<2; i++){
//            Scanner input = new Scanner(System.in);
//            System.out.print("Enter the starting line: " );
//            start = input.nextInt();
//            System.out.print("enter the ending line: ");
//            end = input.nextInt();

            if (i == 0){
                start = s1;
                end = e1;
                CenterFinder o = new CenterFinder(fn, start, end);
                System.out.println("The first center is: " +o.toString());
                cenOne = o.find();
            }
            else{
                start = s2;
                end = e2;
                CenterFinder o = new CenterFinder(fn, start, end);
                System.out.println("The second center is: " +o.toString());
                cenTwo = o.find();
            }
        }
        double diffX = cenTwo[0]-cenOne[0];
        double diffY = cenTwo[1]-cenOne[1];

        newCen n = new newCen(fn, diffX, diffY, start, end);
    }
}
