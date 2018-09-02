package mpinard.jbrains.tdd.pos;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryTest {

    private static final String BARCODE_PRODUCT1 = "23456";
    private static final String PRICE_TEXT_PRODUCT1 = "$11.50";

    private static final String BARCODE_PRODUCT2 = "12345";
    private static final String PRICE_TEXT_PRODUCT2 = "$7.99";
    
    private static final String UNKNOWN_BARCODE = "99999";
    
    private Inventory inventory;
    
    @Before
    public void setup() {
        inventory = new Inventory();
    }
    
    @Test
    public void Given_InventoryContainingProduct_When_GetPrice_Then_PriceReturned() {
        inventory.setPrice(BARCODE_PRODUCT1, PRICE_TEXT_PRODUCT1);
        assertThat(inventory.getPrice(BARCODE_PRODUCT1)).isEqualTo(Optional.of(PRICE_TEXT_PRODUCT1));
        
    }

    @Test
    public void Given_InventoryWithoutProduct_When_GetPrice_Then_ProductNotFound() {
        assertThat(inventory.getPrice(UNKNOWN_BARCODE).isPresent()).isFalse();
    }
    
    @Test
    public void Given_InventoryWithoutProduct_When_SetPrice_Then_GetPriceReturnsPrice() {
        assertThat(inventory.getPrice(BARCODE_PRODUCT2).isPresent()).isFalse();
        
        inventory.setPrice(BARCODE_PRODUCT2, PRICE_TEXT_PRODUCT2);
        
        assertThat(inventory.getPrice(BARCODE_PRODUCT2)).isEqualTo(Optional.of(PRICE_TEXT_PRODUCT2));
    }
}
