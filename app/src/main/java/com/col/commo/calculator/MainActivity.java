package com.col.commo.calculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.System.exit;

public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private EditText num1,num2;
    private CheckBox B_jia,B_jian,B_chen,B_chu;
    private RadioButton round;
    private Button Calculator,close;
    private TextView textNull,jia_one,T_jia,jia_two,jian_one, T_jian,jian_two,chen_one,T_chen,chen_two,chu_one,T_chu,chu_two;
    int flag = -1;
    char[] num = new char[]{'0','0','0','0'};
    String rounds = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        EyeApplicationManager.getInstance().addActivity(this);

        num1 = (EditText) findViewById(R.id.ed_one);
        num2 = (EditText) findViewById(R.id.ed_two);

        num1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        num2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        B_jia = (CheckBox) findViewById(R.id.jia_bt);
        B_jian = (CheckBox) findViewById(R.id.jian_bt);
        B_chen = (CheckBox) findViewById(R.id.chen_bt);
        B_chu = (CheckBox) findViewById(R.id.chu_bt);
        round = (RadioButton) findViewById(R.id.round);
        textNull = (TextView) findViewById(R.id.e7);

        jia_one = (TextView) findViewById(R.id.jia_one);
        T_jia = (TextView) findViewById(R.id.jia);
        jia_two = (TextView) findViewById(R.id.jia_two);

        jian_one = (TextView) findViewById(R.id.jian_one);
        T_jian = (TextView) findViewById(R.id.jian);
        jian_two = (TextView) findViewById(R.id.jian_two);

        chen_one = (TextView) findViewById(R.id.chen_one);
        T_chen = (TextView) findViewById(R.id.chen);
        chen_two = (TextView) findViewById(R.id.chen_two);

        chu_one = (TextView) findViewById(R.id.chu_one);
        T_chu = (TextView) findViewById(R.id.chu);
        chu_two = (TextView) findViewById(R.id.chu_two);

        Calculator = (Button) findViewById(R.id.jisuan);
        close = (Button) findViewById(R.id.close);

        B_jia.setOnCheckedChangeListener(this);
        B_jian.setOnCheckedChangeListener(this);
        B_chen.setOnCheckedChangeListener(this);
        B_chu.setOnCheckedChangeListener(this);

        Calculator.setOnClickListener(this);
        close.setOnClickListener(this);

        round.setOnCheckedChangeListener(this);

    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String Str_num1 = num1.getText().toString();
        String Str_num2 = num2.getText().toString();

        if(Str_num1.equals("") == false && Str_num2.equals("") == false){
            textNull.setText("");
            switch (buttonView.getId()){
                case R.id.round:
                    if (isChecked) {
                        rounds = "1";
                    }
                    break;
                case R.id.jia_bt:
                    if(isChecked){
                        jia_one.setText(Str_num1);
                        T_jia.setText("+");
                        jia_two.setText(Str_num2);
                        num[0]='1';
                    }else {
                        jia_one.setText("");
                        T_jia.setText("");
                        jia_two.setText("");
                    }
                    break;
                case R.id.jian_bt:
                    if(isChecked){
                        jian_one.setText(Str_num1);
                        T_jian.setText("-");
                        jian_two.setText(Str_num2);
                        num[1]='2';
                    }else {
                        jian_one.setText("");
                        T_jian.setText("");
                        jian_two.setText("");
                    }
                    break;
                case R.id.chen_bt:
                    if(isChecked){
                        chen_one.setText(Str_num1);
                        T_chen.setText("x");
                        chen_two.setText(Str_num2);
                        num[2]='3';
                    }else {
                        chen_one.setText("");
                        T_chen.setText("");
                        chen_two.setText("");
                    }
                    break;
                case R.id.chu_bt:
                    if(isChecked){
                        chu_one.setText(Str_num1);
                        T_chu.setText("÷");
                        chu_two.setText(Str_num2);
                        num[3]='4';
                    }else {
                        chu_one.setText("");
                        T_chu.setText("");
                        chu_two.setText("");
                    }
                    break;
                default:
                    exit(0);
            }
        }else {
            if(flag != 0){
                textNull.setText("参数去哪了？？？");
            }

            B_jia.setChecked(false);
            B_jian.setChecked(false);
            B_chen.setChecked(false);
            B_chu.setChecked(false);
            round.setChecked(false);
            flag = -1;
        }


    }



    public void onClick(View v) {
        String Str_num1 = num1.getText().toString();
        String Str_num2 = num2.getText().toString();

        Intent intent = new Intent(MainActivity.this,Second_Activity.class);

        switch (v.getId()){
            case R.id.jisuan:
                int i ,a = 0;
                for (i = 0 ; i < 4 ; i ++){
                    if(num[i] != '0'){
                        a += 1;
                    }
                }

                if(Str_num1.equals("") == false && Str_num2.equals("") == false && a >= 1 && a <= 4){
                    intent.putExtra("num1",Str_num1);
                    intent.putExtra("num2",Str_num2);
                    intent.putExtra("rou",rounds);
                    intent.putExtra("numcount",num);
                    startActivityForResult(intent,1);
                }else if(a ==0){
                    textNull.setText("有运算法则，我才能计算！！！");
                }else {
                    textNull.setText("输入参数，我才能计算！！！");
                }
                break;
            case R.id.close:
                EyeApplicationManager.getInstance().exit();
                break;
            default:
                EyeApplicationManager.getInstance().exit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 10) {
            num1.setText("");
            num2.setText("");
            flag = 0;
            jia_one.setText("");
            T_jia.setText("");
            jia_two.setText("");
            jian_one.setText("");
            T_jian.setText("");
            jian_two.setText("");
            chen_one.setText("");
            T_chen.setText("");
            chen_two.setText("");
            chu_one.setText("");
            T_chu.setText("");
            chu_two.setText("");
            B_jia.setChecked(false);
            B_jian.setChecked(false);
            B_chen.setChecked(false);
            B_chu.setChecked(false);
            round.setChecked(false);
            rounds = "0";
        }else {
            textNull.setText("按我的返回键，我才给你清空数据！！！>_<");

        }
    }
}
