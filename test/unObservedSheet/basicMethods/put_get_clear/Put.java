package unObservedSheet.basicMethods.put_get_clear;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spreadsheet.Mult;
import spreadsheet.SomeValue;
import spreadsheet.SpreadSheet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static spreadsheet.SpreadSheet.clear;
import static spreadsheet.SpreadSheet.get;

public class Put {

    @Test
    public void PutInt(){
        SpreadSheet.put("a1", 9);
        assertEquals(new SomeValue(9), get("a1"));
    }

    @Test
    public void PutReference(){
        SpreadSheet.put("a5", 10);
        SpreadSheet.put("a1", "a5");
        assertEquals(get("a5"), get("a1"));
    }

    @Test
    public void PutExpression(){
        SpreadSheet.put("a1", new Mult(new SomeValue(3), new SomeValue(4)));
        assertEquals(new SomeValue(12), get("a1"));
    }

    @AfterEach
    public void clearSheet(){
        clear();
    }

}
