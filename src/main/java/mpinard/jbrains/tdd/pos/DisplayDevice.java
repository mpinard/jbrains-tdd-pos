package mpinard.jbrains.tdd.pos;

public class DisplayDevice implements Display {
    
    @Override
    public void setText(final String text) {
        System.out.println(String.format("Display Text is now [%s]", text));
    }
}
