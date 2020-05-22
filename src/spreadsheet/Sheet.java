package spreadsheet;

import java.util.HashMap;
import java.util.Map;

public class Sheet{
    private final Map<String, Reference> sheet = new HashMap<>();
    private final int size;

    public Sheet(int size){
        this.size = size;
        initEmpty();
    }

    private void initEmpty(){
        char finalColumn = (char)(this.size + 'a');
        for(char column = 'a'; column < finalColumn; column++){
            for(int row = 1; row <= this.size; row++){
                String name = column + String.valueOf(row);
                sheet.put(name, new Reference(new Cell(NoValue.INSTANCE)));
            }
        }
    }

    protected void put(String name, Expression exp){
        Reference reference = sheet.get(name); //Comprovar casos d'error
        reference.set(exp);
    }

    protected MaybeValue get(String name){
        return sheet.get(name).evaluate(); //Comprovar casos d'error
    }

    protected void clear(){
        initEmpty();
    }


}
