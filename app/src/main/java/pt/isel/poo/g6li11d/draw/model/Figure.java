package pt.isel.poo.g6li11d.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Figure {

    Point start;

    protected Figure() { start = new Point(); }

    protected Figure(int x, int y) { start = new Point(x, y); }

    public void save(PrintWriter out) {

    }

    public void load(Scanner in) {

    }

    public Point getStart() { return start; }

    protected abstract char getLetter();

    public abstract void setEnd(int x, int y);

    public static Figure newInstance(char letter) {
        switch (letter) {
            case Pixel.LETTER: return new Pixel();
            case Rect.LETTER: return new Rect();
            case Circle.LETTER: return new Circle();
            case Line.LETTER: return new Line();
            default: return null;
        }
    }

}
