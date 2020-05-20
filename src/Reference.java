import java.util.HashSet;
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
        Set<Cell> referenced = new HashSet<>();
        referenced.add(refered);
        return referenced;
    }

}
