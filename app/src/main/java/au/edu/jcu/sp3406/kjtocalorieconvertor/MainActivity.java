package au.edu.jcu.sp3406.kjtocalorieconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final  double calories = 0.239005736;
    public double conversion = 0;
    private String userInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conversion = calories;
    }

    public void buttonClicked(View view){
        Button button = (Button) view;
        String buttonNumber = button.getText().toString();
        userInput = userInput + buttonNumber;
        TextView textView = findViewById(R.id.text);
        textView.setText(userInput);
    }

    public void settingsClicked(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, SettingsActivity.SETTINGS_REQUEST);
    }

    public void buttonClear(View view){
        TextView textView = findViewById(R.id.text);
        textView.setText("");
        userInput = "";
    }

    public void buttonConvert(View view){
        TextView textView = findViewById(R.id.text);
        int userInputInt = Integer.parseInt(userInput);
        int result = (int) (userInputInt * conversion);
        String showResult = "" + result;
        textView.setText(showResult);
    }
}