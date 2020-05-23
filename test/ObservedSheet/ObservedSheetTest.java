package ObservedSheet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spreadsheet.SomeValue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static spreadsheet.SpreadSheet.*;

public class ObservedSheetTest {

    @Test
    public void recalculation_works(){
        put("a3", mult("a1", "a2"));
        put("a1", 42);
        put("a2", 20);
        assertEquals(new SomeValue(840), get("a3"));
    }
}
