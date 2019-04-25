package pt.isel.poo.g6li11d.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Point {

    /**
     * Point x coordinate
     */
    private int x;

    /**
     * Point y coordinate
     */
    private int y;

    /**
     * Creates a new point with x = y = 0
     */
    Point() { super(); }

    /**
     * Creates a new point based on the x and y that was
     * passed as a parameter
     * @param x point x location
     * @param y point y location
     */
    Point(int x, int y) { set(x, y); }

    /**
     * Sets this point location
     * @param x point x location
     * @param y point y location
     */
    void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieves this point x coordinate
     * @return x coordinate
     */
    public int getX() { return x; }

    /**
     * Retrieves this point y coordinate
     * @return y coordinate
     */
    public int getY() { return y; }

    /**
     * Saves this point to a file
     * @param out PrintWriter where to write point information
     */
    public void save(PrintWriter out) { out.write("(" + x + ',' + y + ")"); }

    /**
     * Loads this point with information from a file
     * @param in Scanner where to read the coordinates
     */
    public void load(Scanner in) {
        String p = in.next();
        String[] start = p.substring(1, p.length() - 1).split(",");
        int x = Integer.parseInt(start[0]), y = Integer.parseInt(start[1]);
        set(x, y);
    }

}
