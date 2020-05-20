public class Cell {
    private Expression content;
    private MaybeValue value;

    public Cell(Expression exp){
        this.content = exp;
    }

    public void set(Expression exp) {
        this.content = exp;
    }

    public Expression getContent(){
        return this.content;
    }

    public MaybeValue getValue(){ return this.value; }


    public MaybeValue evaluate(){
        MaybeValue e_value = content.evaluate();
        this.value = e_value;
        return value;
    }
}
