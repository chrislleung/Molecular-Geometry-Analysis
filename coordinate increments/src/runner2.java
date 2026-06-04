import java.io.IOException;
import java.util.Scanner;

public class runner2 { //incrememnts
    public static void main  (String args[])throws IOException{
        Scanner userin = new Scanner(System.in);
        System.out.print("Enter the file name -> ");
        String filename = userin.nextLine();
        System.out.print("Enter which plane to translate (x, y, or z): ");
        String plane = userin.nextLine();
        System.out.print("Enter your increment for the " +plane +" values: ");
        double increment = userin.nextDouble();
        System.out.print("Enter how many times you want to increment " +plane +": ");
        int reps = userin.nextInt();
        diff d = new diff(filename, increment, reps, plane);
    }
}
