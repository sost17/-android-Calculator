package com.col.commo.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

/**
 * Created by commo on 2017/3/26.
 */

public class Second_Activity extends Activity implements View.OnClickListener {

    private Button back,close;
    private TextView jia_one,jia,jia_two,jia_dengyu,jia_sum,jian_one,jian,jian_two,jian_dengyu,jian_sum,chen_one,chen,chen_two,chen_dengyu,chen_sum,chu_one,chu,chu_two,chu_dengyu,chu_sum;

    Double num1;
    Double num2;
    Double sum1,sum2,sum3,sum4;
    String Str_sum1,Str_sum2,Str_sum3,Str_sum4;
    char[] numcount = new char[]{'0'};
    String Strnum1,Strnum2,roun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        EyeApplicationManager.getInstance().addActivity(this);

        back = (Button) findViewById(R.id.back);
        close = (Button) findViewById(R.id.close);

        jia_one = (TextView) findViewById(R.id.jia_one);
        jia = (TextView) findViewById(R.id.jia);
        jia_two = (TextView) findViewById(R.id.jia_two);
        jia_dengyu = (TextView) findViewById(R.id.jia_dengyu);
        jia_sum = (TextView) findViewById(R.id.jia_sum);

        jian_one = (TextView) findViewById(R.id.jian_one);
        jian = (TextView) findViewById(R.id.jian);
        jian_two = (TextView) findViewById(R.id.jian_two);
        jian_dengyu = (TextView) findViewById(R.id.jian_dengyu);
        jian_sum = (TextView) findViewById(R.id.jian_sum);

        chu_one = (TextView) findViewById(R.id.chu_one);
        chu = (TextView) findViewById(R.id.chu);
        chu_two = (TextView) findViewById(R.id.chu_two);
        chu_dengyu = (TextView) findViewById(R.id.chu_dengyu);
        chu_sum = (TextView) findViewById(R.id.chu_sum);

        chen_one = (TextView) findViewById(R.id.chen_one);
        chen = (TextView) findViewById(R.id.chen);
        chen_two = (TextView) findViewById(R.id.chen_two);
        chen_dengyu = (TextView) findViewById(R.id.chen_dengyu);
        chen_sum = (TextView) findViewById(R.id.chen_sum);

        Intent getintent = getIntent();
        Strnum1 = getintent.getStringExtra("num1");
        Strnum2 = getintent.getStringExtra("num2");
        numcount = getintent.getCharArrayExtra("numcount");
        roun = getintent.getStringExtra("rou");
        num1 = Double.parseDouble(Strnum1);
        num2 = Double.parseDouble(Strnum2);

        sum1 = (num1+num2);
        sum2 = (num1-num2);
        sum3 = (num1*num2);
        sum4 = (num1*1.0/num2);

        if(roun.equals("1") == true){
            sum1 = Math.rint(sum1);
            sum2 = Math.rint(sum2);
            sum3 = Math.rint(sum3);
            sum4 = Math.rint(sum4);
        }

        Str_sum1 = String.valueOf(sum1);
        Str_sum2 = String.valueOf(sum2);
        Str_sum3 = String.valueOf(sum3);
        Str_sum4 = String.valueOf(sum4);



        for(int i = 0 ; i < 4 ; i ++){
            if(numcount[i] == '1'){
                jia_one.setText(Strnum1);
                jia.setText("+");
                jia_two.setText(Strnum2);
                jia_dengyu.setText("=");
                jia_sum.setText(Str_sum1);
            }else if(numcount[i] == '2'){
                jian_one.setText(Strnum1);
                jian.setText("-");
                jian_two.setText(Strnum2);
                jian_dengyu.setText("=");
                jian_sum.setText(Str_sum2);
            }else if(numcount[i] == '3'){
                chen_one.setText(Strnum1);
                chen.setText("x");
                chen_two.setText(Strnum2);
                chen_dengyu.setText("=");
                chen_sum.setText(Str_sum3);
            }else if(numcount[i] == '4'){
                chu_one.setText(Strnum1);
                chu.setText("÷");
                chu_two.setText(Strnum2);
                chu_dengyu.setText("=");
                chu_sum.setText(Str_sum4);
            }
        }

        back.setOnClickListener(this);
        close.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                Intent intent = new Intent();
                setResult(10,intent);
                finish();
                break;
            case R.id.close:
                EyeApplicationManager.getInstance().exit();
            default:
                EyeApplicationManager.getInstance().exit();

        }

    }
}
