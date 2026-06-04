import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RingDistanceCalc {
    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of molecules -> ");
        int numMol = input.nextInt();
        System.out.print("Enter the number of rings per molecule -> ");
        int numRings = input.nextInt();
        input.nextLine();
        System.out.print("Enter the file name -> ");
        String filename = input.nextLine();


        Rings[][] ring = new Rings[numMol][numRings];

        //System.out.println(ring.length);
        //System.out.println(ring[1].length);
        System.out.println();
        for (int i = 0; i < ring.length; i++) {      //load Rings objects with atom numbers
            for (int k = 0; k < ring[i].length; k++) {
                int mol = i + 1;
                int r = k + 1;
                System.out.print("Enter the starting atom # for mol" + mol + "ring" + r + " -> ");
                int temp1 = input.nextInt();
                System.out.print("Enter the ending atom # for mol" + mol + "ring" + r + " -> ");
                int temp2 = input.nextInt();

                ring[i][k] = new Rings(temp1, temp2, filename);
                ring[i][k].findCenter();
                System.out.println();
            }
        }

        for (int i = 0; i < ring.length - 1; i++) {
            for (int k = 0; k < ring[i].length; k++) {
                for (int x = i + 1; x < ring.length; x++) {
                    for (int y = 0; y < ring[x].length; y++) {
                        int mol = i + 1;
                        int r = k + 1;
                        int mol2 = x + 1;
                        int r2 = y + 1;
                        System.out.println("The distance between mol" + mol + "ring" + r + " and mol" + mol2 + "ring" + r2 + ": " + diff3d(ring[i][k].getX(),
                                        ring[i][k].getY(),
                                        ring[i][k].getZ(),
                                        ring[x][y].getX(),
                                        ring[x][y].getY(),
                                        ring[x][y].getZ()
                                )
                        );
                    }
                }
            }
        }
        System.out.println();
        input.nextLine();
        PrintWriter p = new PrintWriter(filename.substring(0, filename.length()-4) + ".gjf");
        System.out.println("Enter the first 8 lines: ");
        String header = input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine() +"\n"+input.nextLine();
        p.print(header +"\n");
        System.out.print("Enter the starting atom # to freeze -> ");
        int freezeStart = input.nextInt();
        System.out.print("Enter the ending atom # to freeze -> ");
        int freezeEnd = input.nextInt();

        int count = 0;

        for (int i = ring.length-1; i >=0; i--) {
            for (int k = 0; k < ring[i].length; k++) {
                for (int x = 0; x<ring.length; x++){
                    for (int y = 0; y < ring[x].length; y++) {
                        for (int z = 0; z < ring[x][y].getXsize(); z++){
                            if (i != x) {
                                int mol = i + 1;
                                int r = k + 1;
                                int mol2 = x + 1;
                                int r2 = y + 1;
                                int atomNum = z + 1;
                                int check = 0;



                                System.out.println("The distance between mol" + mol + "ring" + r + " and mol" + mol2 + "ring" + r2 + " atom " + atomNum + ": " + diff3d(ring[i][k].getX(),
                                                ring[i][k].getY(),
                                                ring[i][k].getZ(),
                                                ring[x][y].getCoordX(z),
                                                ring[x][y].getCoordY(z),
                                                ring[x][y].getCoordZ(z)
                                        )
                                );
                                System.out.println("\t The x distance between mol" + mol + "ring" + r + " and mol" + mol2 + "ring" + r2 + " atom " + atomNum + ": " + diff(ring[i][k].getX(), ring[x][y].getCoordX(z)));
                                System.out.println("\t The y distance between mol" + mol + "ring" + r + " and mol" + mol2 + "ring" + r2 + " atom " + atomNum + ": " + diff(ring[i][k].getY(), ring[x][y].getCoordY(z)));
                                System.out.println("\t The z distance between mol" + mol + "ring" + r + " and mol" + mol2 + "ring" + r2 + " atom " + atomNum + ": " + diff(ring[i][k].getZ(), ring[x][y].getCoordZ(z)));

                                count++;
                                //SUPER IMPORTANT
                                p.print(ring[x][y].getAtomType(z) +"\t");
                                if (count>=freezeStart && count<=freezeEnd){
                                    p.print("-1");
                                } else{
                                    p.print("0");
                                }
                                p.print("\t"+ring[x][y].getCoordX(z) +"\t" +ring[x][y].getCoordY(z) +"\t" +ring[x][y].getCoordZ(z) +"\t");


                                if (diff(ring[i][k].getX(), ring[x][y].getCoordX(z)) < 2) {
                                    check++;
                                }
                                if (diff(ring[i][k].getY(), ring[x][y].getCoordY(z)) < 2) {
                                    check++;
                                }
                                if (diff(ring[i][k].getZ(), ring[x][y].getCoordZ(z)) < 2) {
                                    check++;
                                }

                                if (check >= 2) {
                                    System.out.println("\t\t close enough !");
                                    p.println("H");
                                }else{
                                    p.println("M");
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
            p.close();
        }


        /*for (int i = 0; i < ring.length; i++) {
            for (int k = 0; k < ring[i].length; k++) {
                for (int x = 0; x<ring.length; x++){
                    for (int y = 0; y < ring[x].length; y++) {
                        for (int z = 0; z < ring[x][y].getXsize(); z++){
                            if (i != x) {
                                int mol = i + 1;
                                int r = k + 1;
                                int mol2 = x + 1;
                                int r2 = y + 1;
                                int atomNum = z + 1;
                                int check = 0;

                                System.out.println("The distance between mol" + mol + "ring" + r + " and mol" + mol2 + "ring" + r2 + " atom " + atomNum + ": " + diff3d(ring[i][k].getX(),
                                                ring[i][k].getY(),
                                                ring[i][k].getZ(),
                                                ring[x][y].getCoordX(z),
                                                ring[x][y].getCoordY(z),
                                                ring[x][y].getCoordZ(z)
                                        )
                                );
                                System.out.println("\t The x distance between mol" + mol + "ring" + r + " and mol" + mol2 + "ring" + r2 + " atom " + atomNum + ": " + diff(ring[i][k].getX(), ring[x][y].getCoordX(z)));
                                System.out.println("\t The y distance between mol" + mol + "ring" + r + " and mol" + mol2 + "ring" + r2 + " atom " + atomNum + ": " + diff(ring[i][k].getY(), ring[x][y].getCoordY(z)));
                                System.out.println("\t The z distance between mol" + mol + "ring" + r + " and mol" + mol2 + "ring" + r2 + " atom " + atomNum + ": " + diff(ring[i][k].getZ(), ring[x][y].getCoordZ(z)));

                                if (diff(ring[i][k].getX(), ring[x][y].getCoordX(z)) < 2) {
                                    check++;
                                }
                                if (diff(ring[i][k].getY(), ring[x][y].getCoordY(z)) < 2) {
                                    check++;
                                }
                                if (diff(ring[i][k].getZ(), ring[x][y].getCoordZ(z)) < 2) {
                                    check++;
                                }

                                if (check >= 2) {
                                    System.out.println("\t\t close enough !");
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }*/
    }

    public static double diff3d(double x1, double y1, double z1, double x2, double y2, double z2) {
        /*System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);*/
        return Math.sqrt(Math.pow(Math.abs(y2 - y1), 2) + Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(Math.abs(z2 - z1)), 2));
    }

    public static double diff(double x1, double x2){
        return Math.abs(x2-x1);
    }
}

