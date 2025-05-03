package de.thk.vma.praktikum1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.activity0_title);

        final Button switchButton = (Button) findViewById(R.id.switchActivityMain);
        switchButton.setOnClickListener(new SwitchButtonListener());
        Toast.makeText(this,"SecondActivity: onCreate()", Toast.LENGTH_LONG).show(); // Kontrollausgabe durch 'Toast', Parameter 'this' bezieht sich auf die Activity]


    }
    public void onStart() {
        super.onStart();
        Log.v("DEMO","---> Activity 1: onStart() <--- ");
    }

    public void onResume() {
        super.onResume();
        Log.v("DEMO","---> Activity 1: onResume() <--- ");
    }

    public void onPause() {
        super.onPause();
        Log.v("DEMO","---> Activity 1: onPause() <--- ");
    }

    public void onStop() {
        super.onStop();
        Log.v("DEMO","---> Activity 1: onStop() <--- ");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO", "---> Activity 1: onDestroy() <--- ");
    }
}

class SwitchButtonListener implements View.OnClickListener {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO", "      ---> Activity2: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(), SecondActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        v.getContext().startActivity(myIntent);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse SecondActivity
    }
}