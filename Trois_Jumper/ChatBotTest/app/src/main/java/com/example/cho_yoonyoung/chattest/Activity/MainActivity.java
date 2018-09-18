package com.example.cho_yoonyoung.chattest.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cho_yoonyoung.chattest.Activity.ChatBotActivity;
import com.example.cho_yoonyoung.chattest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), ChatBotActivity.class);
    }
}
