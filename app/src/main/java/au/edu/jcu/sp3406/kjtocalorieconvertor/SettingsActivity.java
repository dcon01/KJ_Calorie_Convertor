package au.edu.jcu.sp3406.kjtocalorieconvertor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity {

    public static final int SETTINGS_REQUEST = 1;
    public boolean multiply;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//create text view on create
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        text = findViewById(R.id.text);
    }

    @SuppressLint("SetTextI18n") //Not sure why I need to do this?
    public void buttonCalories(View view){//set to convert KC to KJ
        multiply = true;
        text.setText("Calories");
        //text.setText(cal.toString()); test to see if this works with out the SuppressLint("SetTextI18n")
    }

    @SuppressLint("SetTextI18n") //Not sure why I need to do this?
    public void buttonKilojoules(View view){//set to convert KJ to KC
        multiply = false;
        text.setText("KiloJoules");
    }

    public void doneClicked(View view) { //pass on KC or KJ selection to main activity
        Intent intent = new Intent();
        intent.putExtra("multiply", multiply);
        setResult(RESULT_OK, intent);
        finish();
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        doneClicked(null);
    }
}