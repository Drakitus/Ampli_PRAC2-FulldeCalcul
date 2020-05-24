package spreadsheet.Expressions;

import spreadsheet.Cell;
import spreadsheet.Expressions.Values.MaybeValue;

import java.util.Set;

public interface Expression {
    MaybeValue evaluate();
    Set<Cell> references();
}
