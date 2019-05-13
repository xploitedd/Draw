package pt.isel.poo.g6li21d.draw.model;

public class Pixel extends Figure {

    /**
     * Letter that represents this figure
     */
    public static final char LETTER = 'P';

    /**
     * Creates a new pixel
     */
    public Pixel() { super(); }

    /**
     * Creates a new pixel located in x, y
     * @param x pixel x
     * @param y pixel y
     */
    public Pixel(int x, int y) { super(x, y); }

    /**
     * {@inheritDoc}
     * @return figure letter
     */
    @Override
    protected char getLetter() { return LETTER; }

    /**
     * {@inheritDoc}
     * In this specific case a pixel only consists of one point
     * so there's no ending point to be set
     * @param x end x
     * @param y end y
     */
    @Override
    public void setEnd(int x, int y) { }

}
