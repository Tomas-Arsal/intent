package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class trangle extends AppCompatActivity {
    final static double INSISTED_RESULT_CODE = 1;
    final static double DESISTED_RESULT_CODE = 2;
    double area;
    @BindView(R.id.trangle_tv_rectangle_wight)
    EditText trangleTvRectangleWight;
    @BindView(R.id.trangle_tv_rectangle_height)
    EditText trangleTvRectangleHeight;
    @BindView(R.id.trangle_bt_calculate)
    Button trangleBtCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangle);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.trangle_bt_calculate)
    public void onViewClicked() {
        double wight = Integer.parseInt(trangleTvRectangleWight.getText().toString());
        double height = Integer.parseInt(trangleTvRectangleHeight.getText().toString());
        area = 0.5 * wight * height;
        Intent intent = new Intent();
        if(area > 0){
            intent.putExtra("areaa", area);
            setResult((int) trangle.INSISTED_RESULT_CODE, intent);
        }
        else {
            intent .putExtra("WightOfTrangle" , 0);
            intent .putExtra("HeightOfTrangle" , 0);
            setResult((int) trangle.DESISTED_RESULT_CODE, intent);
        }
        finish();
    }
}
