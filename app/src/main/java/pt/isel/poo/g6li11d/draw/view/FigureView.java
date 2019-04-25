package pt.isel.poo.g6li11d.draw.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.g6li11d.draw.model.Circle;
import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.Line;
import pt.isel.poo.g6li11d.draw.model.Pixel;
import pt.isel.poo.g6li11d.draw.model.Rect;

public abstract class FigureView {

    /**
     * Paint used by every shape
     */
    protected Paint paint = new Paint();

    /**
     * Figure that is represented by this FigureView
     */
    Figure elem;

    /**
     * Creates a new FigureView based on a Figure
     * @param f Assigned Figure
     */
    FigureView(Figure f) {
        elem = f;
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    /**
     * Draws this figure
     * @param c Canvas where the figure will be drawn
     */
    abstract void draw(Canvas c);

    /**
     * Creates a new instance of FigureView based on the Figure that is passed
     * as a parameter
     * @param f Figure that will represent the new FigureView
     * @return a new FigureView instance
     */
    static FigureView newInstance(Figure f) {
        if (f instanceof Pixel) return new PixelView(f);
        if (f instanceof Circle) return new CircleView(f);
        // Rect needs to come before line because Rect extends Line
        if (f instanceof Rect) return new RectView(f);
        if (f instanceof Line) return new LineView(f);

        return null;
    }

}
