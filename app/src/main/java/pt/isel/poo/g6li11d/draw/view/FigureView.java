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

    protected Paint paint = new Paint();

    Figure elem;

    FigureView(Figure f) {
        elem = f;
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    abstract void draw(Canvas c);

    static FigureView newInstance(Figure f) {
        if (f instanceof Pixel) return new PixelView(f);
        if (f instanceof Circle) return new CircleView(f);
        // Rect needs to come before line because Rect extends Line
        if (f instanceof Rect) return new RectView(f);
        if (f instanceof Line) return new LineView(f);

        return null;
    }

}
