package pt.isel.poo.g6li11d.draw.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import pt.isel.poo.g6li11d.draw.model.Figure;

public abstract class FigureView {

    protected Paint paint = new Paint();
    private Figure elem;

    FigureView(Figure f) { elem = f; }

    void draw(Canvas c) {

    }

    static FigureView newInstance(Figure f) {
        return null; // TODO
    }

}
