package pt.isel.poo.g6li21d.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Line extends Figure {

    /**
     * Letter that represents this figure
     */
    public static final char LETTER = 'L';

    /**
     * The ending point of the line
     */
    Point end = new Point();

    /**
     * Creates a new line without a starting point
     */
    public Line() { super(); }

    /**
     * Creates a new line with a starting point
     * @param x start x
     * @param y start y
     */
    public Line(int x, int y) { super(x, y); }

    /**
     * {@inheritDoc}
     * @param out PrintWriter that will save the data
     */
    @Override
    public void save(PrintWriter out) {
        super.save(out);
        end.save(out);
    }

    /**
     * {@inheritDoc}
     * @param in Scanner that reads the file
     */
    @Override
    public void load(Scanner in) {
        super.load(in);
        end.load(in);
    }

    /**
     * {@inheritDoc}
     * @return figure letter
     */
    @Override
    protected char getLetter() { return LETTER; }

    /**
     * Gets the ending point of this line
     * @return Line ending point
     */
    public Point getEnd() { return end; }

    /**
     * {@inheritDoc}
     * @param x end x
     * @param y end y
     */
    @Override
    public void setEnd(int x, int y) { end.set(x, y); }

}
