import java.util.Set;

public class SomeValue extends MaybeValue{
    private final Integer someValue;

    public SomeValue(int value){
        someValue = value;
    }

    @Override
    public boolean hasValue() {
        return someValue != 0;
    }

    @Override
    public MaybeValue evaluate(){
        return this;
    }

    @Override
    public Set<Cell> references(){

    }
}
