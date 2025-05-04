package com.example.wetter_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private CheckBox regen;
    private CheckBox wind;
    private int regencount=0;
    private int windcount =0;
    private int eingabe=0;
    private double sum=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        regen = (CheckBox) findViewById(R.id.regen);
        wind = (CheckBox) findViewById(R.id.wind);
        final Button button = (Button) findViewById(R.id.Eingabe);
           button.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                   anzeige ();
                   int  n1= Integer. parseInt (editText1.getText ().toString());
                       if (n1<4){
                       Toast.makeText(MainActivity.this,"Vorsicht vor Glätte!", Toast.LENGTH_LONG).show();
                       }
                   erhoeheEingabe();
                   Durchschnitt();
               }
           }
        );
        final Button button2 = (Button) findViewById(R.id.Reset);
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    reset ();
                }
            }
        );


    }

    public void anzeige () {
        if (regen.isChecked() && wind.isChecked()){
            editText2.setText(editText1.getText()+" Grad "+" Regen, Wind ");
            regencount++;
            windcount++;
            editText5.setText(""+regencount);
            editText6.setText(""+windcount);
        }
        else if (regen.isChecked()){
            editText2.setText(editText1.getText()+" Grad "+" Regen, kein Wind ");
            regencount++;
            editText5.setText(""+regencount);
        }
        else if (wind.isChecked()){
            editText2.setText(editText1.getText()+" Grad "+"kein Regen, Wind ");
            windcount++;
            editText6.setText(""+windcount);
        }
        else
            editText2.setText(editText1.getText()+" Grad "+"kein Regen, kein Wind ");
    }

    public void erhoeheEingabe (){
        eingabe++;
        editText3.setText("" + eingabe);
    }

    public void Durchschnitt (){
        double durchschnitt =0;
        double  n= Double.parseDouble (editText1.getText ().toString());
        sum=n+sum;
        if (eingabe>0){
            durchschnitt=sum/eingabe;}
        else
            durchschnitt=sum;
            editText4.setText(""+durchschnitt);
    }
    public void reset (){
        editText1.setText("");
        eingabe=0;
        editText2.setText("");
        sum=0;
        editText3.setText("");
        regencount=0;
        editText4.setText("");
        windcount =0;
        editText5.setText("");
        editText6.setText("");
        regen.setChecked(false);
        wind.setChecked(false);
    }
}

