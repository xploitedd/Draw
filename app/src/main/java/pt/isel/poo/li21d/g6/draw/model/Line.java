package pt.isel.poo.li21d.g6.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Line extends Figure {

    public static char LETTER = 'l';

    public Line(){
        super();
        end = new Point();
    }

    public Line(int x, int y){
        super(x,y);
        end = new Point();
    }

    @Override
    protected char getLetter() {
        return LETTER;
    }

    public void load(Scanner in){
        //TODO
    }

    public void save(PrintWriter out){
        //TODO
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public void setEnd(int x, int y) {
        this.end.set(x,y);
    }
}
