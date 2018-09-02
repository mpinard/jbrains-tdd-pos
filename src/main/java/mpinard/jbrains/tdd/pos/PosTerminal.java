package mpinard.jbrains.tdd.pos;

public class PosTerminal implements BarcodeEventListener {

    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Product not found";
    
    private final Display display;
    private final Inventory inventory;
    
    public PosTerminal(final Display display, final Inventory inventory) {
        if (display == null) {
            throw new IllegalArgumentException("The display must not be null");
        }

        if (inventory == null) {
            throw new IllegalArgumentException("The inventory must not be null");
        }

        this.display = display;
        this.inventory = inventory;
    }
    
    @Override
    public void onBarcode(final String barcode) {
        display.setText(inventory.getPrice(barcode).orElse(PRODUCT_NOT_FOUND_MESSAGE));
    }
    
}
