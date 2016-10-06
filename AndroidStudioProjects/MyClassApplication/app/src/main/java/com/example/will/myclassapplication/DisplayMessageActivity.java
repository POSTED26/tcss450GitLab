package com.example.will.myclassapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("tag", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(HelloWorldActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("tag", "onPause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.w("tag", "onResume");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v("tag", "onStart");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.e("tag", "onStop");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("tag", "onRestart");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("tag", "onDestroy");
    }
}
