package kwic;

import java.util.ArrayList;
import java.util.Collections;

public class CircularShift {
    
    private Storage storage;
    private ArrayList<String> ignoreList;
    
    public CircularShift(Storage storage, ArrayList<String> ignoreList) {
        this.storage = storage;
        this.ignoreList = ignoreList;
    }
    
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
            if (ignoreList.get(i).toLowerCase().equals(word)) {
                return true;
            }
        }
        
        return false;

    }

}
