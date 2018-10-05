package com.example.rashed.agecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText year1,year2,month1,month2,day1,day2;
    public static int year11,year22,month11,month22,day11=0,day22,year,month,day;
    public static int []mont={31,28,31,30,31,30,31,31,30,31,30,31};
    Button submit,delete;
    TextView output,n,n1;
    String st,st1,st2,st3,st4,st5,sp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        submit.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    private void init() {
        year1=(EditText)findViewById(R.id.year1);
        year2=(EditText)findViewById(R.id.year2);
        month1=(EditText)findViewById(R.id.month1);
        month2=(EditText)findViewById(R.id.month2);
        day1=(EditText) findViewById(R.id.day1);
        day2=(EditText)findViewById(R.id.day2);
        submit=(Button)findViewById(R.id.submit);
        delete=(Button)findViewById(R.id.delete);
        output=(TextView)findViewById(R.id.output);
        n=(TextView)findViewById(R.id.init);
        n1=(TextView)findViewById(R.id.init1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit:
                /*st=day1.getText().toString();
                day11=Integer.parseInt(st);
               double num=Double.parseDouble(st);
                similar();*/
                agecalculate();
                output.setText(""+sp);
                break;
            case R.id.delete:

                break;
        }
    }

    private void similar() {

    }

    private void agecalculate() {
        st=day1.getText().toString();
         day11=Integer.parseInt(st);
         st1=day2.getText().toString();
         day22=Integer.parseInt(st1);
         st2=month1.getText().toString();
         month11=Integer.parseInt(st2);
         st3=month2.getText().toString();
         month22=Integer.parseInt(st3);
         st4=year1.getText().toString();
         year11=Integer.parseInt(st4);
         st5=year2.getText().toString();
         year22=Integer.parseInt(st5);
         if(day11<day22){
             if((year11%4==0 || year11%400==0)&&month11==2){
                 day11+=29;
             }
             else {
                 day11+=mont[month11-1];
             }
             day=day11-day22;
             month22++;
         }
         else {
             day=day11-day22;
             sp=""+day;
         }
         if(month11<month22){
             month11+=12;
             month=month11-month22;
             year22++;
         }
         else{
             month=month11-month22;
         }
         if(year22>year11){
             sp="Invalid user input";
         }
         else{
             year=year11-year22;
             sp="age: "+year+" month: "+month+" day: "+day;
         }


    }
}
