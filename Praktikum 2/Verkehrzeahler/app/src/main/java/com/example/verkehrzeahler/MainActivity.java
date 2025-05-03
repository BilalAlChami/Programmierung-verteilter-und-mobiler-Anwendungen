package com.example.verkehrzeahler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.verkehrzhler.R;

public class MainActivity extends Activity {

    private int fußgeangerCount = 0;
    private int radfahrerCount = 0;

    private TextView tvfußgeangerCount;
    private TextView tvradfahrerCount;
    private TextView tvTotalCount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvfußgeangerCount = findViewById(R.id.tv_fußgeanger_count);
        tvradfahrerCount = findViewById(R.id.tv_radfahrer_count);
        tvTotalCount = findViewById(R.id.tv_total_count);
    }

    public void Fußgeanger(View view) {
        fußgeangerCount++;
        updateCounts();
    }

    public void Radfahrer(View view) {
        radfahrerCount++;
        updateCounts();
    }

    public void resetCounts(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Reset counts?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        fußgeangerCount = 0;
                        radfahrerCount = 0;
                        updateCounts();
                        Toast.makeText(getApplicationContext(), "Counters reset", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "Counters NOT reset", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void updateCounts() {
        tvfußgeangerCount.setText(String.valueOf(fußgeangerCount));
        tvradfahrerCount.setText(String.valueOf(radfahrerCount));
        int totalCount = fußgeangerCount + radfahrerCount;
        tvTotalCount.setText(String.valueOf(totalCount));
    }
}