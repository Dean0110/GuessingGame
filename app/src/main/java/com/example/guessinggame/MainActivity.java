package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int correct_num;
    TextView tip;
    TextView bingo;
    TextView hint;
    EditText input_text;
    ImageView arrow_up;
    ImageView arrow_down;
    ImageButton btn_check;
    ImageButton btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tip=findViewById(R.id.txt_tip);
        hint=findViewById(R.id.txt_hint);
        bingo=findViewById(R.id.txt_bingo);
        input_text=findViewById(R.id.edt_input);
        btn_check=findViewById(R.id.btn_check);
        btn_return=findViewById(R.id.btn_return);
        arrow_up=findViewById(R.id.img_arrow_up);
        arrow_down=findViewById(R.id.img_arrow_down);

        Random generator=new Random();
        correct_num=generator.nextInt(10000);
        Toast.makeText(getApplicationContext(),Integer.toString(correct_num),Toast.LENGTH_SHORT).show();
        input_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(input_text.getText().length()==4){
                    btn_check.setImageResource(R.drawable.btn_check_valid);
                    btn_check.setClickable(true);
                }
                else{
                    btn_check.setImageResource(R.drawable.btn_check_invalid);
                    btn_check.setClickable(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        btn_check.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                int guess_num;
                if(input_text.getText().toString()==""){
                    return;
                }
                guess_num=Integer.parseInt(input_text.getText().toString());

                if(guess_num==correct_num){
                    tip.setVisibility(View.INVISIBLE);
                    bingo.setVisibility(View.VISIBLE);
                    btn_check.setClickable(false);
                    btn_check.setVisibility(View.INVISIBLE);
                    btn_return.setClickable(true);
                    btn_return.setVisibility(View.VISIBLE);
                    btn_return.setImageResource(R.drawable.right_pic);
                }
                else if(guess_num>correct_num){
                    tip.setVisibility(View.INVISIBLE);
                    hint.setVisibility(View.VISIBLE);
                    arrow_up.setVisibility(View.VISIBLE);
                    arrow_down.setVisibility(View.VISIBLE);
                    arrow_up.setImageResource(R.drawable.arrow_up_gray);
                    arrow_down.setImageResource(R.drawable.arrow_down_red);
                    btn_check.setClickable(false);
                    btn_check.setVisibility(View.INVISIBLE);
                    btn_return.setClickable(true);
                    btn_return.setVisibility(View.VISIBLE);
                    btn_return.setImageResource(R.drawable.wrong_pic);
                    hint.setText("Too high!");
                }
                else{
                    tip.setVisibility(View.INVISIBLE);
                    hint.setVisibility(View.VISIBLE);
                    arrow_up.setVisibility(View.VISIBLE);
                    arrow_down.setVisibility(View.VISIBLE);
                    arrow_up.setImageResource(R.drawable.arrow_up_red);
                    arrow_down.setImageResource(R.drawable.arrow_down_gray);
                    btn_check.setClickable(false);
                    btn_check.setVisibility(View.INVISIBLE);
                    btn_return.setClickable(true);
                    btn_return.setVisibility(View.VISIBLE);
                    btn_return.setImageResource(R.drawable.wrong_pic);
                    hint.setText("Too low!");
                }
            }
        });
        btn_check.setClickable(false);
    }

    public void BTNCheck(View v){

    }

    public void BTNReturn(View v){
        tip.setVisibility(View.VISIBLE);
        bingo.setVisibility(View.INVISIBLE);
        hint.setVisibility(View.INVISIBLE);
        arrow_up.setVisibility(View.INVISIBLE);
        arrow_down.setVisibility(View.INVISIBLE);
        btn_check.setClickable(true);
        btn_check.setVisibility(View.VISIBLE);
        btn_return.setClickable(false);
        btn_return.setVisibility(View.INVISIBLE);
    }
}
