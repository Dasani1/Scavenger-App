import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CompareTags{
    public CompareTags(){}
    public static void main(String [] args) throws IOException{
        //instance variables
        ArrayList <String> allTags = new ArrayList<String> ();
        ArrayList <String> compareTags = new ArrayList<String>();
        compareTags.add("A");
        compareTags.add("B");
        compareTags.add("C"); 
        int sameTags;
        //read file
        try{
            BufferedReader s = new BufferedReader(new FileReader("Tags.txt"));
            String line;
            while ((line = s.readLine()) != null) {
                allTags.add(line);
            }
            s.close();
        }
        catch(IOException e){
            System.out.print("ERROR");
        }

        //compare tags

        sameTags = 0;
        for (int i = 0; i < allTags.size(); i++){
            for (int j = 0; j < compareTags.size(); j++){
                if (allTags.get(i).equals((compareTags.get(j)))){
                    sameTags++;
                }
            }
        }
        System.out.println(sameTags);
    }

    /* The class would be an object which uses a sorting algorithm */
}