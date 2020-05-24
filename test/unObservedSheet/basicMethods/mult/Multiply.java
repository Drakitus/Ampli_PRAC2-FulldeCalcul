package unObservedSheet.basicMethods.mult;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spreadsheet.Expressions.Operations.Mult;
import spreadsheet.Expressions.Values.SomeValue;
import static spreadsheet.SpreadSheet.*;
import static org.junit.jupiter.api.Assertions.*;

public class Multiply{

    @Test
    public void multTwoInts(){
        put("a1", mult(20, 40));
        assertEquals(new SomeValue(800), get("a1"));
    }

    @Test
    public void multTwoReferences(){
        put("a1", 42);
        put("a2", 20);
        put("a3", mult("a1", "a2"));
        assertEquals(new SomeValue(840), get("a3"));
    }

    @Test
    public void multTwoExpressions(){
        put("a1", mult(new Mult(new SomeValue(20), new SomeValue(30)), new Mult(new SomeValue(4), new SomeValue(2))));
        assertEquals(new SomeValue(4800), get("a1"));
    }

    @Test
    public void multExpressionAndInt(){
        put("a1", mult(new Mult(new SomeValue(20), new SomeValue(30)), 2));
        assertEquals(new SomeValue(1200), get("a1"));
    }

    @Test
    public void multExpressionAndReference(){
        put("a1", 4);
        put("a2", mult(new Mult(new SomeValue(20), new SomeValue(30)), "a1"));
        assertEquals(new SomeValue(2400), get("a2"));
    }

    @Test
    public void multIntAndReference(){
        put("a1", 4);
        put("a2", mult(30, "a1"));
        assertEquals(new SomeValue(120), get("a2"));
    }

    @Test
    public void multWith0(){
        put("a1", 0);
        put("a2", mult(2, "a1"));
        assertEquals(new SomeValue(0), get("a2"));
    }

    @AfterEach
    public void clearSheet(){
        clear();
    }


}
