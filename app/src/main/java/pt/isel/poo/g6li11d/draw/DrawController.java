package pt.isel.poo.g6li11d.draw;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new DrawModel();
        view = findViewById(R.id.drawView);
        pixel = findViewById(R.id.pixel);
        circle = findViewById(R.id.cirlce);
        line = findViewById(R.id.line);
        rect = findViewById(R.id.rect);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // used to save the contents before the activity goes
        // to background or the screen rotates
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        model.save(writer);
        writer.close();
        outState.putByteArray("model", outputStream.toByteArray());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // used to load the contents from an activity that was in
        // background or that was rotated
        byte[] modelArray = savedInstanceState.getByteArray("model");
        Scanner scanner = new Scanner(new ByteArrayInputStream(modelArray));
        model.load(scanner);
        scanner.close();
        view.reloadModel(model);
    }

    /**
     * Called when the user presses the reset button
     * This will delete every figure and reload the
     * view
     */
    public void onReset(View v) {
        Log.i("Draw", "Reset button pressed!");
        model.clear();
        view.reloadModel(model);
    }

    /**
     * Called when the user presses the load button
     * This will load every figure from the specified
     * file and reload the view
     */
    public void onLoad(View v) {
        Log.i("Draw", "Load button pressed!");

        try (Scanner in = new Scanner(openFileInput(FILE)))  {
            model.load(in);
        } catch (Exception e) {
            // catches every exception that can occur
            // while loading and interpreting a file
            e.printStackTrace();
            Toast.makeText(this, "Can't open file", Toast.LENGTH_LONG).show();
        }

        view.reloadModel(model);
    }

    /**
     * Called when the user presses the save button
     * This will save every figure onto the specified
     * file
     */
    public void onSave(View v) {
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

        if (figure != null)
            model.add(figure);

        return figure;
    }

}
