package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class rectangle extends AppCompatActivity {
    final static int INSISTED_RESULT_CODE = 1;
    final static int DESISTED_RESULT_CODE = 2;
int area = 0 ;
    @BindView(R.id.rectangle_tv_rectangle_wight)
    EditText rectangleTvRectangleWight;
    @BindView(R.id.rectangle_tv_rectangle_height)
    EditText rectangleTvRectangleHeight;
    @BindView(R.id.rectangle_bt_calculate)
    Button rectangleBtCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rectangle_bt_calculate)
    public void onViewClicked() {
        int wight = Integer.parseInt(rectangleTvRectangleWight.getText().toString());
        int height = Integer.parseInt(rectangleTvRectangleHeight.getText().toString());
        area = wight * height ;
        Intent intent = new Intent();
        if (area > 0){
            intent.putExtra("area" , area) ;
            setResult(INSISTED_RESULT_CODE, intent);
        }
  else {
            intent.putExtra("WightOfRectangle" , wight) ;
            intent.putExtra("heightOfRectangle" , height) ;
            setResult(DESISTED_RESULT_CODE, intent);
        }
        finish();
    }
}