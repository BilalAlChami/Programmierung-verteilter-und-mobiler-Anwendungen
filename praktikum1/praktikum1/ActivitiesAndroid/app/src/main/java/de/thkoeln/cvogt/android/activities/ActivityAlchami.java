// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// www.nt.th-koeln.de/vogt/

// Eine App mit zwei Activities, zwischen denen man hin- und herschalten kann.
// LogCat-Ausgaben zeigen dabei an, wann welche Zustandsübergangsmethoden (Callbacks) ausgeführt werden.
// Stand: 4.12.2015

// Video dazu: https://youtu.be/Zwswz3UmvOc

package de.thkoeln.cvogt.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/* Diese zweite Aktivität muss ggf. per Hand im Manifest eingetragen werden.
   Sie wird dort automatisch eingetragen, wenn im Project-Unterfenster auf 'java'
   rechts-klickt und dann den Menus "New > Activity > ..." folgt. */

public class ActivityAlchami extends Activity {
        
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        final Button switchButton = (Button) findViewById(R.id.switchActivity);  // ab API-Level 26 ist der Type Cast des Rückgabewerts von findViewById() nicht mehr nötig

        switchButton.setOnClickListener(new SwitchButtonListener2());

        Toast.makeText(this,"Activity 2: onCreate()", Toast.LENGTH_LONG).show();
        
        Log.v("DEMO","      ---> Activity 2: onCreate() <--- ");
        // Log.v("DEMO","Activity2: Intent.getComponent() = "+getIntent().getComponent());


        final Button switchButton2 = (Button) findViewById(R.id.switchActivity2);  // ab API-Level 26 ist der Type Cast des Rückgabewerts von findViewById() nicht mehr nötig

        switchButton2.setOnClickListener(new SwitchButtonListener4());

        Toast.makeText(this,"Activity 0: onCreate()", Toast.LENGTH_LONG).show();

        Log.v("DEMO","      ---> Activity0: onCreate() <--- ");
        // Log.v("DEMO","Activity0: Intent.getComponent() = "+getIntent().getComponent());
    }

    public void onStart() {
        super.onStart();
        Log.v("DEMO","      ---> Activity2: onStart() <--- ");
    }        

    public void onResume() {
        super.onResume();
        Log.v("DEMO","      ---> Activity2: onResume() <--- ");
    }        

    public void onPause() {
        super.onPause();
        Log.v("DEMO","      ---> Activity2: onPause() <--- ");
    }        

    public void onStop() {
        super.onStop();
        Log.v("DEMO","      ---> Activity2: onStop() <--- ");
    }        

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO","      ---> Activity2: onDestroy() <--- ");
    }       

}

class SwitchButtonListener2 implements OnClickListener  {   // Listener des Buttons
        
        public void onClick(View v) {
        Log.v("DEMO","      ---> Activity2: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(),ActivitySamig.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        v.getContext().startActivity(myIntent);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse MainActivity
        }
        
}
class SwitchButtonListener4 implements OnClickListener  {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO","      ---> Activity 0: Click on Button <--- ");
        Intent myIntent2 = new Intent(v.getContext(),AnfangsActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        myIntent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        v.getContext().startActivity(myIntent2);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse MainActivity
    }

}