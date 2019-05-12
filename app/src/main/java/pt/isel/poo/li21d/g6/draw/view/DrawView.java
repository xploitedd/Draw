package pt.isel.poo.li21d.g6.draw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

import pt.isel.poo.li21d.g6.draw.DrawController;
import pt.isel.poo.li21d.g6.draw.model.DrawModel;
import pt.isel.poo.li21d.g6.draw.model.Figure;

public class DrawView extends View {

    private DrawController ctrl;
    private LinkedList<FigureView> views = new LinkedList<>();
    private FigureView curr;
    private static final int BACKGROUND_COLOR = Color.WHITE;

    public DrawView(DrawController ctrl, Context context) {
        super(context);
        this.ctrl = ctrl;
        setBackgroundColor(BACKGROUND_COLOR);
    }

    public void reloadModel(DrawModel model){
        //TODO
    }

    protected void onDraw(Canvas canvas){
        //TODO
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        if(action == MotionEvent.ACTION_BUTTON_PRESS){

            Figure createdFigure = ctrl.createSelectedFigure(x,y);
            curr = FigureView.newInstance(createdFigure);
            views.add(curr);
        }
        if(action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_MOVE){
            curr.elem.setEnd(x,y);
            invalidate();
        }
        return super.onTouchEvent(event);
    }

}
