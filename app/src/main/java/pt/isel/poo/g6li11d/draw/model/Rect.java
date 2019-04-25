package pt.isel.poo.g6li11d.draw.model;

public class Rect extends Line {

    /**
     * Letter that represents this figure
     */
    public static final char LETTER = 'R';

    /**
     * Creates a new rectangle without a starting point
     */
    public Rect() { super(); }

    /**
     * Creates a new rectangle with a starting point
     * @param x start x
     * @param y start y
     */
    public Rect(int x, int y) { super(x, y); }

    /**
     * {@inheritDoc}
     * @return figure letter
     */
    @Override
    protected char getLetter() { return LETTER; }

}
