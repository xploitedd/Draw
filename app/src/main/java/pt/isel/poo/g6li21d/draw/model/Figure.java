package pt.isel.poo.g6li21d.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Figure {

    /**
     * The point where this figure starts
     */
    Point start;

    /**
     * Creates a new figure without a starting point
     */
    protected Figure() { start = new Point(); }

    /**
     * Creates a new figure with a starting point
     * @param x start x
     * @param y start y
     */
    protected Figure(int x, int y) { start = new Point(x, y); }

    /**
     * Saves this figure to a file
     * @param out PrintWriter that will save the data
     */
    public void save(PrintWriter out) {
        out.write(getLetter());
        start.save(out);
    }

    /**
     * Loads a figure from a file
     * @param in Scanner that reads the file
     */
    public void load(Scanner in) { start.load(in); }

    /**
     * Gets the starting point
     * @return starting point
     */
    public Point getStart() { return start; }

    /**
     * Gets the letter
     * @return figure letter
     */
    protected abstract char getLetter();

    /**
     * Sets an ending point
     * @param x end x
     * @param y end y
     */
    public abstract void setEnd(int x, int y);

    /**
     * Creates a new figure instance based on the figure letter
     * @param letter figure letter
     * @return the new figure instance
     */
    public static Figure newInstance(char letter) {
        switch (letter) {
            case Pixel.LETTER: return new Pixel();
            case Rect.LETTER: return new Rect();
            case Circle.LETTER: return new Circle();
            case Line.LETTER: return new Line();
            case FreeForm.LETTER: return new FreeForm();
            default: return null;
        }
    }

}
