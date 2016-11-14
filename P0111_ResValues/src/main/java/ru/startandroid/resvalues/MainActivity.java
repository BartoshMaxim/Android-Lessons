package ru.startandroid.resvalues;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout llTop = (LinearLayout) findViewById(R.id.llTop);
        llTop.setBackgroundResource(R.color.llTop);
    }
}
