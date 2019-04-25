package pt.isel.poo.g6li11d.draw;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import pt.isel.poo.g6li11d.draw.model.Circle;
import pt.isel.poo.g6li11d.draw.model.DrawModel;
import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.Line;
import pt.isel.poo.g6li11d.draw.model.Pixel;
import pt.isel.poo.g6li11d.draw.model.Rect;
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
        rect.setText("Rect");

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
        model.clear();
        view.reloadModel(model);
    }

    private void onLoad() {
        Log.i("Draw", "Load button pressed!");

        try (Scanner in = new Scanner(openFileInput(FILE)))  {
            model.load(in);
        } catch (FileNotFoundException | NoSuchElementException e) {
            e.printStackTrace();
            Toast.makeText(this, "Can't open file", Toast.LENGTH_LONG).show();
        }

        view.reloadModel(model);
    }

    private void onSave() {
        Log.i("Draw", "Save button pressed!");

        try (PrintWriter out = new PrintWriter(openFileOutput(FILE, MODE_PRIVATE))) {
            model.save(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving file!", Toast.LENGTH_LONG).show();
        }
    }

    public Figure createSelectedFigure(int x, int y) {
        Figure figure = null;
        if (pixel.isChecked()) figure = new Pixel(x, y);
        else if (circle.isChecked()) figure = new Circle(x, y);
        else if (line.isChecked()) figure = new Line(x, y);
        else if (rect.isChecked()) figure = new Rect(x, y);

        model.add(figure);
        return figure;
    }

}
