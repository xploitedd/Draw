package pt.isel.poo.li21d.g6.draw.model;

public class Pixel extends Figure {

    private static char LETTER = 'p';

    Pixel(int x, int y){
        super(x,y);
        this.end.set(x,y);
    }

    Pixel(){
        super();
        end = start;
    }

    @Override
    protected char getLetter() {
        return 0;
    }

    @Override
    public void setEnd(int x, int y) {

    }
}
