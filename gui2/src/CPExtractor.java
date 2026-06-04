import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CPExtractor {
    public CPExtractor(String filename, ArrayList<Integer> list) throws IOException{
        Scanner in = new Scanner(System.in);
        //ask which critical point to download
        //search for the string
        //ask for the type (maybe)
        //line number starts from 0

        /*
        System.out.print("Enter filename: ");
        String filename = in.nextLine();

        int num = 0;
        //ArrayList<Integer> list = new ArrayList<Integer>();
        /*
        do{
            System.out.print("Enter the CP # (enter 0 to exit): ");
            num = in.nextInt();
            if (num == 0){
                break;
            }

            int lineNum = locateNum(filename, num);
            list.add(lineNum);
            //System.out.println(lineNum);
        } while (num>0);

        //debug
        //System.out.println(toString(filename, list.get(0)));
        */
        String print = "";
        for (int i = 0; i<list.size(); i++){
            System.out.println(toString(filename, list.get(i)));
            print += toString(filename, list.get(i));
        }

        printer(print);
    }

    public static int locateNum(String filename, int num) throws IOException {
        File input = new File(filename);
        Scanner file = new Scanner(input);
        int lineNum = 1;


        while (file.hasNext()){
            String temp = file.next();      //debug
            //System.out.println(temp);
            if (!temp.equals("----------------")){
                lineNum++;
                file.nextLine();
            } else{
                temp = file.next();         //debug
                //System.out.println(temp);
                if (file.next().equals(num+",")){
                    return lineNum;
                } else{
                    lineNum++;
                    lineNum+=5;
                    file.nextLine();
                }
            }
        }

        return -1;
    }

    public static String toString(String filename, int lineNum) throws IOException{
        File input = new File(filename);
        Scanner file = new Scanner(input);
        String ret = "";
        int currentLine = 0;

        for (int i = 1; i<lineNum; i++){
            file.nextLine();
        }
        for (int i = 0; i<8; i++){
            ret += file.nextLine();
            ret +="\n";
            currentLine++;
        }
        for (int i = currentLine; i<11; i++) {
            file.nextLine();
            currentLine++;
        }
        for (int i = currentLine; i<13; i++) {
            ret += file.nextLine();
            ret +="\n";
            currentLine++;
        }
        for (int i = currentLine; i<20; i++) {
            file.nextLine();
            currentLine++;
        }
        for (int i = currentLine; i<21; i++) {
            ret += file.nextLine();
            ret +="\n";
            currentLine++;
        }
        for (int i = currentLine; i<26; i++) {
            file.nextLine();
            currentLine++;
        }
        for (int i = currentLine; i<28; i++) {
            ret += file.nextLine();
            ret +="\n";
            currentLine++;
        }
        for (int i = currentLine; i<30; i++) {
            file.nextLine();
            currentLine++;
        }
        ret += file.nextLine();
        ret +="\n";

        return ret;
    }
    public static void printer(String print) throws IOException{
        PrintWriter fileOutput = new PrintWriter("CPextracted.txt");
        fileOutput.print(print);
        fileOutput.close();
    }
}



//extract line that is found
//extract 7 lines after
//extract 11, 12, 13, 20, 21, 26, 27, 28, 30
//loop