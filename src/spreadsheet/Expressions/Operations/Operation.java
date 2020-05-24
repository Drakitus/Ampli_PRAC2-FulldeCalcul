package spreadsheet.Expressions.Operations;

import spreadsheet.Cell;
import spreadsheet.Expressions.Expression;
import spreadsheet.Expressions.Values.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Operation implements Expression {

    Expression e1, e2;

    public Operation(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    protected abstract int operate(int i1, int i2);

    @Override
    public MaybeValue evaluate(){
        MaybeValue operand1 = e1.evaluate();
        MaybeValue operand2 = e2.evaluate();
        if(operand1.hasValue() && operand2.hasValue()){
            return new SomeValue(operate(((SomeValue) operand1).getValue(), ((SomeValue) operand2).getValue()));
        }
        return NoValue.INSTANCE;
    }

    public Set<Cell> references(){
        Set<Cell> references = new HashSet<>();
        references.addAll(e1.references());
        references.addAll(e2.references());
        return references;
    }
}
