package com.iomis.headsortails;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.felipecsl.gifimageview.library.GifImageView;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class StartPlay extends AppCompatActivity {

    private GifImageView gifImageView;

    Counter Heads = new Counter();
    Counter Tails = new Counter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_play);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        gifImageView = (GifImageView) findViewById(R.id.gifImageView);
        Intent intent3=getIntent();
        Heads.count=intent3.getIntExtra("Heads",0);
        Tails.count=intent3.getIntExtra("Tails",0);

        try {
            InputStream inputStream = getAssets().open("coin.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex){

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 =new Intent(StartPlay.this,Final.class);
                intent1.putExtra("Heads",Heads.count);
                intent1.putExtra("Tails",Tails.count);
                StartPlay.this.startActivity(intent1);
                StartPlay.this.finish();
            }
        },3000);



    }


}
