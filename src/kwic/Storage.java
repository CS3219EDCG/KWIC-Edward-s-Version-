package kwic;

import java.util.ArrayList;
import java.util.Arrays;

/* This is the core storage of the entire program */

public class Storage {
    private ArrayList<String> lines;
    private ArrayList<ArrayList<String>> words;
    
    //Initialisation
    public Storage() {
        this.lines = new ArrayList<String>();
        this.words = new ArrayList<ArrayList<String>>();   
    }
    
    public Storage(ArrayList<String> lines) {
        this.lines = lines;
        this.words = splitLines(lines);
    }
    
    public ArrayList<ArrayList<String>> getAllWords() {
        return words;
    }
    
    public void addLine(String line) {
        lines.add(line);
        words.add(splitLine(line));
    }
    
    //This function splits up all the lines in the arraylist into their own array of words
    private ArrayList<ArrayList<String>> splitLines(ArrayList<String> lines) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        for (int i=0; i< lines.size(); i++) {
            result.add(splitLine(lines.get(i)));
        }
        
        return result;
        
    }
    
    
    //This function splits up the particular line into an array of word
    private ArrayList<String> splitLine(String line) {
        return new ArrayList<String>(Arrays.asList(line.split(" ")));
    }

}
