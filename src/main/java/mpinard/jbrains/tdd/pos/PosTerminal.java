package mpinard.jbrains.tdd.pos;

public class PosTerminal {

    private static final String BARCODE_PRODUCT1 = "23456";
    private static final String PRICE_TEXT_PRODUCT1 = "$11.50";

    private static final String BARCODE_PRODUCT2 = "12345";
    private static final String PRICE_TEXT_PRODUCT2 = "$7.99";
    
    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Product not found";
    
    private final Display display;
    
    public PosTerminal(final Display display) {
        if (display == null) {
            throw new IllegalArgumentException("The display must not be null.");
        }
        
        this.display = display;
    }
    
    public void onBarcode(final String barcode) {
        final String priceText;
        
        if (barcode.equals(BARCODE_PRODUCT1)) {
            priceText = PRICE_TEXT_PRODUCT1; 
        } else if (barcode.equals(BARCODE_PRODUCT2)) {
            priceText = PRICE_TEXT_PRODUCT2;
        } else {
            priceText = PRODUCT_NOT_FOUND_MESSAGE;
        }
        
        display.setText(priceText);
    }
    
}
