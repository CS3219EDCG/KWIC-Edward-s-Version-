package kwic;

public interface InputListener {
    
    public void handleLineAddedEvent(String line);

    public void handleIgnoreWordAddedEvent(String word);

    public void handleInputFinishedEvent();
}
