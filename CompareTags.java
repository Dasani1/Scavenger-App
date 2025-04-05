import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CompareTags {

    ArrayList <String> allTags;
    ArrayList <String> compareTags;
    int sameTags;
    Scanner s;

    public CompareTags(ArrayList<String> comp){
        compareTags = comp;
    }

    public void readFile(){
        s = new Scanner(new File("Tags.txt"));
        int i = 0;
        while(s.hasNext()){
            allTags.set(i, s.nextLine());
            i++;
        }
    }

    public int commonTags(){
        sameTags = 0;
        for (int i = 0; i < allTags.size(); i++){
            for (int j = 0; j < compareTags.size(); j++){
                if (allTags.get(i).equals((compareTags.get(j)))){
                    sameTags++;
                }
            }
        }
        return sameTags;
    }
    public static void main(String [] args){
        ArrayList<String> co = new ArrayList<String>();
        co.add("A");
        co.add("B");
        co.add("C"); 
        CompareTags c = new CompareTags(co);
        c.readFile();
        System.out.println(c.commonTags());
    }

    /* The class would be an object which uses a sorting algorithm */
}