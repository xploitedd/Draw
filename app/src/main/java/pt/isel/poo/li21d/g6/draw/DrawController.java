package pt.isel.poo.li21d.g6.draw;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DrawController extends Activity {

    private int chosenFigure;
    private static final int LINE = 0, RECT = 1, PIXEL = 2 ,CIRCLE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        setContentView(root);
    }

    private void setChosenFigure(int chosen) {
        this.chosenFigure = chosen;
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
