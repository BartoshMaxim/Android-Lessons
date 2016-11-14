package ru.startandroid.listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        View.OnClickListener oncBtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case  R.id.btnOk:
                        tvOut.setText("Нажата кнопка ОК");
                        break;
                    case R.id.btnCancel:
                        tvOut.setText("");
                        break;
                }
            }
        };
        btnOk.setOnClickListener(oncBtn);
        btnCancel.setOnClickListener(oncBtn);
    }
}
