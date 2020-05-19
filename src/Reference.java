import java.util.Set;

public class Reference implements Expression{

    private Cell refered;

    public Reference(Cell cell){
        this.refered = cell;
    }

    @Override
    public MaybeValue evaluate() {
        return refered.getContent().evaluate();
    }

    @Override
    public Set<Cell> references() {
        return null;
    }

}
