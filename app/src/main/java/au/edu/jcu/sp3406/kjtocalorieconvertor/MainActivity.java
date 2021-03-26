package au.edu.jcu.sp3406.kjtocalorieconvertor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean multiply = true; // sets to default convert to KC from KJ
    private String userInput = "";
    final double unit = 4.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) { // when a number button is clicked collect text and add it to view
        Button button = (Button) view;
        String buttonNumber = button.getText().toString();
        userInput = userInput + buttonNumber;
        TextView textView = findViewById(R.id.text);
        textView.setText(userInput);
    }

    public void settingsClicked(View view) { // call settingsActivity
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, SettingsActivity.SETTINGS_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // collect data passed from settings activity
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SettingsActivity.SETTINGS_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    multiply = data.getBooleanExtra("multiply", multiply);
                }
            }
        }
    }

    public void buttonClear(View view) { // clear view
        TextView textView = findViewById(R.id.text);
        textView.setText("");
        userInput = "";
    }

    //err - convert button will only work once - then I need to clear it to make it work again?
    public void buttonConvert(View view) { //takes user input and will either convert to KC or KG depending on user setting option - default is KC
        TextView textView = findViewById(R.id.text);
        int userInputInt = Integer.parseInt(userInput);
        int result;
        if (multiply) {
            result = (int) (userInputInt * unit);
        } else {
            result = (int) (userInputInt / unit);
        }
        String showResult = "" + result;
        textView.setText(showResult);
        Toast.makeText(this, "Converted!", Toast.LENGTH_SHORT).show();
    }
}