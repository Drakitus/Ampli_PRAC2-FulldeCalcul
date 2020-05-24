package spreadsheet.Expressions.Operations;

import spreadsheet.Expressions.Expression;

public class Plus extends Operation {

    public Plus(Expression e1, Expression e2) {
        super(e1, e2);
    }

    protected int operate(int i1, int i2){
        return i1 + i2;
    }

}
