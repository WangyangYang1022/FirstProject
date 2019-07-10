package com.example.firstproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.firstproject.R;
import com.example.firstproject.util.XFSpeechUtil;

public class SecondActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText=(EditText) findViewById(R.id.edittext);
        ImageView imageView=(ImageView)findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yuyin();
            }
        });
    }
    private void yuyin(){
        XFSpeechUtil util=new XFSpeechUtil(new XFSpeechUtil.OnRecognizerSuccessListener() {
            @Override
            public void onSuccess(String text) {
                editText.setText(text);
            }
        },this);
        util.initSpeech();
    }
}
