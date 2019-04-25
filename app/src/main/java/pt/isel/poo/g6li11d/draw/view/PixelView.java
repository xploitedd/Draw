package pt.isel.poo.g6li11d.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.g6li11d.draw.model.Circle;
import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.Point;

public class PixelView extends FigureView {

    /**
     * Creates a new pixel view
     * @param f figure that represents this PixelView (must be a Pixel)
     * {@link Circle}
     */
    PixelView(Figure f) { super(f); }

    /**
     * Draws this pixel onto the DrawView
     * @param c Canvas where the figure will be drawn
     */
    @Override
    void draw(Canvas c) {
        Point start = elem.getStart();
        c.drawPoint(start.getX(), start.getY(), paint);
    }

}
