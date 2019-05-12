package pt.isel.poo.li21d.g6.draw.model;

public class Rect extends Line {

    public static char LETTER = 'r';


    public Rect(){
        super();
        end = new Point();
    }

    public Rect(int x, int y){
        super(x,y);
        end = new Point();
    }

    @Override
    protected char getLetter() {
        return LETTER;
    }

}
