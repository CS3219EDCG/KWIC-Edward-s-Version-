package kwic;
import java.util.ArrayList; 
import java.util.Scanner;

public class Cli {
    
    private ArrayList<InputListener> inputListeners;

    public Cli() {
      this.inputListeners = new ArrayList<InputListener>();
    }

    public void start(){
      int choice = -1;
      while (choice != 3) {
          printMainMenu();
          choice = readSelection();
          switch (choice) {
              case 1: enterTitle();
                      break;
              case 2: enterWordsToIgnore();
                      break;
              case 3: showResult();
                      break;
              default: errorMessage();
                      break;
          }
      }
    }

    public void errorMessage(){
      System.out.println("Choice must be between 1 and 3");
    }

    public void showResult(){
      System.out.println("Waiting for result...");
      this.notifyInputFinished();
    }

    public void printMainMenu(){
      System.out.println("Welcome to KWIC");
      System.out.println("1. Add a new title");
      System.out.println("2. Add a new word to ignore");
      System.out.println("3. Show result");
      System.out.print("Please enter your choice: ");
    }

    public int readSelection(){
      int selection = -1;
      Scanner input = new Scanner(System.in);
      selection = input.nextInt();

      return selection;
    }

    public void enterTitle(){
      String title = "";
      while(!title.equalsIgnoreCase("q")){
          System.out.print("Please enter the new title (press q to go back): ");
          Scanner input = new Scanner(System.in);
          title = input.nextLine();
          if (! title.equalsIgnoreCase("q")) {
            notifyLineAdded(title);
          }
      }
    }

    public void enterWordsToIgnore(){
          String word = "";
          while (!word.equalsIgnoreCase("q")){
          System.out.print("Please enter the new word to ignore (press q to go back): ");
          Scanner input = new Scanner(System.in);
          word = input.nextLine();
          if (!word.equalsIgnoreCase("q")) {
            notifyIgnoredWordAdded(word);
          }
          }
    }

    public void displayOutput(ArrayList<String> lines) {
      for (int i = 0; i < lines.size(); i++) {
        System.out.println(lines.get(i));
      }
    }

    public void addInputListener(InputListener listener) {
      this.inputListeners.add(listener);
    }

    private void notifyLineAdded(String line) {
      for (InputListener listener : this.inputListeners) {
        listener.handleLineAddedEvent(line);
      }
    }

    private void notifyIgnoredWordAdded(String word) {
      for (InputListener listener : this.inputListeners) {
        listener.handleIgnoreWordAddedEvent(word);
      }
    }

    private void notifyInputFinished() {
      for (InputListener listener : this.inputListeners) {
        listener.handleInputFinishedEvent();
      }
    }
}
