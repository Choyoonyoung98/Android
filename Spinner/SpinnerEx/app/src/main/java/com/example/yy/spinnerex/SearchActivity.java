package com.example.yy.spinnerex;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SearchActivity extends Activity {

    Spinner spinner_gender;
    public static String select_item = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner_gender = findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_array,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter);

    }
    public void onAddBtnClicked(View view) {
        Intent intent = new Intent();
        String str_season = spinner_gender.getSelectedItem().toString();

        intent.putExtra("gender", str_season);
        setResult(70,intent);
        finish();
    }
    }
