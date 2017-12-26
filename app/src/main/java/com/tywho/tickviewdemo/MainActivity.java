package com.tywho.tickviewdemo;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tywho.tickviewdemo.view.TickView;

public class MainActivity extends AppCompatActivity {
    Button startView;
    TickView tickView;
    TextView animState;

    boolean isAnim = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startView = findViewById(R.id.startView);
        tickView = findViewById(R.id.tickView);
        animState = findViewById(R.id.animState);

        tickView.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                animState.setText("onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                animState.setText("onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        startView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isAnim) {
                    tickView.start();
                } else {
                    tickView.stop();
                }
            }
        });
    }
}
