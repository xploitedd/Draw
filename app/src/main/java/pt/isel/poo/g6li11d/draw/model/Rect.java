package pt.isel.poo.g6li11d.draw.model;

public class Rect extends Line {

    public static final char LETTER = 'R';

    public Rect() { }

    public Rect(int x, int y) { super(x, y); }

    @Override
    protected char getLetter() {
        return LETTER;
    }

}
