package pt.isel.poo.g6li11d.draw.model;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class FreeForm extends Figure implements Iterable<Point> {

    public static final char LETTER = 'F';

    private LinkedList<Point> points = new LinkedList<>();

    public FreeForm() { super(); }

    public FreeForm(int x, int y) { super(x, y); }

    @Override
    public void save(PrintWriter out) {
        super.save(out);
        for (Point p : points)
            p.save(out);

        out.write(" E");
    }

    @Override
    public void load(Scanner in) {
        super.load(in);
        while (!in.hasNext("E")) {
            Point p = new Point();
            p.load(in);
            points.add(p);
        }

    }

    @Override
    protected char getLetter() { return LETTER; }

    @Override
    public void setEnd(int x, int y) {
        Point p = new Point(x, y);
        points.add(p);
    }

    @Override
    public Iterator<Point> iterator() { return points.iterator(); }

}
