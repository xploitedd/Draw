package pt.isel.poo.g6li11d.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.Line;
import pt.isel.poo.g6li11d.draw.model.Point;

public class LineView extends FigureView {

    LineView(Figure f) { super(f); }

    @Override
    void draw(Canvas c) {
        Point start = elem.getStart();
        Point end = ((Line) elem).getEnd();

        c.drawLine(start.getX(), start.getY(), end.getX(), end.getY(), paint);
    }

}
