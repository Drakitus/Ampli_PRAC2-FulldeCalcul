package spreadsheet;

public class Cell {
    private Expression content;

    public Cell(Expression exp){
        content = exp;
    }

    public void set(Expression exp) {
        this.content = exp;
    }

    public MaybeValue evaluate(){
        return content.evaluate();
    }
}
