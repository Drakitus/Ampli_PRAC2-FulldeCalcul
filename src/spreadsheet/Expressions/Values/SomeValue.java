package spreadsheet.Expressions.Values;

public class SomeValue extends MaybeValue {

    private final int value;

    public SomeValue(int value){
        super(true);
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }

    // Method for testing
    @Override
    public boolean equals(Object o){
        if(o instanceof SomeValue){
            return this.value == ((SomeValue) o).getValue();
        }
        return false;
    }
}
