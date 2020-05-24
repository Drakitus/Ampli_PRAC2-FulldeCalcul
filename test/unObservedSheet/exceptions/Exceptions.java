package unObservedSheet.exceptions;

import org.junit.jupiter.api.Test;
import spreadsheet.Exceptions.NoSuchCellError;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static spreadsheet.SpreadSheet.*;

public class Exceptions {

    @Test
    public void GetNonexistentCell(){
        assertThrows(NoSuchCellError.class, () -> get("a6"));
    }

    @Test
    public void UpdateNonexistentCell(){
        assertThrows(NoSuchCellError.class, () -> put("a6", 3));
    }

    @Test
    public void OperateNonexistentCell(){
        assertThrows(NoSuchCellError.class, () -> mult("a6", "a1"));
    }

    @Test
    public void ReferencesOfNonexistentCell() { assertThrows(NoSuchCellError.class, () -> references("a6")); }
}

