package ru.startandroid.onclickbuttons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout1;
    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
        tvOut = (TextView)findViewById(R.id.tvOut);
        btnOk =(Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        OnClickListener oclBtnOk = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tvOut.setText("Кнопка нажата");
            }
        };

        OnClickListener oclBtnCancel = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tvOut.setText("");
            }
        };
        btnOk.setOnClickListener(oclBtnOk);
        btnCancel.setOnClickListener(oclBtnCancel);
    }


}
