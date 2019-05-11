package pt.isel.poo.li21d.g6.draw.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import pt.isel.poo.li21d.g6.draw.model.Circle;
import pt.isel.poo.li21d.g6.draw.model.Figure;
import pt.isel.poo.li21d.g6.draw.model.Line;
import pt.isel.poo.li21d.g6.draw.model.Pixel;
import pt.isel.poo.li21d.g6.draw.model.Rect;

public class FigureView {

    protected Figure elem;

    protected Paint paint = new Paint();

    FigureView(Figure f) {
        this.elem = f;
    }

    void draw(Canvas c) {
        //TODO
    }

    FigureView newInstance(Figure f) {
        if (f instanceof Circle) return new CircleView();
        if (f instanceof Line) return new LineView();
        if (f instanceof Pixel) return new PixelView();
        if (f instanceof Rect) return new RectView();
        return null;
    }
}