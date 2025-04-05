package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CompareTags{
    ArrayList <String> compareTags;
    ArrayList <String> allTags = new ArrayList<String> ();
    int sameTags;

    public CompareTags(ArrayList <String> comp){
        compareTags = comp;
    }

    public void readFile(){
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
    }

    public int returnTags(){
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
}