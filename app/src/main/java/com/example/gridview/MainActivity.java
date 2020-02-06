package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] numberworld = {"banana","coconut","grapes","pear","pineapple","orange","strawberry","watermelon",};
    int[] numberImage = {R.drawable.banana,R.drawable.coconut,R.drawable.grapes,R.drawable.pear,R.drawable.pineapple,R.drawable.orange,R.drawable.strawberry,R.drawable.watermelon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.grid_view);

        MainAdapter adapter = new MainAdapter(MainActivity.this,numberworld,numberImage);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You Clicked"+numberworld[+position],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                intent.putExtra("name",numberworld[position]);
                intent.putExtra("image",numberImage[position]);
                startActivity(intent);
            }
        });
    }
}
