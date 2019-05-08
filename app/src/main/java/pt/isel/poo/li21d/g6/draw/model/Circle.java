package pt.isel.poo.li21d.g6.draw.model;

public class Circle extends Figure {

    private static char LETTER = 'c';
    private int radius;

    public Circle(){
        super();
        end = new Point();
    }

    public Circle(int x , int y){
        super(x,y);
        end = new Point();
    }

    @Override
    protected char getLetter() {
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {
        this.end.set(x,y);
    }

    public int getRadius(){
        return radius;
    }
}
