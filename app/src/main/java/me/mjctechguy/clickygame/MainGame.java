package me.mjctechguy.clickygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainGame extends AppCompatActivity {

    private Activity activity;

    private Intent intent;
    private int secondsToUse;

    private TextView clickAmount;
    private TextView timerAmount;
    private Button clickButton;
    private Button restartButton;
    private CountDownTimer countDownTimer;
    private boolean timerStarted;

    private int secondsLeft;
    private int tally;
    private View.OnClickListener restartButtonL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resetGame();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        activity = this;

        intent = getIntent();
        secondsToUse = intent.getIntExtra(amountSeconds.amountOfSeconds, 0);

        clickAmount = (TextView) findViewById(R.id.clickTally);
        timerAmount = (TextView) findViewById(R.id.timerAmount);
        clickButton = (Button) findViewById(R.id.buttonClicks);
        restartButton = (Button) findViewById(R.id.restartButton);
        restartButton.setOnClickListener(restartButtonL);

        tally = 0;
        timerStarted = false;

        countDownTimer = new CountDownTimer(secondsToUse * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (Math.round((float) millisUntilFinished / 1000.0f) != secondsLeft) {
                    secondsLeft = Math.round((float) millisUntilFinished / 1000.0f);
                    timerAmount.setText(String.valueOf(secondsLeft)+" seconds");
                }
                timerStarted = true;
            }

            @Override
            public void onFinish() {
                clickButton.setEnabled(false);
                if (secondsToUse == 30 && tally > 100) {
                    Toast.makeText(activity, "Congrats on reaching over 100 clicks!", Toast.LENGTH_LONG).show();
                } else if (secondsToUse == 60 && tally > 200) {
                    Toast.makeText(activity, "Congrats on reaching over 200 clicks!", Toast.LENGTH_LONG).show();
                } else if (secondsToUse == 120 && tally > 400) {
                    Toast.makeText(activity, "Congrats on reaching over 400 clicks!", Toast.LENGTH_LONG).show();
                }
                timerStarted = false;
                timerAmount.setText("Finshed!");
            }
        };
    }

    public void addToTally(View view) {
        if (!timerStarted) {
            countDownTimer.start();
        } else {
            tally++;
            clickAmount.setText(String.valueOf(tally));
        }

    }

    private void resetGame() {
        if(tally < 1){ return;}
        tally = 0;
        clickAmount.setText(String.valueOf(tally));
        countDownTimer.cancel();
        countDownTimer.start();
        if (!clickButton.isEnabled()) {
            clickButton.setEnabled(true);
        }
    }
}
