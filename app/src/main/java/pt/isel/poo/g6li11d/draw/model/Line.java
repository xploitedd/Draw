package pt.isel.poo.g6li11d.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Line extends Figure {

    public static final char LETTER = 'L';

    Point end = new Point();

    public Line() { }

    public Line(int x, int y) { super(x, y); }

    @Override
    public void save(PrintWriter out) {
        super.save(out);
        end.save(out);
    }

    @Override
    public void load(Scanner in) {
        super.load(in);
        end.load(in);
    }

    @Override
    protected char getLetter() {
        return LETTER;
    }

    public Point getEnd() { return end; }

    @Override
    public void setEnd(int x, int y) { end.set(x, y); }

}
