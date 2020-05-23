package spreadsheet;

import java.util.Set;

public class SpreadSheet {
    private static final int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);

    public static Expression plus(int value1, int value2) {
        return new Plus(new SomeValue(value1), new SomeValue(value2));
    }

    public static Expression plus(String ref1, String ref2) {
        return new Plus(SHEET.get(ref1), SHEET.get(ref2));
    }

    public static Expression plus(Expression expr1, Expression expr2){
        // Crea i retorna una expressió corresponent a la
        // suma de les dues subexpressions
        return new Plus(expr1, expr2);
    }

    public static Expression plus(Expression expr1, int value2) {
        // Crea i retorna una expressió corresponent a la
        // suma de expr1 i de l’expressió que representa
        // la constant value2
        return new Plus(expr1, new SomeValue(value2));
    }

    public static Expression plus(int value1, Expression expr2) {

        return plus(expr2, value1);
    }

    public static Expression plus(Expression expr1, String ref2) {
        // Crea i retorna una expressió corresponent a la
        // suma de expr1 i de l’expressió que representa
        // una referència a la cel·la amb nom ref2
        return new Plus(expr1, SHEET.get(ref2));
    }

    public static Expression plus(String ref1, Expression expr2) {

        return plus(expr2, ref1);
    }

    public static Expression plus(int value1, String ref2) {

        return new Plus(new SomeValue(value1), SHEET.get(ref2));
    }

    public static Expression plus(String ref1, int value2) {

        return plus(value2, ref1);
    }

    // El mateix per a totes les combinacions de mult

    public static Expression mult(int value1, int value2) {
        return new Mult(new SomeValue(value1), new SomeValue(value2));
    }

    public static Expression mult(String ref1, String ref2) {
        return new Mult(SHEET.get(ref1), SHEET.get(ref2));
    }

    public static Expression mult(Expression expr1, Expression expr2) {
        // Crea i retorna una expressió corresponent a la
        // suma de les dues subexpressions
        return new Mult(expr1, expr2);
    }

    public static Expression mult(Expression expr1, int value2) {
        // Crea i retorna una expressió corresponent a la
        // suma de expr1 i de l’expressió que representa
        // la constant value2
        return new Mult(expr1, new SomeValue(value2));
    }

    public static Expression mult(int value1, Expression expr2) { //NOT TESTED
        return mult(expr2, value1);
    }

    public static Expression mult(Expression expr1, String ref2) {
        // Crea i retorna una expressió corresponent a la
        // suma de expr1 i de l’expressió que representa
        // una referència a la cel·la amb nom ref2
        return new Mult(expr1, SHEET.get(ref2));
    }

    public static Expression mult(String ref1, Expression expr2) { //NOT TESTED
        return mult(expr2, ref1);
    }

    public static Expression mult(int value1, String ref2) {
        return new Mult(new SomeValue(value1), SHEET.get(ref2));
    }

    public static Expression mult(String ref1, int value2) { //NOT TESTED
        return mult(value2, ref1);
    }

    public static MaybeValue get(String name) { //TO TEST
        // Retorna el valor que potser hi ha a la cel·la
        // amb nom name.
        // Si hi ha un valor, es retorna una instància de
        // spreadsheet.SomeValue; si no hi ha, spreadsheet.NoValue.

        return SHEET.get(name).evaluate();

    }

    public static void put(String name, int value) {
        // Assigna a la cel·la amb nom name l’expressió
        // el valor value (Òbviament caldrà construir la
        // representació d’aquest int com spreadsheet.Expression).
        // Això pot provocar avaluacions d’aquesta o
        // d’altres cel·les
        SomeValue content = new SomeValue(value);
        SHEET.put(name, content);
    }

    public static void put(String name, String refName) {
        // Assigna a la cel·la amb nom name la referència
        // a la cel·la amb nom refName (Òbviament caldrà
        // construir la representació d’aquesta
        // referència com spreadsheet.Expression).
        // Això pot provocar avaluacions d’aquesta o
        // d’altres cel·les
        Reference content = SHEET.get(refName);
        SHEET.put(name, content);
    }

    public static void put(String name, Expression expr) {
        // Assigna a la cel·la amb nom name l’expressió
        // expr.
        // Això provocarà l’avaluació de la cel·la (la
        // qual cosa pot propagar la avaluació a d’altres
        // cel·les)
        SHEET.put(name, expr);
    }

    public static void clear() {
        // Esborra totes les cel·les del full de càlcul.
        SHEET.clear();
    }

    public static Set<Cell> references(String name){
        return SHEET.references(name);
    }

    public static Cell getCell(String name){  //METHOD ONLY FOR TESTING
        return SHEET.get(name).getCell();
    }
}
