package com.example.android.staysafe1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main2Activity_wildfire extends AppCompatActivity {
    TextView descText2, descText3,descText4;
    ImageButton plus2, minus2,plus3, minus3,plus4, minus4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_wildfire);
        descText2 = (TextView) findViewById(R.id.description_textw2);
        descText3 = (TextView) findViewById(R.id.description_textw3);
        descText4 = (TextView) findViewById(R.id.description_textw4);


        minus2 = (ImageButton) findViewById(R.id.minusw2);
        plus2 = (ImageButton) findViewById(R.id.plusw2);

        minus3 = (ImageButton) findViewById(R.id.minusw3);
        plus3 = (ImageButton) findViewById(R.id.plusw3);

        minus4 = (ImageButton) findViewById(R.id.minusw4);
        plus4 = (ImageButton) findViewById(R.id.plusw4);

        minus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                minus2.setVisibility(v.GONE);
                plus2.setVisibility(v.VISIBLE);
                descText2.setVisibility(View.GONE);

            }
        });
        plus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                plus2.setVisibility(v.GONE);
                minus2.setVisibility(v.VISIBLE);
                descText2.setVisibility(View.VISIBLE);

            }
        });

        minus3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                minus3.setVisibility(v.GONE);
                plus3.setVisibility(v.VISIBLE);
                descText3.setVisibility(View.GONE);

            }
        });
        plus3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                plus3.setVisibility(v.GONE);
                minus3.setVisibility(v.VISIBLE);
                descText3.setVisibility(View.VISIBLE);

            }
        });

        minus4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                minus4.setVisibility(v.GONE);
                plus4.setVisibility(v.VISIBLE);
                descText4.setVisibility(View.GONE);

            }
        });
        plus4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                plus4.setVisibility(v.GONE);
                minus4.setVisibility(v.VISIBLE);
                descText4.setVisibility(View.VISIBLE);

            }
        });

    }
}

