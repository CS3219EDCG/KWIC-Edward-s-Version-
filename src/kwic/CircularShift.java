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
