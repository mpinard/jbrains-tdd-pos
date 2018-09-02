package mpinard.jbrains.tdd.pos;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PosTerminalTest {
    
    @Test
    public void When_NullDisplayPassedInConstructor_Then_IllegalArgumentExceptionIsThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new PosTerminal(null, new Inventory())
        ).withMessage("The display must not be null");
    }

    @Test
    public void When_NullInventoryPassedInConstructor_Then_IllegalArgumentExceptionIsThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new PosTerminal(new TestDisplay(), null)
        ).withMessage("The inventory must not be null");
    }
    
    @Test
    public void When_InventoryConstructedWithAllRequiredArguments_Then_NoExceptionIsThrown() {
        assertThatCode(() ->
            new PosTerminal(new TestDisplay(), new Inventory())
        ).doesNotThrowAnyException();
    }
    
}
