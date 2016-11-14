package ru.startandroid.viewbyld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView myTextView = (TextView) findViewById(R.id.myText);
        myTextView.setText("Test text");
        Button myButton = (Button) findViewById(R.id.myButton);
        myButton.setText("My button");
        myButton.setEnabled(false);
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox1.setChecked(true);
    }
}
