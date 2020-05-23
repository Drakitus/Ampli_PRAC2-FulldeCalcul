package unObservedSheet.functionality;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spreadsheet.Cell;
import spreadsheet.SomeValue;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static spreadsheet.SpreadSheet.*;

public class Functionality {

    @Test
    public void complexExpression(){
        put("a1", mult(3, 2)); // a1 = 6
        put("a3", plus(1, 1)); // a3 = 2
        put("a4", mult("a1", "a3")); // a4 = (a1+a3) * a1*a3 = 8 * 12 = 96
        assertEquals(new SomeValue(12), get("a4"));
    }

    @Test
    public void nestedReferences(){
        put("a1", "a2");
        put("a4", 4);
        put("a3", mult("a4", "b2" ));
        put("b5", "a3");
        Set<Cell> references = references("b5");
        Set<Cell> actualCells = new HashSet<>();
        actualCells.add(getCell("a3"));
        actualCells.add(getCell("a4"));
        actualCells.add(getCell("b2"));
        assertEquals(actualCells, references);
    }

    @Test
    public void nestedReferencesInOperations(){
        put("a1", "a2");
        put("a4", 4);
        put("a3", mult(plus("a1", "a4"), "b2" ));
        put("b5", "a3");
        Set<Cell> references = references("b5");
        Set<Cell> actualCells = new HashSet<>();
        actualCells.add(getCell("a1"));
        actualCells.add(getCell("a2"));
        actualCells.add(getCell("a3"));
        actualCells.add(getCell("a4"));
        actualCells.add(getCell("b2"));
        assertEquals(actualCells, references);
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells(){
        assertFalse(get("a3").hasValue());
    }

    @AfterEach
    public void tearDown(){
        clear();
    }

}
