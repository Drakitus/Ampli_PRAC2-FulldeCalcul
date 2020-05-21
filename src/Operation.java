import java.util.Set;

public class Operation implements Expression{

    public Expression e1, e2;

    public Operation(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public MaybeValue evaluate() {
        return null;
    }

    public Set<Cell> references(){
        return null;
    }
}
