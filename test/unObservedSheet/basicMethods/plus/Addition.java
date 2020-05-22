package unObservedSheet.basicMethods.plus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spreadsheet.Plus;
import spreadsheet.SomeValue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static spreadsheet.SpreadSheet.*;

public class Addition {

    @Test
    public void plusTwoInts(){
        put("a1", plus(20, 40));
        assertEquals(new SomeValue(60), get("a1"));
    }

    @Test
    public void plusTwoReferences(){
        put("a1", 42);
        put("a2", 20);
        put("a3", plus("a1", "a2"));
        assertEquals(new SomeValue(62), get("a3"));
    }

    @Test
    public void plusTwoExpressions(){
        put("a1", plus(new Plus(new SomeValue(20), new SomeValue(30)), new Plus(new SomeValue(4), new SomeValue(2))));
        assertEquals(new SomeValue(56), get("a1"));
    }

    @Test
    public void plusExpressionAndInt(){
        put("a1", plus(new Plus(new SomeValue(20), new SomeValue(30)), 2));
        assertEquals(new SomeValue(52), get("a1"));
    }

    @Test
    public void plusExpressionAndReference(){
        put("a1", 4);
        put("a2", plus(new Plus(new SomeValue(20), new SomeValue(30)), "a1"));
        assertEquals(new SomeValue(54), get("a2"));
    }

    @Test
    public void plusIntAndReference(){
        put("a1", 4);
        put("a2", plus(30, "a1"));
        assertEquals(new SomeValue(34), get("a2"));
    }

    @AfterEach
    public void clearSheet(){
        clear();
    }


}
