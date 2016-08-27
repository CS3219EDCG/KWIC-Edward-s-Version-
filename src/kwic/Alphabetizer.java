package kwic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer {

    private CircularShift circularShift;
    private ArrayList<String> lines;
    
    public Alphabetizer(CircularShift circularShift) {
        this.circularShift = circularShift;
        this.lines = this.alphabetizer(circularShift.getShiftedList());
    }
        
    class arrListComparator implements Comparator<String> {

        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
        
    }
    
    private ArrayList<String> alphabetizer(ArrayList<String> rLines) {
        Collections.sort(rLines, new arrListComparator());
        return rLines;
    }
    
}
