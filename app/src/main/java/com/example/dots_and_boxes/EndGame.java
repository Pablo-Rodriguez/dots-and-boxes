package com.example.dots_and_boxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EndGame extends AppCompatActivity {

    Game game = new Game();
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
         image = (ImageView)findViewById(R.id.winner_loser);

        if(game.getWinner()){
            image.setImageResource(R.drawable.winner);
        }
        else{
            image.setImageResource(R.drawable.loser);
        }
    }

    public void newGame (View view){
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }

    public void records (View view){
       Intent intent = new Intent(this, Records.class);
        startActivity(intent);
    }
}
