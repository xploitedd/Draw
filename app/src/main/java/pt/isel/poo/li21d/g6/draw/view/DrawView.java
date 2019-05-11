package pt.isel.poo.li21d.g6.draw.view;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

import pt.isel.poo.li21d.g6.draw.DrawController;
import pt.isel.poo.li21d.g6.draw.model.DrawModel;

public class DrawView extends View {

    private DrawController ctrl;
    private LinkedList<FigureView> views = new LinkedList<>();

    public DrawView(DrawController ctrl) {
        super(ctrl);
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
        //TODO
        return super.onTouchEvent(event);
    }

}
