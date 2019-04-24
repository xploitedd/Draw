package pt.isel.poo.g6li11d.draw.model;

public class Line extends Figure {

    public static final char LETTER = 'L';

    Point end = new Point();

    public Line() { }

    public Line(int x, int y) { super(x, y); }

    @Override
    protected char getLetter() {
        return LETTER;
    }

    public Point getEnd() { return end; }

    @Override
    public void setEnd(int x, int y) { end.set(x, y); }

}
