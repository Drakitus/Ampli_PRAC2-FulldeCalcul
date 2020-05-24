package ObservedSheet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spreadsheet.Expressions.Values.SomeValue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static spreadsheet.SpreadSheet.*;

public class ObservedSheetTest {

    @Test
    public void recalculation_works(){
        put("a3", mult("a4", "b2" ));
        put("b2", 2);
        put("a4", 4);
        put("b5", "a3");
        put("a4", 10);
        assertEquals(new SomeValue(20), get("b5"));
    }

    @AfterEach
    public void reset(){
        clear();
    }
}
