package spreadsheet;

import spreadsheet.Exceptions.NoSuchCellError;
import spreadsheet.Expressions.Expression;
import spreadsheet.Expressions.Values.NoValue;
import spreadsheet.Expressions.Reference.Reference;

import java.util.*;

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

    private boolean cellOutOfLimits(String name){
        return !sheet.containsKey(name);
    }

    protected void put(String name, Expression exp){
        if(cellOutOfLimits(name)) throw new NoSuchCellError("The sheet does not contain the cell " + name + ".");
        Reference reference = sheet.get(name);
        reference.setExpression(exp);
    }

    protected Reference get(String name){
        if(cellOutOfLimits(name)) throw new NoSuchCellError("The sheet does not contain the cell " + name + ".");
        return sheet.get(name);
    }

    protected Set<Cell> references(String name){
        if(cellOutOfLimits(name)) throw new NoSuchCellError("The sheet does not contain the cell " + name + ".");
        Reference reference = sheet.get(name);
        Expression content = reference.getCell().getContent();
        return new HashSet<>(content.references());
    }

    protected void clear(){
        initEmpty();
    }


}
