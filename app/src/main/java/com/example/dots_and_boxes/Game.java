package com.example.dots_and_boxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    private boolean winner = true;
    public int contEdges=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        contEdges=0;
        addListenerOnEdges();
        Log.d("EDGES", "" + contEdges);
        if(contEdges==24){
            Intent intent = new Intent(this, EndGame.class);
            startActivity(intent);
        }

        updateScores("3","2");

    }

    public void addListenerOnEdges(){

        final ImageView edge0010 = (ImageView) findViewById(R.id.edge0010);

        edge0010.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // TODO Auto-generated method stub
                    edge0010.setImageResource(R.drawable.edge);
                    contEdges++;
                    if (contEdges == 24) {
                        fin();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_POINTER_DOWN){

                }
                return false;
            }
        });
        final ImageView edge1020 = (ImageView) findViewById(R.id.edge1020);

        edge1020.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge1020.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge2030 = (ImageView) findViewById(R.id.edge2030);

        edge2030.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge2030.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

        final ImageView edge0001 = (ImageView) findViewById(R.id.edge0001);

        edge0001.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge0001.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge1011 = (ImageView) findViewById(R.id.edge1011);

        edge1011.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge1011.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge2021 = (ImageView) findViewById(R.id.edge2021);

        edge2021.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge2021.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

        final ImageView edge3031 = (ImageView) findViewById(R.id.edge3031);

        edge3031.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge3031.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

        /////////

        final ImageView edge0111 = (ImageView) findViewById(R.id.edge0111);

        edge0111.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge0111.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge1121 = (ImageView) findViewById(R.id.edge1121);

        edge1121.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge1121.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge2131 = (ImageView) findViewById(R.id.edge2131);

        edge2131.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge2131.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

        final ImageView edge0102 = (ImageView) findViewById(R.id.edge0102);

        edge0102.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge0102.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge1112 = (ImageView) findViewById(R.id.edge1112);

        edge1112.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge1112.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge2122 = (ImageView) findViewById(R.id.edge2122);

        edge2122.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge2122.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

        final ImageView edge3132 = (ImageView) findViewById(R.id.edge3132);

        edge3132.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge3132.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

 //////////////

        final ImageView edge0212 = (ImageView) findViewById(R.id.edge0212);

        edge0212.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge0212.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge1222 = (ImageView) findViewById(R.id.edge1222);

        edge1222.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge1222.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge2232 = (ImageView) findViewById(R.id.edge2232);

        edge2232.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge2232.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

        final ImageView edge0203 = (ImageView) findViewById(R.id.edge0203);

        edge0203.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge0203.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge1213 = (ImageView) findViewById(R.id.edge1213);

        edge1213.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge1213.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge2223 = (ImageView) findViewById(R.id.edge2223);

        edge2223.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge2223.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

        final ImageView edge3233 = (ImageView) findViewById(R.id.edge3233);

        edge3233.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge3233.setImageResource(R.drawable.edge_vert);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

//////////



        final ImageView edge0313 = (ImageView) findViewById(R.id.edge0313);

        edge0313.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge0313.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge1323 = (ImageView) findViewById(R.id.edge1323);

        edge1323.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge1323.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });
        final ImageView edge2333 = (ImageView) findViewById(R.id.edge2333);

        edge2333.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edge2333.setImageResource(R.drawable.edge);
                contEdges++;
                if(contEdges==24){
                    fin();
                }
                return false;
            }
        });

    }



    public void updateScores (String player_score, String machine_score){
       TextView player = (TextView)findViewById(R.id.player_score);
        TextView  machine = (TextView)findViewById(R.id.machine_score);
        player.setText(player_score);
        machine.setText(machine_score);

    }
    public void fin(){
        Intent intent = new Intent(this, EndGame.class);
        startActivity(intent);
    }
    public void nuevo(View view){
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }


    public boolean getWinner(){
        return winner;
    }


}
