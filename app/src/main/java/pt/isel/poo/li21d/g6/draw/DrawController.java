package pt.isel.poo.li21d.g6.draw;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import pt.isel.poo.li21d.g6.draw.model.Circle;
import pt.isel.poo.li21d.g6.draw.model.DrawModel;
import pt.isel.poo.li21d.g6.draw.model.Figure;
import pt.isel.poo.li21d.g6.draw.model.Line;
import pt.isel.poo.li21d.g6.draw.model.Pixel;
import pt.isel.poo.li21d.g6.draw.model.Rect;
import pt.isel.poo.li21d.g6.draw.view.DrawView;

public class DrawController extends Activity {

    private char chosenFigure;
    private static final char LINE = 'l', RECT = 'r', PIXEL = 'p' ,CIRCLE = 'c';
    private DrawView View;
    private DrawModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View = new DrawView(this, this);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        LinearLayout buttons = new LinearLayout(this);
        buttons.setOrientation(LinearLayout.HORIZONTAL);
        RadioGroup radioButtons = new RadioGroup(this);
        radioButtons.setOrientation(RadioGroup.HORIZONTAL);
        new TextButton("Reset", buttons);
        new TextButton("Load", buttons);
        new TextButton("Save", buttons);
        new RadButton("Line", radioButtons, v -> setChosenFigure(LINE));
        new RadButton("Rect", radioButtons, v -> setChosenFigure(RECT));
        new RadButton("Pixel", radioButtons, v -> setChosenFigure(PIXEL));
        new RadButton("Circle", radioButtons, v -> setChosenFigure(CIRCLE));
        root.addView(buttons);
        root.addView(radioButtons);
        root.addView(View);
        setContentView(root);
    }

    private void setChosenFigure(char chosen) {
        this.chosenFigure = chosen;
    }

    public Figure createSelectedFigure(int x, int y){
        Figure newfig;
        switch(chosenFigure){
            case 'l': newfig = new Line(x,y);break;
            case 'r': newfig = new Rect(x,y);break;
            case 'p': newfig = new Pixel(x,y);break;
            case 'c': newfig = new Circle(x,y);break;
            default: newfig = null;
        }
        if(newfig != null) model.add(newfig);
        return newfig;
    }

    @SuppressLint("AppCompatCustomView")
    private class TextButton extends Button {
        public TextButton(String str, LinearLayout layout) {
            super(getBaseContext());
            setText(str);
            layout.addView(this);
        }
    }

    @SuppressLint("AppCompatCustomView")
    private class RadButton extends RadioButton {
        public RadButton(String str, LinearLayout layout, OnClickListener click) {
            super(getBaseContext());
            setText(str);
            setOnClickListener(click);
            layout.addView(this);
        }
    }
}
