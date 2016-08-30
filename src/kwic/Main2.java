package kwic;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Storage storage = new Storage();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter movie titles here:");
        List<String> titles = new ArrayList<String>();
        String input = sc.nextLine();
        while(!input.isEmpty()){
            titles = Arrays.asList(input.split(", "));
            input = sc.nextLine();
        }
        
        for (int i=0; i<titles.size(); i++) {
            storage.addLine(titles.get(i));
        }
        
        System.out.println("Enter words to ignore: ");
        String inputIgnore = sc.nextLine();
        ArrayList<String> ignoreList = new ArrayList<String>();
        while(!inputIgnore.isEmpty()){
            String[] ignoreWordsArr = inputIgnore.split(", ");
            for(int i = 0; i < ignoreWordsArr.length; i++){
                ignoreList.add(ignoreWordsArr[i]);
            }
            inputIgnore = sc.nextLine();
        }
        
        CircularShift circularShift = new CircularShift(storage, ignoreList);
        
        Alphabetizer alphabetizer = new Alphabetizer(circularShift);
        
        ArrayList<String> result = new ArrayList<String>();
        result = alphabetizer.getLines();
        
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
        
        System.exit(0);
        
    }

}
