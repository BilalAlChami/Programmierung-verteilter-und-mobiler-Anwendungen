package de.thk.vma.praktikum1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;



/*Antwort auf die Frage: Dreht man das Smartphone wird onSaveInstnceState() aufgerufen und der Zustand gespeichert.
 Nach einem back werden onPause(), onStop() und onDestroy aufgerufen und die Activity gelöscht.


Der Text wird nicht gespeichert, da onSaveInstanceState() nicht aufgerufen wird, um den Zustand der Instanz zu speichern.

 "Verlassen der App mit dem Back-Button – Das Android System wertet diese Situation als endgültiges Verlassen der Anwendung.
 Daher wird die onSaveInstanceState () Methode nicht aufgerufen und somit der Activity-Zustand nicht gespeichert.
 Die Activity-Instanz geht dabei für immer verloren. "

Quelle: https://www.programmierenlernenhq.de/tutorial-android-activity-zustand-speichern-wiederherstellen/#:~:text=Verlassen%20der%20App%20mit%20dem%20Back-Button%20%E2%80%93%20Das,gespeichert.%20Die%20Activity-Instanz%20geht%20dabei%20f%C3%BCr%20immer%20verloren.

Abschnitt: 1.3.1 Situationen in denen die Activity vom Android System zerstört wird
 */



public class SecondActivity extends AppCompatActivity {
    private EditText ausgabe;
    private String eingabe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle(R.string.activity1_title);

        if (savedInstanceState!=null)
            eingabe = savedInstanceState.getString("eingabe");
        ausgabe = (EditText) findViewById(R.id.editText);
        ausgabe.setText(eingabe);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO","---> SecondActivity : onDestroy() <--- ");
        Toast.makeText(this, "SecondActivity : onDestroy()", Toast.LENGTH_LONG).show();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("Eingabe",eingabe);
        Log.v("DEMO","---> onSaveInstanceState() <--- ");
        Toast.makeText(this, "SecondActivity: onSaveInstanceState()", Toast.LENGTH_LONG).show();
    }
}