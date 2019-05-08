package pt.isel.poo.g6li11d.draw;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import pt.isel.poo.g6li11d.draw.model.Circle;
import pt.isel.poo.g6li11d.draw.model.DrawModel;
import pt.isel.poo.g6li11d.draw.model.Figure;
import pt.isel.poo.g6li11d.draw.model.FreeForm;
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
    private RadioButton free;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new DrawModel();
        view = new DrawView(this);

        // Layout for the Buttons, RadioButtons and DrawView
        LinearLayout layout = new LinearLayout(this);
        // Layout for the Buttons
        LinearLayout buttonGroup = new LinearLayout(this);
        // Layout for the RadioButtons
        RadioGroup radioGroup = new RadioGroup(this);

        // Create the buttons and add them to the button group
        Button save = new Button(this);
        save.setText("Save");
        save.setOnClickListener(v -> onSave());
        Button load = new Button(this);
        load.setText("Load");
        load.setOnClickListener(v -> onLoad());
        Button reset = new Button(this);
        reset.setText("Reset");
        reset.setOnClickListener(v -> onReset());

        buttonGroup.addView(save);
        buttonGroup.addView(load);
        buttonGroup.addView(reset);

        // Create the radio buttons and add them to the radio group
        pixel = new RadioButton(this);
        pixel.setText("Pixel");
        circle = new RadioButton(this);
        circle.setText("Circle");
        line = new RadioButton(this);
        line.setText("Line");
        rect = new RadioButton(this);
        rect.setText("Rect");
        free = new RadioButton(this);
        free.setText("FreeForm");

        radioGroup.addView(pixel);
        radioGroup.addView(circle);
        radioGroup.addView(line);
        radioGroup.addView(rect);
        radioGroup.addView(free);

        // It is important to toggle the default only after adding it to the radio group
        // or it will bug with the other radio buttons
        pixel.toggle();

        // We want the radio group to be displayed horizontally and the main layout
        // vertically
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(buttonGroup);
        layout.addView(radioGroup);
        layout.addView(view);

        setContentView(layout);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // used to save the contents before the activity goes
        // to background or the screen rotates
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            model.save(writer);
            writer.close();
            outState.putByteArray("model", outputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // used to load the contents from an activity that was in
        // background or that was rotated
        try {
            byte[] modelArray = savedInstanceState.getByteArray("model");
            Scanner scanner = new Scanner(new ByteArrayInputStream(modelArray));
            model.load(scanner);
            scanner.close();
            view.reloadModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when the user presses the reset button
     * This will delete every figure and reload the
     * view
     */
    private void onReset() {
        Log.i("Draw", "Reset button pressed!");
        model.clear();
        view.reloadModel(model);
    }

    /**
     * Called when the user presses the load button
     * This will load every figure from the specified
     * file and reload the view
     */
    private void onLoad() {
        Log.i("Draw", "Load button pressed!");

        try (Scanner in = new Scanner(openFileInput(FILE)))  {
            model.load(in);
        } catch (Exception e) {
            // catches every exception that can occur
            // while loading and interpreting a file
            e.printStackTrace();
            Toast.makeText(this, "Error loading shapes!", Toast.LENGTH_LONG).show();
        }

        view.reloadModel(model);
    }

    /**
     * Called when the user presses the save button
     * This will save every figure onto the specified
     * file
     */
    private void onSave() {
        Log.i("Draw", "Save button pressed!");

        try (PrintWriter out = new PrintWriter(openFileOutput(FILE, MODE_PRIVATE))) {
            model.save(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving file!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Creates a new figure on (x, y) based on the
     * selected radio button
     * @param x x position of the figure
     * @param y y position of the figure
     * @return a new Figure instance or null if a bug occurs
     */
    public Figure createSelectedFigure(int x, int y) {
        Figure figure = null;
        if (pixel.isChecked()) figure = new Pixel(x, y);
        else if (circle.isChecked()) figure = new Circle(x, y);
        else if (line.isChecked()) figure = new Line(x, y);
        else if (rect.isChecked()) figure = new Rect(x, y);
        else if (free.isChecked()) figure = new FreeForm(x, y);

        if (figure != null)
            model.add(figure);

        return figure;
    }

}
