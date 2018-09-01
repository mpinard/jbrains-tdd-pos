package mpinard.jbrains.tdd.pos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PosTerminalTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void When_NullDisplayPassedInConstructor_Then_IllegalArgumentExceptionIsThrown() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The display must not be null");
        
        new PosTerminal(null);
    }
    
}
