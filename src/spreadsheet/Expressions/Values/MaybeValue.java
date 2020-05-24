package spreadsheet.Expressions.Values;

import spreadsheet.Cell;
import spreadsheet.Expressions.Expression;

import java.util.HashSet;
import java.util.Set;

public abstract class MaybeValue implements Expression {

    private final boolean hasValue;

    public MaybeValue(boolean hasValue) {
        this.hasValue = hasValue;
    }

    public boolean hasValue(){
        return hasValue;
    }

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }
}
