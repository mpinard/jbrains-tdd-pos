package mpinard.jbrains.tdd.pos;

public class PosTerminalApplication {

    public static void main(final String[] args) {
        final Inventory inventory = new Inventory();
        inventory.setPrice("123", "$12.99");
        inventory.setPrice("456", "$34.50");
        inventory.setPrice("789", "$3.50");
        inventory.setPrice("90210", "$99.99");
        inventory.setPrice("30024", "$12.50");
        
        final Display display = new DisplayDevice();
        
        final PosTerminal posTerminal = new PosTerminal(display, inventory);
        
        new BarcodeReader(posTerminal).start();
    } 
   
    
}
