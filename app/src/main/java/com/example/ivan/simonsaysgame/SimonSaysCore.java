package com.example.ivan.simonsaysgame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class SimonSaysCore extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<Integer> arr = new ArrayList<>();
    private int index = 0;
    private Random r = new Random();
    private Handler handler = new Handler();
    private int delay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_says_core);
        findViewById(R.id.play).setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.play:
                findViewById(R.id.start).setVisibility(View.INVISIBLE);
                findViewById(R.id.game).setVisibility(View.VISIBLE);
                addRand(3);
                delayedStart(1000);
                break;
            case R.id.button_0:
                toggleImages(R.id.button_0, R.drawable.icon_0, R.drawable.icon_0_yellow, 0, 50);
                checkArr(0);
                break;
            case R.id.button_1:
                toggleImages(R.id.button_1, R.drawable.icon_1, R.drawable.icon_1_yellow, 0, 50);
                checkArr(1);
                break;
            case R.id.button_2:
                toggleImages(R.id.button_2, R.drawable.icon_2, R.drawable.icon_2_yellow, 0, 50);
                checkArr(2);
                break;
            case R.id.button_3:
                toggleImages(R.id.button_3, R.drawable.icon_3, R.drawable.icon_3_yellow, 0, 50);
                checkArr(3);
                break;
            case R.id.button_4:
                toggleImages(R.id.button_4, R.drawable.icon_4, R.drawable.icon_4_yellow, 0, 50);
                checkArr(4);
                break;
            case R.id.button_5:
                toggleImages(R.id.button_5, R.drawable.icon_5, R.drawable.icon_5_yellow, 0, 50);
                checkArr(5);
                break;
            case R.id.button_6:
                toggleImages(R.id.button_6, R.drawable.icon_6, R.drawable.icon_6_yellow, 0, 50);
                checkArr(6);
                break;
            case R.id.button_7:
                toggleImages(R.id.button_7, R.drawable.icon_7, R.drawable.icon_7_yellow, 0, 50);
                checkArr(7);
                break;
            case R.id.button_8:
                toggleImages(R.id.button_8, R.drawable.icon_8, R.drawable.icon_8_yellow, 0, 50);
                checkArr(8);
                break;
            case R.id.button_9:
                toggleImages(R.id.button_9, R.drawable.icon_9, R.drawable.icon_9_yellow, 0, 50);
                checkArr(9);
                break;
        }
    }

    public void addRand(int num){
        for(int i=0; i<num;i++){ arr.add(r.nextInt(10)); }
    }

    public void checkArr(int num){
        if(arr.get(index)==num){
            index++;
            if(index>=arr.size()){
                index = 0;
                addRand(2);
                toggleAnswer(R.id.answer, R.drawable.right, R.drawable.transparent, 1000);
                delayedStart(1000);
            }
        }else{
            toggleAnswer(R.id.answer, R.drawable.wrong, R.drawable.transparent, 100);
            index = 0;
        }
    }

    public void start(){
        unsetOnClickListeners();
        for (int i: arr){
            switch (i){
                case 0:
                    toggleImages(R.id.button_0, R.drawable.icon_0, R.drawable.icon_0_yellow, delay, 800);
                    delay+=1000;
                    break;
                case 1:
                    toggleImages(R.id.button_1, R.drawable.icon_1, R.drawable.icon_1_yellow, delay, 800);
                    delay+=1000;
                    break;
                case 2:
                    toggleImages(R.id.button_2, R.drawable.icon_2, R.drawable.icon_2_yellow, delay, 800);
                    delay+=1000;
                    break;
                case 3:
                    toggleImages(R.id.button_3, R.drawable.icon_3, R.drawable.icon_3_yellow, delay, 800);
                    delay+=1000;
                    break;
                case 4:
                    toggleImages(R.id.button_4, R.drawable.icon_4, R.drawable.icon_4_yellow, delay, 800);
                    delay+=1000;
                    break;
                case 5:
                    toggleImages(R.id.button_5, R.drawable.icon_5, R.drawable.icon_5_yellow, delay, 800);
                    delay+=1000;
                    break;
                case 6:
                    toggleImages(R.id.button_6, R.drawable.icon_6, R.drawable.icon_6_yellow, delay, 800);
                    delay+=1000;
                    break;
                case 7:
                    toggleImages(R.id.button_7, R.drawable.icon_7, R.drawable.icon_7_yellow, delay, 800);
                    delay+=1000;
                    break;
                case 8:
                    toggleImages(R.id.button_8, R.drawable.icon_8, R.drawable.icon_8_yellow, delay, 800);
                    delay+=1000;
                    break;
                case 9:
                    toggleImages(R.id.button_9, R.drawable.icon_9, R.drawable.icon_9_yellow, delay, 800);
                    delay+=1000;
                    break;
            }
        }
        delayedSetOnClickListeners(delay);
        delay=0;
    }

    public void delayedStart(int delay){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }, delay);
    }

    public void unsetOnClickListeners(){
        findViewById(R.id.button_0).setOnClickListener(null);
        findViewById(R.id.button_1).setOnClickListener(null);
        findViewById(R.id.button_2).setOnClickListener(null);
        findViewById(R.id.button_3).setOnClickListener(null);
        findViewById(R.id.button_4).setOnClickListener(null);
        findViewById(R.id.button_5).setOnClickListener(null);
        findViewById(R.id.button_6).setOnClickListener(null);
        findViewById(R.id.button_7).setOnClickListener(null);
        findViewById(R.id.button_8).setOnClickListener(null);
        findViewById(R.id.button_9).setOnClickListener(null);
    }

    public void setOnClickListeners(){
        findViewById(R.id.button_0).setOnClickListener(this);
        findViewById(R.id.button_1).setOnClickListener(this);
        findViewById(R.id.button_2).setOnClickListener(this);
        findViewById(R.id.button_3).setOnClickListener(this);
        findViewById(R.id.button_4).setOnClickListener(this);
        findViewById(R.id.button_5).setOnClickListener(this);
        findViewById(R.id.button_6).setOnClickListener(this);
        findViewById(R.id.button_7).setOnClickListener(this);
        findViewById(R.id.button_8).setOnClickListener(this);
        findViewById(R.id.button_9).setOnClickListener(this);
    }

    public void delayedSetOnClickListeners(int delay){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setOnClickListeners();
            }
        }, delay);
    }

    public void setImage(int button, int image){
        ((ImageButton) findViewById(button)).setImageResource(image);
    }

    public void toggleImages(final int button,final int image1, final int image2, int delay, int duration){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setImage(button, image2);
            }
        }, delay);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setImage(button, image1);
            }
        }, delay+duration);
    }

    public void setAnswer(int imageView, int answer){
        ((ImageView) findViewById(imageView)).setImageResource(answer);
    }

    public void toggleAnswer(final int imageView, int image1, final int transparent, int delay){
        setAnswer(imageView, image1);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setAnswer(imageView, transparent);
            }
        }, delay);
    }
}
