package kwic;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Storage storage = new Storage();
        
        Scanner sc = new Scanner(System.in);
        
        //For users to enter the movie titles
        System.out.println("Enter movie titles here:");
        List<String> titles = new ArrayList<String>();
        String input = sc.nextLine();
        while(!input.isEmpty()){
            titles = Arrays.asList(input.split(", "));
            input = sc.nextLine();
        }
        
        //Adding the movie titles to the database
        for (int i=0; i<titles.size(); i++) {
            storage.addLine(titles.get(i));
            //System.out.println(titles.get(i));
        }
        
        //For users to enter words to ignore and storing the words in the database
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
        
        /* ArrayList<ArrayList<String>> testC = new ArrayList<ArrayList<String>>();
        testC = storage.getAllWords();
        for (int i=0; i<testC.size(); i++) {
            for (int j=0; j<testC.get(i).size(); j++)
            System.out.println(testC.get(i).get(j));
        } */
        
        //Data sent to circular shift class for processing
        CircularShift circularShift = new CircularShift(storage, ignoreList);
        
        //circularShift.printList();
        
        //Data sent to alphabetizer for processing
        Alphabetizer alphabetizer = new Alphabetizer(circularShift);
        
        //alphabetizer.printLines();
        
        //Retriving the finalised results from the alphabetizer
        ArrayList<String> result = new ArrayList<String>();
        result = alphabetizer.getLines();
        
        //Printing the results
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
        
        System.exit(0);
        
    }

}
