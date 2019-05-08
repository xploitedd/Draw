package pt.isel.poo.g6li11d.draw.model;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.MatchResult;

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
    public void save(PrintWriter out) { out.write(" (" + x + ',' + y + ")"); }

    /**
     * Loads this point with information from a file
     * @param in Scanner where to read the coordinates
     */
    public void load(Scanner in) {
        // throws NoSuchElementException if the pattern is not found
        in.next("[(](-?[0-9]+)[,](-?[0-9]+)[)]");
        MatchResult mr = in.match();
        int x = Integer.parseInt(mr.group(1)), y = Integer.parseInt(mr.group(2));
        set(x, y);
    }

}
