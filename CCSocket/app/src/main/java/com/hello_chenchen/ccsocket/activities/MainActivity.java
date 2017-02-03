package com.hello_chenchen.ccsocket.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hello_chenchen.ccsocket.base.CommonDefine;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connect_btn = (Button)findViewById(R.id.connect_btn);

        connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "" + CommonDefine.CC_FAIL,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
