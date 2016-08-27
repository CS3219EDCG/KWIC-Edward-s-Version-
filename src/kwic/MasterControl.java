package kwic;
import java.util.ArrayList;

public class MasterControl implements InputListener{
    private Cli cli;
    private ArrayList<String> wordsToIgnore;
    private Storage storage;
    private CircularShift circularShift;
    private Alphabetizer alphabetizer;
    
    public MasterControl() {
        this.storage = new Storage();
        this.cli = new Cli();
        this.wordsToIgnore = new ArrayList<String>();
    }
    
    public void start() {
        cli.addInputListener(this);
        
        cli.start();
    }
    
    public void handleLineAddedEvent(String line) {
      storage.addLine(line);
    }

    public void handleIgnoreWordAddedEvent(String word) {
      wordsToIgnore.add(word);
    }

    public void handleInputFinishedEvent() {
      // Pass to CircularShifter to do shifting
      circularShift = new CircularShift(storage, wordsToIgnore);

      // Pass to AlphabeticalShift to do ordering
      alphabetizer = new Alphabetizer(circularShift);

      // Display to output
      cli.displayOutput(alphabetizer.getLines());
    }
}
