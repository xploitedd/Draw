package pt.isel.poo.g6li11d.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.Point;

public class PixelView extends FigureView {

    PixelView(Figure f) { super(f); }

    @Override
    void draw(Canvas c) {
        Point start = elem.getStart();
        c.drawPoint(start.getX(), start.getY(), paint);
    }

}
