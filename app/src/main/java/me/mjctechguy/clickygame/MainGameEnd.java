package me.mjctechguy.clickygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mjctechguy on 14/08/2017.
 */

public class MainGameEnd extends AppCompatActivity {

    private Intent intent;

    private int scoreGame;
    private TextView mainScoreView;

    private Button restartGame;
    private Button mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        intent = getIntent();


        mainScoreView = (TextView) findViewById(R.id.mainScoreView);
        scoreGame = intent.getIntExtra(MainGame.gameScoreKey,1);

        restartGame = (Button) findViewById(R.id.gameEndRestartGame);
        restartGame.setOnClickListener(gameEndButtonListener);
        mainMenu = (Button) findViewById(R.id.gameEndMainMenu);
        mainMenu.setOnClickListener(gameEndButtonListener);


        if (scoreGame <= 0) {
            mainScoreView.setText("0");
        } else {
            mainScoreView.setText(String.valueOf(scoreGame));
        }
    }

    private View.OnClickListener gameEndButtonListener = new View.OnClickListener() {

        Intent intent;

        @Override


        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.gameEndMainMenu:
                    intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.gameEndRestartGame:
                    intent = new Intent(getApplicationContext(),amountSeconds.class);
                    startActivity(intent);
                    break;
            }
        }
    };




}

