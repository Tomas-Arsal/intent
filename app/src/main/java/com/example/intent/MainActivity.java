package com.example.intent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    final static int RECTANGLE_REQUEST_CODE = 1;
    final static int TRANTANGLE_REQUEST_CODE = 2;
    TextView textView;
    Button Rectangle;
    Button Trangle;
    Button Return;

    //Rectangle -> W * H        1
    // Trangle -> 0.5 * base *  h
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Rectangle = findViewById(R.id.areas_bt_rectangle);
        Trangle = findViewById(R.id.areas_bt_trangle);
        Return = findViewById(R.id.areas_bt_calculate);
        Rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.areas_bt_rectangle:
                        Intent rectangle = new Intent(getBaseContext(), rectangle.class);
                        startActivityForResult(rectangle, RECTANGLE_REQUEST_CODE);
                        break;
                    case R.id.areas_bt_trangle:
                        Intent trangle = new Intent(getBaseContext(), trangle.class);
                        startActivityForResult(trangle, TRANTANGLE_REQUEST_CODE);
                        break;
                }
            }

        });
        Trangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.areas_bt_rectangle:
                        Intent rectangle = new Intent(getBaseContext(), rectangle.class);
                        startActivityForResult(rectangle, RECTANGLE_REQUEST_CODE);
                        break;
                    case R.id.areas_bt_trangle:
                        Intent trangle = new Intent(getBaseContext(), trangle.class);
                        startActivityForResult(trangle, TRANTANGLE_REQUEST_CODE);
                        break;
                }
            }

        });

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RECTANGLE_REQUEST_CODE) {
            if (resultCode == rectangle.INSISTED_RESULT_CODE) {
                String oldtext = textView.getText().toString();

                int newArea = data.getIntExtra("area", 0);
                textView.setText(oldtext + "Rectangle" + " = " + newArea);
            } else if (resultCode == TRANTANGLE_REQUEST_CODE) {
                String oldtext = textView.getText().toString();
                int wight = data.getIntExtra("WightOfRectangle", 0);
                int height = data.getIntExtra("heightOfRectangle", 0);
                textView.setText(oldtext + "WightOfRectangle" + " = " + wight + "\n" + "heightOfRectangle" + " = " + height);

            }
        } else if (requestCode == TRANTANGLE_REQUEST_CODE) {
            if (resultCode == trangle.INSISTED_RESULT_CODE) {
                String oldtext = textView.getText().toString();

                double newArea = data.getDoubleExtra("areaa", 0);
                textView.setText(oldtext + "Trangle" + " = " + newArea);
            } else if (resultCode == rectangle.DESISTED_RESULT_CODE) {
                String oldtext = textView.getText().toString();
                double wight = data.getDoubleExtra("WightOfRectangle", 0);
                double height = data.getDoubleExtra("HeightOfRectangle", 0);
                textView.setText(oldtext + " WightOfRectangle" + " = " + wight + "\n" + " HeightOfRectangle" + " = " + height);
            }
        }
    }

}
/**/
