package pt.isel.poo.g6li21d.draw.model;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DrawModel implements Iterable<Figure> {

    /**
     * LinkedList used to store the figures
     */
    private LinkedList<Figure> figures = new LinkedList<>();

    /**
     * Saves every stored figure to a file
     * @param out PrintWriter that will save every figure to a file
     */
    public void save(PrintWriter out) {
        out.println(figures.size());
        for (Figure f : figures) {
            f.save(out);
            out.println();
        }
    }

    /**
     * Loads every figure specified in a file and creates it
     * @param in Scanner where the figures will be read
     */
    public void load(Scanner in) throws NoSuchElementException {
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

    /**
     * Adds a new figure
     * @param f figure to be added
     */
    public void add(Figure f) { figures.add(f); }

    /**
     * Clears every figure
     */
    public void clear() { figures.clear(); }

    /**
     * {@inheritDoc}
     * @return a new iterator for the stored figures
     */
    @Override
    public Iterator<Figure> iterator() { return figures.iterator(); }

}
