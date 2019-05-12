package pt.isel.poo.li21d.g6.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.li21d.g6.draw.model.Figure;
import pt.isel.poo.li21d.g6.draw.model.Line;
import pt.isel.poo.li21d.g6.draw.model.Point;

public class LineView extends FigureView {


    LineView(Figure f) {
        super(f);

    }

    @Override
    void draw(Canvas c) {
        Line curr = (Line) elem;
        Point start = curr.getStart();
        Point end = curr.getEnd();
        c.drawLine((float) start.getX(), (float) start.getY(), (float) end.getX(), (float) end.getY(),paint);
    }
}
