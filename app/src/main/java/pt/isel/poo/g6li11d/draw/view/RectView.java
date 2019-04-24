package pt.isel.poo.g6li11d.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.Point;
import pt.isel.poo.g6li11d.draw.model.Rect;

public class RectView extends FigureView {

    RectView(Figure f) { super(f); }

    @Override
    void draw(Canvas c) {
        Point start = elem.getStart();
        Point end = ((Rect) elem).getEnd();

        c.drawRect(start.getX(), start.getY(), end.getX(), end.getY(), paint);
    }

}
