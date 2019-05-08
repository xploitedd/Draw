package pt.isel.poo.li21d.g6.draw.model;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DrawModel {

    private LinkedList<Figure> figures = new LinkedList<>();

    public void save(PrintWriter out){
        //TODO
    }

    public void load (Scanner in){
        //TODO
    }

    public void add (Figure f){
        figures.add(f);
    }

    public Iterator<Figure> iterator(){
        return figures.iterator();
    }

}
