package pt.isel.poo.g6li21d.draw.view;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

import pt.isel.poo.g6li21d.draw.DrawController;
import pt.isel.poo.g6li21d.draw.model.DrawModel;
import pt.isel.poo.g6li21d.draw.model.Figure;

@SuppressLint("ViewConstructor")
public class DrawView extends View {

    /**
     * Background color of the drawing board
     */
    private static final int BACKGROUND_COLOR = Color.rgb(173, 235, 173);

    /**
     * LinkedList where the views will be stored
     */
    private LinkedList<FigureView> views = new LinkedList<>();

    /**
     * Activity where this DrawView is
     */
    private DrawController ctrl;

    /**
     * Figure that is being currently drawn
     */
    private FigureView curr;

    /**
     * Creates a new drawing board in a DrawController activity
     * @param ctrl DrawController activity
     */
    public DrawView(DrawController ctrl) {
        super(ctrl);
        this.ctrl = ctrl;

        setBackgroundColor(BACKGROUND_COLOR);
    }

    /**
     * Reloads every FigureView
     * Used when the Figure LinkedList changes without
     * the user drawing anything
     * @param model Model where to create FigureView's from
     * {@see DrawController#onLoad()}
     */
    public void reloadModel(DrawModel model) {
        views.clear();
        for (Figure f : model)
            views.add(FigureView.newInstance(f));

        invalidate();
    }

    /**
     * {@inheritDoc}
     * @param canvas Canvas where the figures will be drawn
     */
    @Override
    protected void onDraw(Canvas canvas) {
        for (FigureView view : views)
            view.draw(canvas);
    }

    /**
     * {@inheritDoc}
     * @param event Event representing how the user touched the screen
     * @return true if the event was handled, false otherwise
     */
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
        } else if (action == MotionEvent.ACTION_MOVE || action == MotionEvent.ACTION_UP) {
            curr.elem.setEnd(x, y);
            invalidate();
            return true;
        }

        return super.onTouchEvent(event);
    }

}
