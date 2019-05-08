package pt.isel.poo.li21d.g6.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Figure {
    protected Point start = null;
    protected Point end;

    Figure(int x, int y) {
        start = new Point(x, y);
    }

    Figure() {
        start = new Point();
    }

    protected abstract char getLetter();

    public Figure newInstance(char type) {
        switch (type) {
            case 'c':
                return new Circle();

            case 'l':
                return new Line();

            case 'p':
                return new Pixel();

            case 'r':
                return new Rect();

            default:
                return null;
        }
    }

    public PrintWriter save(){
        //TODO
        return null;
    }

    public Point getStart(){
        return start;
    }

    public void load(Scanner in){
        //TODO
        return;
    }

    public abstract void setEnd(int x, int y);
}
