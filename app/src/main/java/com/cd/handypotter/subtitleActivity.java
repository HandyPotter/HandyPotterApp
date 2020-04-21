package com.cd.handypotter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class subtitleActivity extends AppCompatActivity {


    private TextView textView_02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtitle);
        textView_02 = (TextView) findViewById(R.id.textView_02);

        Bundle extras = getIntent().getExtras();
        String mResult = extras.getString("mResult");
        textView_02.setText(mResult);


    }
}
