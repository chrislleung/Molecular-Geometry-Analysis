import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Decombiner {
    private ArrayList<String> list = new ArrayList<>();

    public Decombiner(String filename) throws IOException {
        File in = new File(filename);
        Scanner fileIn = new Scanner(in);
        load(fileIn);
    }
    private void load(Scanner file){
        do{
            String temp = "";
            int limit = file.nextInt();
            temp += limit;
            temp += file.nextLine() +"\n";
            for (int i = 0; i<=limit; i++){
                temp+= file.nextLine() +"\n";
            }
            list.add(temp);
        }while (file.hasNextInt());
    }

    public void print() throws IOException{
        ArrayList<PrintWriter> fileOutputs = new ArrayList<PrintWriter>();

        for (int i = 0; i<list.size(); i++){
            fileOutputs.add(new PrintWriter(i+".xyz"));
            fileOutputs.get(i).print(list.get(i));
            fileOutputs.get(i).close();
        }
    }
}
