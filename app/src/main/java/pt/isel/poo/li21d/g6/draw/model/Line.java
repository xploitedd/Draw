package pt.isel.poo.li21d.g6.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Line extends Figure {

    public static char LETTER = 'l';
    private Point end;

    public Line(){
        end = new Point();
    }

    public Line(int x, int y){
        end = new Point(x,y);
    }

    @Override
    protected char getLetter() {
        return 0;
    }

    public void load(Scanner in){
        //TODO
        return;
    }

    public PrintWriter save(){
        //TODO
        return null;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public void setEnd(int x, int y) {

    }
}
