package src;

import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    int [] fileTagNum = new int[3];
    String [] fileTagNames = {"Abbey Park Highschool", "Hilltop Viewpoint", "Windrush Park"}; 

    public static void main (String[] args) {
        Driver d = new Driver(); // Create Driver object
        ArrayList<String> co = new ArrayList<String>();
        
        System.out.println("Please enter searchable tags (enter q to quit):");
        String line = " ";
        
        // Loop to read searchable tags and calculate tags
        for (int i = 0; i < d.fileTagNames.length; i++) {
            Scanner s = new Scanner(System.in);
            while (!line.equals("q")) {
                line = s.nextLine();
                if (!line.equals("q")) {
                    co.add(line); // Add tags to co list
                }
            }
            s.close();
            
            CompareTags c = new CompareTags(co, i + 1); // Create CompareTags object
            c.readFile();
            d.fileTagNum[i] = c.returnTags(); // Store result in fileTagNum
        }

        // Call returning method to print the results based on fileTagNum
        d.returning();
    }

    public void returning() {
        // Find the index of the tag with the most matches
        int maxIndex = 0;
        for (int i = 1; i < fileTagNum.length; i++) {
            if (fileTagNum[i] > fileTagNum[maxIndex]) {
                maxIndex = i;
            }
        }

        // Print the fileTagNames based on the sorted order of matches
        System.out.println("Tag with most matches: " + fileTagNames[maxIndex]);
    }
}