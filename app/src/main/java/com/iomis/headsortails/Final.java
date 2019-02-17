package com.iomis.headsortails;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class Final extends AppCompatActivity  implements View.OnClickListener {

    Button Menu,ReFlip,Reset;
    TextView HeadsCount,TailsCount;
    final Random random = new Random();
    Counter Heads = new Counter();
    Counter Tails = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        startService(new Intent(this,MyService.class));
        Menu = (Button) findViewById(R.id.menu);
        ReFlip = (Button) findViewById(R.id.Flip);
        HeadsCount = (TextView) findViewById(R.id.HeadsCount);
        TailsCount = (TextView) findViewById(R.id.TailsCount);
        Reset= (Button) findViewById(R.id.Reset);

        Menu.setOnClickListener(this);
        Reset.setOnClickListener(this);
        ReFlip.setOnClickListener(this);
        Intent intent3=getIntent();
        Heads.count=intent3.getIntExtra("Heads",0);
        Tails.count=intent3.getIntExtra("Tails",0);
        int num = random.nextInt(2);
        if(num==1){
            ReFlip.setText("Heads");
            ReFlip.setBackgroundResource(R.drawable.heads);
            Heads.count++;
            HeadsCount.setText("Heads : "+Heads.count);
            TailsCount.setText("Tails : "+Tails.count);
        }
        else {
            ReFlip.setText("Tails");
            ReFlip.setBackgroundResource(R.drawable.tails);
            Tails.count++;
            TailsCount.setText("Tails : "+Tails.count);
            HeadsCount.setText("Heads : "+Heads.count);
        }
    }





    @Override
    public void onClick (View v){

        switch(v.getId()) {
            case R.id.menu :
                Intent intent = new Intent(this,MainActivity.class);
                intent.putExtra("Heads",Heads.count);
                intent.putExtra("Tails",Tails.count);
                startActivity(intent);
                break;


            case R.id.Reset :
                Tails.count=0;
                Heads.count=0;
                HeadsCount.setText("Heads : "+Heads.count);
                TailsCount.setText("Tails : "+Tails.count);
                break;

                case R.id.Flip:
                    Intent intent1 = new Intent(this,StartPlay.class);
                    intent1.putExtra("Heads",Heads.count);
                    intent1.putExtra("Tails",Tails.count);
                    startActivity(intent1);
                    break;

            default:
                break;
        }

    }


}
