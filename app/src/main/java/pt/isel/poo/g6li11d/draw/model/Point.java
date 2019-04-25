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

    public void save(PrintWriter out) { out.write("(" + x + ',' + y + ")"); }

    public void load(Scanner in) {
        String p = in.next();
        String[] start = p.substring(1, p.length() - 1).split(",");
        int x = Integer.parseInt(start[0]), y = Integer.parseInt(start[1]);
        set(x, y);
    }

}
