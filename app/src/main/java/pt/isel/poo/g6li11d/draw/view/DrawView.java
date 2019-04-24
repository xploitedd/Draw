package pt.isel.poo.g6li11d.draw.view;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

import pt.isel.poo.g6li11d.draw.DrawController;
import pt.isel.poo.g6li11d.draw.model.DrawModel;
import pt.isel.poo.g6li11d.draw.model.Figure;

@SuppressLint("ViewConstructor")
public class DrawView extends View {

    private static final int BACKGROUND_COLOR = Color.rgb(173, 235, 173);

    private LinkedList<FigureView> views = new LinkedList<>();
    private DrawController ctrl;
    private FigureView curr;

    public DrawView(DrawController ctrl) {
        super(ctrl);
        this.ctrl = ctrl;

        setBackgroundColor(BACKGROUND_COLOR);
    }

    public void reloadModel(DrawModel model) {
        views.clear();
        for (Figure f : model)
            views.add(FigureView.newInstance(f));

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (FigureView view : views)
            view.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (action == MotionEvent.ACTION_DOWN) {
            Figure f = ctrl.createSelectedFigure(x, y);
            curr = FigureView.newInstance(f);
            views.add(curr);
            return true;
        } else if (action == MotionEvent.ACTION_MOVE) {
            curr.elem.setEnd(x, y);
            invalidate();
            return true;
        }

        return super.onTouchEvent(event);
    }

}
