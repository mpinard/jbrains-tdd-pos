package mpinard.jbrains.tdd.pos;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Inventory {

    
    private final Map<String, String> productMap = new HashMap<>();
    
    public Optional<String> getPrice(final String barcode) {
        return Optional.ofNullable(productMap.get(barcode));
    }

    public void setPrice(final String barcode, final String priceText) {
        productMap.put(barcode, priceText);
    }
}
