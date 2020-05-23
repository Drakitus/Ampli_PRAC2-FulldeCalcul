package spreadsheet;

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
        //for(int column = 1; column<= this.size; column++){  //Si es vol fer amb array
            for(int row = 1; row <= this.size; row++){
                String name = column + String.valueOf(row);
                sheet.put(name, new Reference(new Cell(NoValue.INSTANCE)));
            }
        }
    }

    private int getIndex(String name){  //Si es vol fer amb array
        int column = (name.charAt(0)) % 97; //97 ascii value for 'a'
        int row = (name.charAt(1)) % 48;  //48 ascii value for 0
        return column * this.size + row;
    }

    protected void put(String name, Expression exp){
        Reference reference = sheet.get(name); //Comprovar casos d'error
        reference.setExpression(exp);
    }

    protected Reference get(String name){
        return sheet.get(name); //Comprovar casos d'error
    }

    protected Set<Cell> references(String name){
        Reference reference = sheet.get(name);
        Expression content = reference.getCell().getContent();
        return new HashSet<>(content.references()); //Comprovar casos d'error
    }

    protected void clear(){
        initEmpty();
    }


}
