public abstract class MaybeValue implements Expression{

    public abstract boolean hasValue();

    @Override
    public abstract MaybeValue evaluate();

}
