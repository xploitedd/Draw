package pt.isel.poo.g6li21d.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Circle extends Figure {

    /**
     * Letter that represents this figure
     */
    public static final char LETTER = 'C';

    /**
     * Radius of this circle
     */
    private int radius;

    /**
     * Creates a circle without a center point
     */
    public Circle() { }

    /**
     * Creates a circle with a center point
     * @param x center x
     * @param y center y
     */
    public Circle(int x, int y) { super(x, y); }

    /**
     * {@inheritDoc}
     * @param out PrintWriter that will save the data
     */
    @Override
    public void save(PrintWriter out) {
        super.save(out);
        out.write("|" + radius + "|");
    }

    /**
     * {@inheritDoc}
     * @param in Scanner that reads the file
     */
    @Override
    public void load(Scanner in) {
        super.load(in);
        String radiusString = in.next();
        radius = Integer.parseInt(radiusString.substring(1, radiusString.length() - 1));
    }

    /**
     * {@inheritDoc}
     * @return figure letter
     */
    @Override
    protected char getLetter() { return LETTER; }

    /**
     * {@inheritDoc}
     * In this specific case it uses the pythagorean theorem to calculate
     * the distance between the center point and the ending point
     * which gives us the radius of this circle
     * @param x end x
     * @param y end y
     */
    @Override
    public void setEnd(int x, int y) {
        int startX = start.getX();
        int startY = start.getY();

        // Uses pythagorean theorem to calculate the radius
        radius = (int) Math.sqrt((startX - x) * (startX - x) + (startY - y) * (startY - y));
    }

    /**
     * Gets the radius of this circle
     * @return circle radius
     */
    public int getRadius() { return radius; }

}
