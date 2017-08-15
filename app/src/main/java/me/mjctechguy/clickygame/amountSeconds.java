package me.mjctechguy.clickygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class amountSeconds extends AppCompatActivity {

    public static final String amountOfSeconds = "amountOfSeconds";
    private Button button30;
    private Button button60;
    private Button button120;
    private Button buttonCustom;

    private EditText customAmountOfTime;
    private int customSecondsS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_seconds);

        button30 = (Button)findViewById(R.id.button30Seconds);
        button30.setOnClickListener(onClickListener);

        button60 = (Button)findViewById(R.id.button60Seconds);
        button60.setOnClickListener(onClickListener);

        button120 = (Button)findViewById(R.id.button120Seconds);
        button120.setOnClickListener(onClickListener);

        buttonCustom = (Button) findViewById(R.id.customTimeInput);
        buttonCustom.setOnClickListener(onClickListener);

        customAmountOfTime = (EditText)  findViewById(R.id.customSeconds);


    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(v.getContext(), MainGame.class);

            switch (v.getId()) {
                case R.id.button30Seconds:
                    intent.putExtra(amountOfSeconds,5);
                    startActivity(intent);
                    break;

                case R.id.button60Seconds:
                    intent.putExtra(amountOfSeconds,60);
                    startActivity(intent);
                    break;

                case R.id.button120Seconds:
                    intent.putExtra(amountOfSeconds,120);
                    startActivity(intent);
                    break;
                case R.id.customTimeInput:
                    customSecondsS = Integer.parseInt(customAmountOfTime.getText().toString());
                    if(customSecondsS < 1 || customSecondsS > 500) {
                        Toast.makeText(getApplicationContext(), "Please enter a number in seconds upto 500",Toast.LENGTH_SHORT).show();
                    } else {
                        intent.putExtra(amountOfSeconds,customSecondsS);
                        startActivity(intent);
                        break;
                    }
            }
        }
    };

}
