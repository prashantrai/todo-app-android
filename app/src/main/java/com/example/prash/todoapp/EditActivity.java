package com.example.prash.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by prash on 9/30/16.
 */


public class EditActivity extends AppCompatActivity {

    EditText editText;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_edit);
        String item = getIntent().getStringExtra("item");
        pos = getIntent().getIntExtra("position", 0);

        editText = (EditText) findViewById(R.id.editTxt);
        editText.setText(item);
    }

    public void onSave(View view) {

        Intent editIntent = new Intent();
        editIntent.putExtra("item", editText.getText().toString());
        editIntent.putExtra("position", pos);

        setResult(101, editIntent);

        finish();

    }
}
