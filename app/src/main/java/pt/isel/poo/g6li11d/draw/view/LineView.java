package pt.isel.poo.g6li11d.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.Line;
import pt.isel.poo.g6li11d.draw.model.Point;

public class LineView extends FigureView {

    /**
     * Creates a new line view
     * @param f figure that represents this LineView (must be a Line)
     * {@link Line}
     */
    LineView(Figure f) { super(f); }

    /**
     * Draws this line onto the DrawView
     * @param c Canvas where the figure will be drawn
     */
    @Override
    void draw(Canvas c) {
        Point start = elem.getStart();
        Point end = ((Line) elem).getEnd();

        c.drawLine(start.getX(), start.getY(), end.getX(), end.getY(), paint);
    }

}
