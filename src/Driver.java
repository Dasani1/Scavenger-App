import java.util.Scanner;
import java.util.ArrayList;

public class Driver {

    public static void main (String [] args){
        ArrayList <String> co = new ArrayList<String>();
        System.out.print("Please enter searchable tags (enter q to quit):");
        Scanner s = new Scanner(System.in);
        String line = " ";
        while (!(line.equals("q"))){
            line = s.nextLine();
            co.add(line);
        }
        s.close();
        CompareTags c = new CompareTags(co);
        c.readFile();
        System.out.print(c.returnTags());
    }
}
