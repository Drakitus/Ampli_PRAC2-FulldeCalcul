package spreadsheet.Exceptions;

public class NoSuchCellError extends Error{

    public NoSuchCellError(String msg){
        super(msg);
    }
}
