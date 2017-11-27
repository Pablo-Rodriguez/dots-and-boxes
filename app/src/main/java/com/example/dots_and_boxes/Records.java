package com.example.dots_and_boxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Records extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        addListenerOnButton();

    }

    public void nuevo (View view){
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }

    Button buttonLevel1, buttonLevel2, buttonLevel3, buttonSize1, buttonSize2, buttonSize3;
    TextView puntuaciones;

    //declare boolean
    boolean isLevelSelected=false;
    boolean isSizeSelected=false;

    public void printResults(){
        puntuaciones = (TextView)findViewById(R.id.puntuaciones);

        //if(checkSelection()) {
            //Easy 3x3
            if ((buttonLevel1.isPressed() && buttonSize1.isPressed())) {
                puntuaciones.setText("First       -   7 \nSecond  -   5 \nThird      -   3");
            }

            //Medium 3x3
            if ((buttonLevel2.isPressed() && buttonSize1.isPressed())) {
                puntuaciones.setText("First       -   5 \nSecond  -   3 \nThird      -   2");

            }

            //Dificult 3x3
            if ((buttonLevel3.isPressed() && buttonSize1.isPressed())) {
                puntuaciones.setText("First       -   3 \nSecond  -   2 \nThird      -   1");

            }
            //Easy 5x5
            if ((buttonLevel1.isPressed() && buttonSize3.isPressed())) {
                puntuaciones.setText("First       -   10 \nSecond  -   7 \nThird      -   5");

            }

            //Medium 5x5
            if ((buttonLevel2.isPressed() && buttonSize3.isPressed())) {
                puntuaciones.setText("First       -   8 \nSecond  -   6 \nThird      -   3");

            }

            //Dificult 5x5
            if ((buttonLevel3.isPressed() && buttonSize3.isPressed())) {
                puntuaciones.setText("First       -   4 \nSecond  -   2 \nThird      -   1");

            }
        //}



    }


    public void addListenerOnButton() {
        buttonLevel1 = (Button) findViewById(R.id.level1_1);
        buttonLevel1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    Log.d("PRESSED", "level 1");
                    isLevelSelected = b.isPressed();
                    printResults();

                }
                return true;
            }

        });
        buttonLevel2 = (Button) findViewById(R.id.level2_2);
        buttonLevel2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    Log.d("PRESSED", "level selected");
                    isLevelSelected = b.isPressed();
                    printResults();

                }
                return true;
            }

        });
        buttonLevel3 = (Button) findViewById(R.id.level3_3);
        buttonLevel3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    Log.d("PRESSED", "level selected");
                    isLevelSelected = b.isPressed();
                    printResults();

                }
                return true;
            }

        });
        buttonSize1 = (Button) findViewById(R.id.size11);
        buttonSize1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    isSizeSelected = b.isPressed();
                    Log.d("PRESSED", "size 1");
                    printResults();
                }
                return true;
            }

        });
        buttonSize3 = (Button) findViewById(R.id.size33);
        buttonSize3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    isSizeSelected = b.isPressed();
                    printResults();
                }
                return true;
            }

        });
    }
        /*buttonSize2 = (Button)findViewById(R.id.size2);
        buttonSize2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    isSizeSelected=b.isPressed();
                    checkSelection();
                }
                return true;
            }

        });*/









}
