package com.example.dots_and_boxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        addListenerOnButton();
    }

    public void checkSelection(){


        if((buttonLevel1.isPressed() ||  buttonLevel2.isPressed() ||  buttonLevel3.isPressed()) &&
                (buttonSize1.isPressed() ||  buttonSize3.isPressed())){
            Log.d("PRESSED", "next activity");
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
        }
    }
    Button buttonLevel1, buttonLevel2, buttonLevel3, buttonSize1, buttonSize3;

    //declare boolean
    boolean isLevelSelected=false;
    boolean isSizeSelected=false;


    public void addListenerOnButton(){
        buttonLevel1 = (Button)findViewById(R.id.level1);
        buttonLevel1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    Log.d("PRESSED", "level 1");
                    isLevelSelected=b.isPressed();
                    checkSelection();

                }
                return true;
            }

        });
        buttonLevel2 = (Button)findViewById(R.id.level2);
        buttonLevel2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    Log.d("PRESSED", "level selected");
                    isLevelSelected=b.isPressed();
                    checkSelection();

                }
                return true;
            }

        });
        buttonLevel3 = (Button)findViewById(R.id.level3);
        buttonLevel3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    Log.d("PRESSED", "level selected");
                    isLevelSelected=b.isPressed();
                    checkSelection();

                }
                return true;
            }

        });
        buttonSize1 = (Button)findViewById(R.id.size1);
        buttonSize1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Button b = ((Button) v);
                    b.setPressed(!b.isPressed());//if pressed, unpress; if unpressed, press
                    isSizeSelected=b.isPressed();
                    Log.d("PRESSED", "size 1");
                    checkSelection();
                }
                return true;
            }

        });
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
        buttonSize3 = (Button)findViewById(R.id.size3);
        buttonSize3.setOnTouchListener(new View.OnTouchListener() {
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

        });


    }






}
