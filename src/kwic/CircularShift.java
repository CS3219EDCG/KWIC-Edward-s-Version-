package kwic;

import java.util.ArrayList;
import java.util.Collections;

public class CircularShift {
    
    private ArrayList<String> ignoreList;
    private ArrayList<ArrayList<String>> shiftedList;
    
    public CircularShift(Storage storage, ArrayList<String> ignoreList) {
        this.ignoreList = ignoreList;
        this.shiftedList = shiftLines(storage.getAllWords());
    }
    
    public ArrayList<String> getShiftedList() {       
        
        ArrayList<String> newList = new ArrayList<String>();
        
        for (int i=0; i<shiftedList.size(); i++) {
            String line = new String();
            for (int j=0; j<shiftedList.get(i).size(); j++) {
                line.concat(shiftedList.get(i).get(j) + " ");
            }
            newList.add(line);
        }
        
        return newList;
    }
    
    //Shift one line only
    private ArrayList<ArrayList<String>> shiftLine (ArrayList<String> words) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (!inIgnoreList(words.get(0))) {
            result.add(words);
        }
        
        for (int i=1; i<words.size(); i++) {
            ArrayList<String> tempResult = new ArrayList<String>(words);
            Collections.rotate(tempResult, -1);
            
            if (!inIgnoreList(tempResult.get(0))) {
                result.add(tempResult);
            }
            
            words = tempResult;
        }
        
        caseSet(result);
        return result;
    }
    
    //Shift several lines at one time
    private ArrayList<ArrayList<String>> shiftLines (ArrayList<ArrayList<String>> lines) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        for (int i=0; i<lines.size(); i++) {
            ArrayList<String> words = lines.get(i);
            for (ArrayList<String> listShifts : shiftLine(words)) {
                result.add(listShifts);
            }
        }
        
        return result;
    }
    
    //Setting upper/lower case
    private void caseSet(ArrayList<ArrayList<String>> words) {
        for (int i=0; i<words.size(); i++) {
            for (int j=0; j< words.get(i).size(); j++) {
                String word = words.get(i).get(j);
                if (inIgnoreList(word)) {
                    String iWord = word.toLowerCase();
                    words.get(i).set(j, iWord);
                } else {
                    String nWord = word.substring(0, 1).toUpperCase() + word.substring(1);
                    words.get(i).set(j, nWord);
                }
                
            }
        }
    }
    
    private boolean inIgnoreList(String word) {
        for (int i=0; i<ignoreList.size(); i++) {
            if (ignoreList.get(i).toLowerCase().equals(word.toLowerCase())) {
                return true;
            }
        }
        
        return false;

    }

}
