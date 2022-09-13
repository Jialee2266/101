package com.example.smarthome;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.VideoView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> fileList = new ArrayList<>();
        Field[] fields=R.raw.class.getFields();
        for(Field i : fields) {
            fileList.add(i.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, fileList);
        AutoCompleteTextView dropdownMenu = findViewById(R.id.dropdown_menu);

        dropdownMenu.setAdapter(adapter);
        dropdownMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = fileList.get(i);
                Intent intent = new Intent(MainActivity.this, VideoPlayer.class);
                intent.putExtra("key", value);
                startActivity(intent);

            }
        });




    }
}