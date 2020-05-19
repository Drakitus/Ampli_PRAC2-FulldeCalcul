import java.util.Set;

public class NoValue extends MaybeValue{

    @Override
    public boolean hasValue(){
        return false;
    }

    @Override
    public MaybeValue evaluate(){
        throw new NullPointerException("The expression is null.");
    }

    @Override
    public Set<Cell> references(){
        throw new NullPointerException("The expression is null.");
    }

}
