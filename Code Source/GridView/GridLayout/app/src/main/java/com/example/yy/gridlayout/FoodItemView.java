package com.example.yy.gridlayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FoodItemView extends LinearLayout {
    ImageView imageView;
    TextView textFoodName;
    TextView textFoodPrice;

    public FoodItemView(Context context) {
        super(context);
        init(context);
    }

    public FoodItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        // food_item.xml 을 대상으로 inflation하는 코드 작성
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.food_item,this, true);

        textFoodName = (TextView)findViewById(R.id.txtFoodName);
        textFoodPrice = (TextView)findViewById(R.id.txtFoodPrice);
        imageView = (ImageView)findViewById(R.id.imageView);
    }

    public void setImageView(int resID) {
        imageView.setImageResource(resID);
    }

    public void setTextFoodName(String name) {
        textFoodName.setText(name);
    }

    public void setTextFoodPrice(int price) {
        textFoodPrice.setText(String.valueOf(price));
        //textFoodPrice.setText(price+"");
    }
}
