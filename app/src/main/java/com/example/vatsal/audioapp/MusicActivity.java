package com.example.vatsal.audioapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.example.vatsal.audioapp.OnSwipeTouchListener;

public class MusicActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private static final String TAG="Swipe Position";
    private float x1,x2,y1,y2;
    private static int MIN_Distance=150;
    private GestureDetector gestureDetector;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        mediaPlayer=MediaPlayer.create(MusicActivity.this,R.raw.musicdance);
        mediaPlayer.start();

        this.gestureDetector=new GestureDetector(MusicActivity.this,this);


    }



    //overrideontouch


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetector.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1=event.getX();
                y1=event.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2=event.getX();
                y2=event.getY();

                //gettingvalueforhorswipe
                float valueX=x2-x1;
                //gettingvalueforverswipe
                float valueY=y2-y1;

                if(Math.abs(valueX)>MIN_Distance)
                {
                    //lefttoright
                    if(x1>x2)
                    {
                        onBackPressed();
                    }else{

                    }
                }else{

                }




        }


        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        onPause();
        this.finish();
        return;
    }





    @Override
   protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            if (isFinishing()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
