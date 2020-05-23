package spreadsheet;

import java.util.HashSet;
import java.util.Set;

public abstract class Operation implements Expression{

    private final Set<Cell> references = new HashSet<>();
    Expression e1, e2;

    public Operation(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public abstract int operate(int i1, int i2);

    @Override
    public MaybeValue evaluate(){
        MaybeValue operand1 = e1.evaluate();
        MaybeValue operand2 = e2.evaluate();
        if(operand1.hasValue() && operand2.hasValue()){
            return new SomeValue(operate(((SomeValue) operand1).getValue(), ((SomeValue) operand2).getValue()));
        }
        return NoValue.INSTANCE;
    }

    public void addReferences(){
        references.addAll(e1.references());
        references.addAll(e2.references());
    }

    public Set<Cell> references(){
        addReferences();
        return references;
    }
}
