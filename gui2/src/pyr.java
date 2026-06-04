import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class pyr {
    public static double p(String fn, int a1, int a2, int a3, int compared) throws IOException {
        Scanner in = new Scanner(System.in);

//        System.out.print("Please enter the name of the file: ");
//        String filename = in.nextLine();

        String filename = fn;

        ArrayList<Integer> list = new ArrayList<Integer>();

//        System.out.print("Please enter the first atom number: ");
//        list.add(in.nextInt());
//        System.out.print("Please enter the second atom number: ");
//        list.add(in.nextInt());
//        System.out.print("Please enter the third atom number: ");
//        list.add(in.nextInt());

        list.add(a1);
        list.add(a2);
        list.add(a3);

        list = sort(list);

        CenterFinder3 c = new CenterFinder3(filename, list);

        //System.out.print(c);

        ArrayList<Integer> num = new ArrayList<Integer>();
//        System.out.print("Please enter the comparing atom number: ");
//        num.add(in.nextInt());
        num.add(compared);


        CenterFinder3 n = new CenterFinder3(filename, num);

        //System.out.print(n);

        //System.out.println("Distance: " +findDiff(c, n));
        return findDiff(c, n);
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> list){
        Integer temp;
        if (list.size()>1) // check if the number of orders is larger than 1
        {
            for (int x=0; x<list.size(); x++) // bubble sort outer loop
            {
                for (int i=0; i < list.size()-i; i++) {
                    if (list.get(i).compareTo(list.get(i+1)) > 0)
                    {
                        temp = list.get(i);
                        list.set(i,list.get(i+1) );
                        list.set(i+1, temp);
                    }
                }
            }
        }
        return list;
    }
    private static double findDiff(CenterFinder3 c, CenterFinder3 n){
        double result = Math.sqrt(
                Math.pow(c.getX()-n.getX(), 2)
                        + Math.pow(c.getY()-n.getY(), 2)
                        + Math.pow(c.getZ()-n.getZ(), 2)
        );

        return result;
    }

}
