import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Rings {
    private int start;
    private int end;
    private String filename;
    private double[] center = new double[3];

    private ArrayList<Double> x = new ArrayList<Double>();
    private ArrayList<Double> y = new ArrayList<Double>();
    private ArrayList<Double> z = new ArrayList<Double>();
    private ArrayList<String> ch = new ArrayList<String>();


    public Rings(int s, int e, String f) throws IOException{
        start = s;
        end = e;
        filename = f;

        CenterFinder c = new CenterFinder(filename, start+2, end+2);
        x = c.getX();
        y = c.getY();
        z = c.getZ();
        ch = c.getC();
    }

    public double[] getCenter(){
        return center;
    }
    public double getX(){
        return center[0];
    }
    public double getY(){
        return center[1];
    }
    public double getZ(){
        return center[2];
    }
    public int getXsize(){
        return x.size();
    }

    public double getCoordX(int i){
        return x.get(i);
    }
    public double getCoordY(int i){
        return y.get(i);
    }
    public double getCoordZ(int i){
        return z.get(i);
    }
    public String getAtomType(int i){
        return ch.get(i);
    }

    public void findCenter() throws IOException{
        CenterFinder c = new CenterFinder(filename, start+2, end+2);
        center = c.find();
    }


}
