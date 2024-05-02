package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {
    EditText editTxt;
    Button saveBtn;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTxt = findViewById(R.id.editTxt);
        saveBtn = findViewById(R.id.saveBtn);
        final TextView confTxt = findViewById(R.id.textView2);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        //prefEditor = sharedPreferences.edit();
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefEditor = sharedPreferences.edit();
                prefEditor.putString("Data", editTxt.getText().toString());
                prefEditor.apply();
                confTxt.setText("Saved data!");
                finish();
            }
        });
    }
}
