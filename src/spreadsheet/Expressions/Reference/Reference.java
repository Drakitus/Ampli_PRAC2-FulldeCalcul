package spreadsheet.Expressions.Reference;

import spreadsheet.Cell;
import spreadsheet.Expressions.Expression;
import spreadsheet.Expressions.Values.MaybeValue;

import java.util.HashSet;
import java.util.Set;

public class Reference implements Expression {

    private final Cell referred;

    public Reference(Cell cell){
        this.referred = cell;
    }

    public Cell getCell(){
        return referred;
    }

    @Override
    public MaybeValue evaluate() {
        return referred.evaluate();
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> referenced = new HashSet<>();
        referenced.add(referred);
        referenced.addAll(referred.getContent().references());
        return referenced;
    }

    public void setExpression(Expression expr){
        referred.set(expr);
    }

}
