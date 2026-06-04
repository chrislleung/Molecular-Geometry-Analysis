import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class newCen {
    private double diffX;
    private double diffY;
    private int start;
    private int end;
    public newCen(String filename, double xdif, double ydif, int s, int e)throws IOException{
        diffX = xdif;
        diffY = ydif;
        start = s;
        end = e;
        File in = new File(filename);
        Scanner fileIn = new Scanner(in);
        load(fileIn);
    }

    private void load(Scanner fileIn) throws IOException{
        PrintWriter fileOut = new PrintWriter("1.xyz");
        for (int i = 0; i<start; i++){
            fileOut.print(fileIn.nextLine()+"\n");
        }
        for (int i = start; i<end; i++){
            fileOut.print(fileIn.next()+"\t");
            fileOut.print(fileIn.nextDouble()-diffX+"\t");
            fileOut.print(fileIn.nextDouble()-diffY+"\t");
            fileOut.print(fileIn.nextDouble()+"\n");
        }
        fileOut.close();
    }
}
