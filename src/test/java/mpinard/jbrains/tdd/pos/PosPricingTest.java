package mpinard.jbrains.tdd.pos;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PosPricingTest {
    private static final String BARCODE_PRODUCT1 = "23456";
    private static final String PRICE_TEXT_PRODUCT1 = "$11.50";
    
    private static final String BARCODE_PRODUCT2 = "12345";
    private static final String PRICE_TEXT_PRODUCT2 = "$7.99";

    private static final String UNKNOWN_BARCODE = "99999";
    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Product not found";
        
    private TestDisplay display;
    private PosTerminal pos;
    private Inventory inventory;
    
    @Before
    public void setup() {
        display = new TestDisplay();
        inventory = new Inventory();
        pos = new PosTerminal(display, inventory);
        
    }
    @Test
    public void Given_FoundItem_When_OnBarCode_Then_PriceDisplayed() {
        inventory.setPrice(BARCODE_PRODUCT1, PRICE_TEXT_PRODUCT1);
        pos.onBarcode(BARCODE_PRODUCT1);
        
        assertThat(display.getText()).isEqualTo(PRICE_TEXT_PRODUCT1);
    }

    @Test
    public void Given_DifferentFoundItem_When_OnBarCode_Then_PriceDisplayed() {
        inventory.setPrice(BARCODE_PRODUCT2, PRICE_TEXT_PRODUCT2);
        pos.onBarcode(BARCODE_PRODUCT2);

        assertThat(display.getText()).isEqualTo(PRICE_TEXT_PRODUCT2);
    }

    @Test
    public void Given_UnknownBarcode_When_OnBarCode_Then_ProductUnknownMessageIsDisplayed() {
        pos.onBarcode(UNKNOWN_BARCODE);
        
        assertThat(display.getText()).isEqualTo(PRODUCT_NOT_FOUND_MESSAGE);
    }
}
