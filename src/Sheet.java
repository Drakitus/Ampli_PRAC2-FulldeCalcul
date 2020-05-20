import java.util.HashMap;

public class Sheet{
    private final HashMap<String, Cell> sheet;


    public Sheet(int size){
        this.sheet = new HashMap<>(size*size);
        initEmpty();
    }

    private void initEmpty(){
        int size = sheet.size();
        for(char column = 'a'; column < 'z'; column++){
            for(int row = 1; row <= size; row++){
                String name = column + String.valueOf(row);
                sheet.put(name, new Cell(NoValue.INSTANCE));
            }
        }
    }

    public void put(String name, Expression exp){
        Cell cell = sheet.get(name); //Comprovar casos d'error
        cell.set(exp);
    }

    public MaybeValue get(String name){
        return sheet.get(name).getContent().evaluate(); //Comprovar casos d'error
    }

    public void clear(){
        sheet.clear();
    }


}
