package pt.isel.poo.g6li11d.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.g6li11d.draw.model.Circle;
import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.Point;

public class CircleView extends FigureView {

    CircleView(Figure f) { super(f); }

    @Override
    void draw(Canvas c) {
        Point start = elem.getStart();
        c.drawCircle(start.getX(), start.getY(), ((Circle) elem).getRadius(), paint);
    }

}
