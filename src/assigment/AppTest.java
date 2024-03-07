package assigment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    
    @Test 
    public void test42(){
        assertEquals(42, new App().fortyTwo());
    }
}
