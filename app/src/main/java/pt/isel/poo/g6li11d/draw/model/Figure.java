package pt.isel.poo.g6li11d.draw.model;

import android.graphics.Point;

import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Figure {

    protected Figure() { }

    protected Figure(int x, int y) {

    }

    public void save(PrintWriter out) {

    }

    public void load(Scanner in) {

    }

    public Point getStart() {
        return null; // TODO
    }

    protected abstract char getLetter();

    protected abstract void setEnd(int x, int y);

    public static Figure newInstance(char letter) {
        return null; // TODO
    }

}
