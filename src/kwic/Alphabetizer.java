package kwic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//This is the class that organises the lines created in ascending order

public class Alphabetizer {

    private CircularShift circularShift;
    private ArrayList<String> lines;
    
    //Initialisation
    public Alphabetizer(CircularShift circularShift) {
        this.circularShift = circularShift;
        this.lines = this.alphabetizer(circularShift.getShiftedList());
    }
    
    //Comparator class for overriding comparison of String
    class arrListComparator implements Comparator<String> {

        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
        
    }
    
    //For testing
    public void printLines() {
        for (String line : lines) {
            System.out.println(line);
        }
    }
    
    //Sorting the lines in ascending order
    private ArrayList<String> alphabetizer(ArrayList<String> rLines) {
        Collections.sort(rLines, new arrListComparator());
        return rLines;
    }
    
    //For the main class to call to retrieve the lines
    public ArrayList<String> getLines() {
        return lines;
    }
    
}
