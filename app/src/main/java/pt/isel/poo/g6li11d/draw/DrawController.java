package pt.isel.poo.g6li11d.draw;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import pt.isel.poo.g6li11d.draw.model.DrawModel;
import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.view.DrawView;

public class DrawController extends Activity {

    private static final String FILE = "draw.txt";

    private DrawModel model;
    private DrawView view;
    private RadioButton pixel;
    private RadioButton circle;
    private RadioButton line;
    private RadioButton rect;
    private Button save;
    private Button load;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new DrawModel();
        view = new DrawView(this);

        LinearLayout layout = new LinearLayout(this);
        LinearLayout buttonGroup = new LinearLayout(this);
        RadioGroup radioGroup = new RadioGroup(this);

        save = new Button(this);
        save.setText("Save");
        save.setOnClickListener(v -> onSave());
        load = new Button(this);
        load.setText("Load");
        load.setOnClickListener(v -> onLoad());
        reset = new Button(this);
        reset.setText("Reset");
        reset.setOnClickListener(v -> onReset());

        buttonGroup.addView(save);
        buttonGroup.addView(load);
        buttonGroup.addView(reset);

        pixel = new RadioButton(this);
        pixel.setText("Pixel");
        circle = new RadioButton(this);
        circle.setText("Circle");
        line = new RadioButton(this);
        line.setText("Line");
        rect = new RadioButton(this);
        rect.setText("Rectangle");

        radioGroup.addView(pixel);
        radioGroup.addView(circle);
        radioGroup.addView(line);
        radioGroup.addView(rect);

        // It is important to toggle it only after adding it to the radio group
        // or it will bug with the other radio buttons
        pixel.toggle();

        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(buttonGroup);
        layout.addView(radioGroup);
        layout.addView(view);

        setContentView(layout);
    }

    private void onReset() {
        Log.i("Draw", "Reset button pressed!");
    }

    private void onLoad() {
        Log.i("Draw", "Load button pressed!");
    }

    private void onSave() {
        Log.i("Draw", "Save button pressed!");
    }

    public Figure createSelectedFigure(int x, int y) {
        return null; // TODO
    }

}
