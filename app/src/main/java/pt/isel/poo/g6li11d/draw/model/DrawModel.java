package pt.isel.poo.g6li11d.draw.model;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DrawModel implements Iterable<Figure> {

    private LinkedList<Figure> figures = new LinkedList<>();

    public void save(PrintWriter out) {

    }

    public void load(Scanner in) {

    }

    public void add(Figure f) {
        figures.add(f);
    }

    @Override
    public Iterator<Figure> iterator() {
        return figures.iterator();
    }

}
