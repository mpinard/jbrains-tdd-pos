package mpinard.jbrains.tdd.pos;

public class TestDisplay implements Display {
    
    private String text = "";
    
    @Override
    public void setText(final String text) {
        this.text = text;
    }
    
    String getText() {
        return text;
    }
}
