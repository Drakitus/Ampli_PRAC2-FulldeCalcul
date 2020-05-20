import java.util.HashSet;
import java.util.Set;

public class SomeValue extends MaybeValue {

    private int value;

    public SomeValue(int value){
        super(true);
        this.value = value;
    }

    private int getValue(){
        return value;
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }
}
