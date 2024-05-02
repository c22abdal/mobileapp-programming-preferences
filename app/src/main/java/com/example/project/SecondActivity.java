package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        editTxt = findViewById(R.id.editTxt);
        saveBtn = findViewById(R.id.saveBtn);

        sharedPreferences = getPreferences(MODE_PRIVATE);
        prefEditor = sharedPreferences.edit();
        setContentView(R.layout.activity_second);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefEditor.putString("Data", editTxt.getText().toString());
                prefEditor.apply();

                finish();
            }
        });
    }
}
