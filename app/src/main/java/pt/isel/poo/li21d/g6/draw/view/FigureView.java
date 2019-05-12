package pt.isel.poo.li21d.g6.draw.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.li21d.g6.draw.model.Circle;
import pt.isel.poo.li21d.g6.draw.model.Figure;
import pt.isel.poo.li21d.g6.draw.model.Line;
import pt.isel.poo.li21d.g6.draw.model.Pixel;
import pt.isel.poo.li21d.g6.draw.model.Rect;

public abstract class FigureView {

    protected Figure elem;

    protected Paint paint = new Paint();

    FigureView(Figure f) {
        this.elem = f;
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    abstract void draw(Canvas c);

    static FigureView newInstance(Figure f) {
        if (f instanceof Circle) return new CircleView(f);
        if (f instanceof Rect) return new RectView(f);
        if (f instanceof Pixel) return new PixelView(f);
        if (f instanceof Line) return new LineView(f);
        return null;
    }
}