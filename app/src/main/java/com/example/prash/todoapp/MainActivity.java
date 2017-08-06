package com.example.prash.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readFile();

        listView = (ListView) findViewById(R.id.todo_list);
        //items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        listView.setAdapter(itemsAdapter);

        //--
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        items.remove(position);
                        itemsAdapter.notifyDataSetChanged();
                        writeFile();
                        return true;
                    }
                }
        );

        //--
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent editIntent = new Intent(MainActivity.this, EditActivity.class);
                        editIntent.putExtra("item", items.get(position));
                        editIntent.putExtra("position", position);
                        startActivityForResult(editIntent,101);
                    }
                }
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && data != null) {
            int pos = data.getIntExtra("position", items.size());
            String value = data.getStringExtra("item");

            items.set(pos, value); //--update item value with edited value
            writeFile();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    public void onAddItem(View view) {

        EditText inputText = (EditText) findViewById(R.id.inputTxt);
        String text = inputText.getText().toString();
        if(!text.isEmpty()) {
            itemsAdapter.add(text);
            inputText.setText(""); //reset
            writeFile();
        }

    }

    public void readFile() {

        File fileDir = getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));

        } catch (IOException e) {
            Log.i("-->MainActivity :: ", e.getMessage());

            items = new ArrayList<String>();
        }

    }

    public void writeFile() {
        File fileDir = getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");

        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
