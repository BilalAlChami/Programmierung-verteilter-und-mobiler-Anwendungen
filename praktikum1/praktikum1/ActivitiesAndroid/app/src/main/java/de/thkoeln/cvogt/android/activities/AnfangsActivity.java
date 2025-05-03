package de.thkoeln.cvogt.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AnfangsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anfangs_activity);

        final Button Switch5 =  findViewById(R.id.switchActivity);  // ab API-Level 26 ist der Type Cast des Rückgabewerts von findViewById() nicht mehr nötig

        Switch5.setOnClickListener(new SwitchButtonListener5());

        Toast.makeText(this, "Activity 1: onCreate()", Toast.LENGTH_LONG).show();

        Log.v("DEMO", "      ---> Activity1: onCreate() <--- ");
        // Log.v("DEMO","Activity1: Intent.getComponent() = "+getIntent().getComponent());


        final Button Switch6 =  findViewById(R.id.switchActivity2);  // ab API-Level 26 ist der Type Cast des Rückgabewerts von findViewById() nicht mehr nötig

        Switch6.setOnClickListener(new SwitchButtonListener6());

        Toast.makeText(this, "Activity 2: onCreate()", Toast.LENGTH_LONG).show();

        Log.v("DEMO", "      ---> Activity2: onCreate() <--- ");
        // Log.v("DEMO","Activity2: Intent.getComponent() = "+getIntent().getComponent());

    }
    public void onStart() {
        super.onStart();
        Log.v("DEMO","      ---> Activity0: onStart() <--- ");
    }

    public void onResume() {
        super.onResume();
        Log.v("DEMO","      ---> Activity0: onResume() <--- ");
    }

    public void onPause() {
        super.onPause();
        Log.v("DEMO","      ---> Activity0: onPause() <--- ");
    }

    public void onStop() {
        super.onStop();
        Log.v("DEMO","      ---> Activity0: onStop() <--- ");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO","      ---> Activity0: onDestroy() <--- ");
    }

}
class SwitchButtonListener5 implements View.OnClickListener {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO","      ---> Activity1: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(),ActivitySamig.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        v.getContext().startActivity(myIntent);// Erzeugung und Aktivierung einer neuen Instanz der Klasse MainActivity
    }

}
class SwitchButtonListener6 implements View.OnClickListener {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO","---> Activity2: Click on Button <--- ");
        Intent myIntent2 = new Intent(v.getContext(), ActivityAlchami.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        v.getContext().startActivity(myIntent2);                             // Erzeugung und Aktivierung einer neuen Instanz der Klasse SecondActivity

    }

}
