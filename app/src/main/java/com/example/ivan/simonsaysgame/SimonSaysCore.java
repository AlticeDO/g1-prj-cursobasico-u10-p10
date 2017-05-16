package com.example.ivan.simonsaysgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SimonSaysCore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_says_core);

        final LinearLayout layout = (LinearLayout) findViewById(R.id.start);
        final RelativeLayout relative = (RelativeLayout) findViewById(R.id.game);
        Animation
        layout.setAnimation();
        ImageButton play = (ImageButton) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        layout.setVisibility(View.INVISIBLE);
                                        relative.setVisibility(View.VISIBLE);
                                    }
                                }
        );


    }
}
