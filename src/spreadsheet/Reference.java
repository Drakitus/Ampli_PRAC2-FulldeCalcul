package spreadsheet;

import java.util.HashSet;
import java.util.Set;

public class Reference implements Expression{

    private final Cell referred;

    public Reference(Cell cell){
        this.referred = cell;
    }

    @Override
    public MaybeValue evaluate() {
        return referred.evaluate();
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> referenced = new HashSet<>();
        referenced.add(referred);
        return referenced;
    }

    public void set(Expression expr){
        referred.set(expr);
    }

}
