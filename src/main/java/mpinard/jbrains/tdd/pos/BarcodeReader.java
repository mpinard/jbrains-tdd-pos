package mpinard.jbrains.tdd.pos;

import java.util.Scanner;

public class BarcodeReader {
    
    private final BarcodeEventListener listener;
    
    public BarcodeReader(final BarcodeEventListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("The listener must not be null");
        }
        
        this.listener = listener;
    }
    
    public void start() {
        boolean quit;
        final Scanner scanner = new Scanner(System.in);
        
        do {
            final String inputLine = scanner.nextLine();
            System.out.println(String.format("Read from barcode reader: [%s]", inputLine));
            
            quit = isExit(inputLine);
            
            if (quit) {
                System.out.println("Quit command received, exiting...");
            } else {
                listener.onBarcode(inputLine);
            }
        } while (!quit);
        
    }
    
    private boolean isExit(final String inputLine) {
        return inputLine.equalsIgnoreCase("q")
            || inputLine.equalsIgnoreCase("quit")
            || inputLine.equalsIgnoreCase("exit");
        
    }
    
}
