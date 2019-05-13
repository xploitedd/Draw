package pt.isel.poo.g6li21d.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.g6li21d.draw.model.Circle;
import pt.isel.poo.g6li21d.draw.model.Figure;
import pt.isel.poo.g6li21d.draw.model.Point;

public class CircleView extends FigureView {

    /**
     * Creates a new circle view
     * @param f figure that represents this CircleView (must be a Circle)
     * {@link Circle}
     */
    CircleView(Figure f) { super(f); }

    /**
     * Draws this circle onto the DrawView
     * @param c Canvas where the figure will be drawn
     */
    @Override
    void draw(Canvas c) {
        Point start = elem.getStart();
        c.drawCircle(start.getX(), start.getY(), ((Circle) elem).getRadius(), paint);
    }

}
