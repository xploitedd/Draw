package pt.isel.poo.g6li11d.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Circle extends Figure {

    public static final char LETTER = 'C';

    private int radius;

    public Circle() { }

    public Circle(int x, int y) { super(x, y); }

    @Override
    public void save(PrintWriter out) {
        super.save(out);
        out.write("|" + radius + "|");
    }

    @Override
    public void load(Scanner in) {
        super.load(in);
        String radiusString = in.next();
        radius = Integer.parseInt(radiusString.substring(1, radiusString.length() - 1));
    }

    @Override
    protected char getLetter() {
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {
        int startX = start.getX();
        int startY = start.getY();

        // Teorema de Pitagoras para calcular o raio
        radius = (int) Math.sqrt((startX - x) * (startX - x) + (startY - y) * (startY - y));
    }

    public int getRadius() { return radius; }

}
