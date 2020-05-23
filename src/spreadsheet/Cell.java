package spreadsheet;

import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {
    private Expression content;

    public Cell(Expression exp){
        content = exp;
    }

    public void set(Expression exp) {
        this.content = exp;
        addObserversCell();
        setChanged();
        notifyObservers();
    }

    public Expression getContent(){
        return this.content;
    }
    public MaybeValue evaluate(){
        return content.evaluate();
    }

    private void addObserversCell() {
        for (Cell reference : content.references()) {
            if (!reference.equals(this)) { //With this implementation this should never be equal to reference, but it's good practice
                reference.addObserver(this);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        content.evaluate();
    }
}
