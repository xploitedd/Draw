package pt.isel.poo.g6li11d.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Point {

    private int x;
    private int y;

    Point() { }

    Point(int x, int y) { set(x, y); }

    void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void save(PrintWriter out) {

    }

    public void load(Scanner in) {

    }

}
