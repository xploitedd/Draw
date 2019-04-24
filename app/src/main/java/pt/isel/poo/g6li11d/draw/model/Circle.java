package pt.isel.poo.g6li11d.draw.model;

public class Circle extends Figure {

    public static final char LETTER = 'C';

    private int radius;

    public Circle() { }

    public Circle(int x, int y) { super(x, y); }

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
