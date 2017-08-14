package me.mjctechguy.clickygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Mjctechguy on 14/08/2017.
 */

public class MainGameEnd extends AppCompatActivity {

    private Intent intent;

    private int scoreGame;
    private TextView mainScoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        intent = getIntent();


        mainScoreView = (TextView) findViewById(R.id.mainScoreView);
        scoreGame = intent.getIntExtra(MainGame.gameScoreKey,1);

        if (scoreGame <= 0) {
            mainScoreView.setText("0");
        } else {
            mainScoreView.setText(String.valueOf(scoreGame));
        }
    }

}

