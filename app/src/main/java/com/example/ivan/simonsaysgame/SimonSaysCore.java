package com.example.ivan.simonsaysgame;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class SimonSaysCore extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<Integer> arr = new ArrayList<>();
    private int index = 0;
    private Random r = new Random();
    private Handler handler = new Handler();
    private int delay = 0;
    MediaPlayer media = new MediaPlayer();
    private int [] delaylvl = {1000, 500, 250};
    private int [] durationlvl = {800, 400, 200};
    private int [] randlvl = {1,2,3};
    private int [] scorelvl = {100,200,400};
    private int lvl = 2;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_says_core);
        findViewById(R.id.play).setOnClickListener(this);
        getSupportActionBar().hide();
        media = MediaPlayer.create(this, R.raw.music2);
        media.setLooping(true);
        media.start();
    }

    @Override
    public void onBackPressed() {
        if(findViewById(R.id.game).isShown()){
            findViewById(R.id.start).setVisibility(View.VISIBLE);
            findViewById(R.id.game).setVisibility(View.INVISIBLE);
            defaultImages();
            handler.removeCallbacksAndMessages(null);
            arr = new ArrayList<>();
            score = 0;
            setScore(score);
        }
        else{
            new AlertDialog.Builder(this)
                    .setTitle("Exiting App")
                    .setMessage("Are you sure you want to quit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            media.stop();
                            media.release();
                        }
                    })
                    .setNegativeButton("NO", null).show();
        }
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.play:

                String [] list = new String[] {"Easy", "Normal", "Hard"};
                final NumberPicker picker = new NumberPicker(this);
                picker.setMaxValue(list.length-1);
                picker.setDisplayedValues(list);
                picker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

                new AlertDialog.Builder(this)
                        .setTitle("Choose Difficulty:")
                        .setView(picker)
                        .setPositiveButton("PLAY", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                lvl = picker.getValue();
                                findViewById(R.id.start).setVisibility(View.INVISIBLE);
                                findViewById(R.id.game).setVisibility(View.VISIBLE);
                                addRand(3);
                                delayedStart(1000);
                            }
                        })
                        .setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
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
                addRand(randlvl[lvl]);
                setScore(score+=scorelvl[lvl]);
                toggleAnswer(R.id.answer, R.drawable.right, R.drawable.transparent, 1000);
                delayedStart(1000);
            }
        }else{
            toggleAnswer(R.id.answer, R.drawable.wrong, R.drawable.transparent, 100);
            index = 0;
        }
    }

    public void start(){
        clearOnClickListeners();
        for (int i: arr){
            switch (i){
                case 0:
                    toggleImages(R.id.button_0, R.drawable.icon_0, R.drawable.icon_0_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
                    break;
                case 1:
                    toggleImages(R.id.button_1, R.drawable.icon_1, R.drawable.icon_1_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
                    break;
                case 2:
                    toggleImages(R.id.button_2, R.drawable.icon_2, R.drawable.icon_2_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
                    break;
                case 3:
                    toggleImages(R.id.button_3, R.drawable.icon_3, R.drawable.icon_3_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
                    break;
                case 4:
                    toggleImages(R.id.button_4, R.drawable.icon_4, R.drawable.icon_4_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
                    break;
                case 5:
                    toggleImages(R.id.button_5, R.drawable.icon_5, R.drawable.icon_5_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
                    break;
                case 6:
                    toggleImages(R.id.button_6, R.drawable.icon_6, R.drawable.icon_6_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
                    break;
                case 7:
                    toggleImages(R.id.button_7, R.drawable.icon_7, R.drawable.icon_7_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
                    break;
                case 8:
                    toggleImages(R.id.button_8, R.drawable.icon_8, R.drawable.icon_8_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
                    break;
                case 9:
                    toggleImages(R.id.button_9, R.drawable.icon_9, R.drawable.icon_9_yellow, delay, durationlvl[lvl]);
                    delay+=delaylvl[lvl];
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

    public void setScore(int score){
        ((TextView) findViewById(R.id.score)).setText("Score: "+Integer.toString(score));
    }

    public void clearOnClickListeners(){
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

    public void defaultImages(){
        setImage(R.id.button_0, R.drawable.icon_0);
        setImage(R.id.button_1, R.drawable.icon_1);
        setImage(R.id.button_2, R.drawable.icon_2);
        setImage(R.id.button_3, R.drawable.icon_3);
        setImage(R.id.button_4, R.drawable.icon_4);
        setImage(R.id.button_5, R.drawable.icon_5);
        setImage(R.id.button_6, R.drawable.icon_6);
        setImage(R.id.button_7, R.drawable.icon_7);
        setImage(R.id.button_8, R.drawable.icon_8);
        setImage(R.id.button_9, R.drawable.icon_9);
        setAnswer(R.id.answer, R.drawable.transparent);
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
