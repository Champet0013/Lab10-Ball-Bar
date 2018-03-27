package com.example.ist_mac_01.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyButton myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.MyButton);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
    }
}

class MyButton extends View {
    public MyButton(Context context){
        super(context);
    }
    public MyButton(Context context, @Nullable AttributeSet attrs){
        super(context , attrs);
    }

    protected void onDraw (Canvas canvas){
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(40,20,90,80,paint);

        paint.setColor(Color.GREEN);
        canvas.drawCircle(400,500,200,paint);

        canvas.drawArc(170,770,630,1230,0,180,true,paint);
        paint.setColor(Color.RED);
        canvas.drawArc(200,800,600,1200,0,180,true,paint);

        paint.setColor(Color.BLACK);
//        canvas.drawCircle(270,1100,20,paint);
        canvas.save();
        canvas.rotate(30,250,1100);
        canvas.scale(.5f,.5f,150,1200);
        canvas.drawOval(275, 1025, 300, 1075, paint);
        canvas.restore();
        canvas.drawOval(350, 1025, 375, 1075, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(425, 1025, 450, 1075, paint);
        canvas.drawOval(500, 1025, 525, 1075, paint);

        canvas.drawOval(312, 1050, 337, 1100, paint);
        canvas.drawOval(387, 1050, 412, 1100, paint);
        canvas.drawOval(462, 1050, 487, 1100, paint);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP){
            float x =event.getX();
            float y = event.getY();

            if(x >= 40 && x<=90 && y >= 20 && y <= 80){
                invalidate();
            }
        }
        return true;
//        return super.onTouchEvent(event);
    }
}
