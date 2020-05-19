public class Cell {
    private Expression content;

    public Cell(Expression exp){
        this.content = exp;
    }

    public void set(Expression exp) {
        this.content = exp;
    }

    public Expression getContent(){
        return this.content;
    }


    /*public MaybeValue evaluate(){
        return content;
    }*/
}
