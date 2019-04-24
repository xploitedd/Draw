package pt.isel.poo.g6li11d.draw.model;

public class Pixel extends Figure {

    public static final char LETTER = 'P';

    public Pixel() { }

    public Pixel(int x, int y) { super(x, y); }

    @Override
    protected char getLetter() {
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {

    }

}
