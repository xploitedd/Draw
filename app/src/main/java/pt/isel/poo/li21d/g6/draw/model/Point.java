package pt.isel.poo.li21d.g6.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Point{

    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() { }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }

    public PrintWriter save(){
        //TODO
        return null;
    }

    public void load(Scanner in){
        //TODO
        return;
    }
}
