import java.io.IOException;
import java.util.Scanner;

public class runner {
    public static void main(String args[])throws IOException {
        int start;
        int end;
        //centerAlignment();
        System.out.println();

        /*do{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the starting line: " );
            start = input.nextInt();
            System.out.print("Enter the ending line: ");
            end = input.nextInt();
            if (start!=end){
                CenterFinder o = new CenterFinder("1.xyz", start, end);
                System.out.println(o.toString());
            }
        } while(start!=end);*/


        Scanner userin = new Scanner(System.in);
        System.out.print("Enter your increment for the z values: ");
        double increment = userin.nextDouble();
        System.out.print("enter how many times you want to increment z: ");
        int reps = userin.nextInt();
        diffZ d = new diffZ("1.xyz", increment, reps);

    }
    public static void centerAlignment() throws IOException{
        int start = 0;
        int end = 0;
        double[] cenOne = new double[3];
        double[] cenTwo = new double[3];
        for (int i = 0; i<2; i++){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the starting line: " );
            start = input.nextInt();
            System.out.print("enter the ending line: ");
            end = input.nextInt();
            if (i == 0){
                CenterFinder o = new CenterFinder("0.xyz", start, end);
                System.out.println("The first center is: " +o.toString());
                cenOne = o.find();
            }
            else{
                CenterFinder o = new CenterFinder("0.xyz", start, end);
                System.out.println("The second center is: " +o.toString());
                cenTwo = o.find();
            }
        }
        double diffX = cenTwo[0]-cenOne[0];
        double diffY = cenTwo[1]-cenOne[1];

        newCen n = new newCen("0.xyz", diffX, diffY, start, end);
    }
}
