package pt.isel.poo.g6li11d.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.FreeForm;
import pt.isel.poo.g6li11d.draw.model.Point;

public class FreeFormView extends FigureView {

    /**
     * Creates a new FigureView based on a Figure
     *
     * @param f Assigned Figure
     */
    FreeFormView(Figure f) { super(f); }

    @Override
    void draw(Canvas c) {
        FreeForm f = (FreeForm) elem;
        Point last = null;
        for (Point p : f) {
            if (last != null)
                c.drawLine(last.getX(), last.getY(), p.getX(), p.getY(), paint);

            last = p;
        }
    }

}
