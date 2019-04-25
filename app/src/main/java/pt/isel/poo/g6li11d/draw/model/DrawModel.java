package pt.isel.poo.g6li11d.draw.model;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DrawModel implements Iterable<Figure> {

    private LinkedList<Figure> figures = new LinkedList<>();

    public void save(PrintWriter out) {
        out.println(figures.size());
        for (Figure f : figures) {
            f.save(out);
            out.println();
        }
    }

    public void load(Scanner in) {
        figures.clear(); // clear all previous figures first

        int count = in.nextInt();
        in.nextLine(); // skip the first line (where the count is)
        for (int i = 0; i < count; ++i) {
            char fId = in.next().charAt(0);
            Figure figure = Figure.newInstance(fId);
            if (figure == null)
                throw new NoSuchElementException("Invalid Figure");

            figures.add(figure);
            figure.load(in);
            in.nextLine(); // go to the next line
        }
    }

    public void add(Figure f) {
        figures.add(f);
    }

    public void clear() { figures.clear(); }

    @Override
    public Iterator<Figure> iterator() { return figures.iterator(); }

}
