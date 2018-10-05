package com.example.yy.gridlayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    FoodAdapter foodAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 리스트 뷰 객체 얻어와서
        gridView = (GridView) findViewById(R.id.gridView);
        // 어댑터 생성
        foodAdapter = new FoodAdapter();
        // 어댑터 통해서 아이템들을 추가
        foodAdapter.addItem(new FoodItem("포도", 3000, R.drawable.grape));
        foodAdapter.addItem(new FoodItem("레몬", 2000, R.drawable.lemon));
        foodAdapter.addItem(new FoodItem("배", 5000, R.drawable.pear));
        // 리스트뷰에 어댑터 설정
        gridView.setAdapter(foodAdapter);

        // 리스트 항목 선택하면 이벤트 처리
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                FoodItem item = (FoodItem) foodAdapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택: " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onButtonPlusClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), PopUpActivity.class);
        startActivityForResult(intent, 100);
    }

    public class FoodAdapter extends BaseAdapter {
        ArrayList<FoodItem> items = new ArrayList<FoodItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addItem(FoodItem item) {
            items.add(item);
        }

        @Override // ******중요*******
        public View getView(int position, View convertView, ViewGroup parent) {
            FoodItemView view = new FoodItemView(getApplicationContext());

            FoodItem item = items.get(position);
            view.setTextFoodName(item.getName());
            view.setTextFoodPrice(item.getPrice());
            view.setImageView(item.getResId());
            return view;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_CANCELED){
            if (requestCode == 100) {
                if (data != null) {
                    String name = (String) data.getExtras().getString("name");
                    int price=data.getIntExtra("price",0);
                    //int Iprice=Integer.parseInt(Sprice);

                    foodAdapter.addItem(new FoodItem(name, price, R.drawable.strawberry));
                    foodAdapter.notifyDataSetChanged();
                }
            }

        }
    }
}

