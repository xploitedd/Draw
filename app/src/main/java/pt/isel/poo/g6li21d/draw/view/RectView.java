package pt.isel.poo.g6li21d.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.g6li21d.draw.model.Figure;
import pt.isel.poo.g6li21d.draw.model.Point;
import pt.isel.poo.g6li21d.draw.model.Rect;

public class RectView extends FigureView {

    /**
     * Creates a new rectangle view
     * @param f figure that represents this RectView (must be a Rect)
     * {@link Rect}
     */
    RectView(Figure f) { super(f); }

    /**
     * Draws this rectangle onto the DrawView
     * @param c Canvas where the figure will be drawn
     */
    @Override
    void draw(Canvas c) {
        Point start = elem.getStart();
        Point end = ((Rect) elem).getEnd();

        c.drawRect(start.getX(), start.getY(), end.getX(), end.getY(), paint);
    }

}
