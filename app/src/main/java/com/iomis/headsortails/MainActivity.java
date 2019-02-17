package com.iomis.headsortails;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Go;
    Counter Heads = new Counter();
    Counter Tails = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Go= (Button) findViewById(R.id.Start);
        Go.setOnClickListener(this);

    }


    @Override
    public void onClick (View v){

        switch(v.getId()) {
            case R.id.Start :
                Intent intent = new Intent(this,StartPlay.class);
                intent.putExtra("Heads",Heads.count);
                intent.putExtra("Tails",Tails.count);
                startActivity(intent);
                break;


            default:
                break;
        }

    }

}
