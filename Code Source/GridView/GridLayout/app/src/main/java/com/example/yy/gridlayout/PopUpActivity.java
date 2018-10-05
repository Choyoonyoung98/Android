package com.example.yy.gridlayout;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import static com.example.yy.gridlayout.MainActivity.*;

public class PopUpActivity extends Activity {

    EditText editFoodName,editFoodPrice;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pop_up);


        editFoodName = (EditText)findViewById(R.id.editFoodname);
        editFoodPrice = (EditText)findViewById(R.id.editFoodPrice);
        btnAdd = (Button)findViewById(R.id.btnAdd);

    }


    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    public void onBackPressed(){
        return;
    }

    public void onButtonClicked(View view) {
        String fname = editFoodName.getText().toString();
        String price = editFoodPrice.getText().toString();
        int fprice = Integer.parseInt(price);

        Intent intent = new Intent();
        intent.putExtra("name",fname);
        intent.putExtra("price",fprice);
        setResult(70,intent);
        finish();

    }

}

