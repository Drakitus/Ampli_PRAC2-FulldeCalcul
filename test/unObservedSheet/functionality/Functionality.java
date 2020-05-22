package unObservedSheet.functionality;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static spreadsheet.SpreadSheet.get;

public class Functionality {

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells(){
        assertFalse(get("a3").hasValue());
    }

}
