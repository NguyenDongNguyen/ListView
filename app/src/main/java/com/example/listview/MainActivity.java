package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    Button btnThem, btnCapNhat, btnXoa;
    EditText edtMonHoc;
    ArrayList<String> array;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnCapNhat = (Button) findViewById(R.id.buttonCapNhat);
        edtMonHoc = (EditText) findViewById(R.id.editTextMonHoc);
        btnXoa = (Button) findViewById(R.id.buttonXoa);
        array = new ArrayList<>();

        array.add("PHP");
        array.add("java");
        array.add("Python");
        array.add("NodeJS");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,
                array);

        lvMonHoc.setAdapter(adapter);

         btnThem.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String monhoc = edtMonHoc.getText().toString();
                 array.add(monhoc);
                 adapter.notifyDataSetChanged();
             }
         });

         lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 edtMonHoc.setText(array.get(i));
                 vitri = i;
             }
         });

         btnCapNhat.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 array.set(vitri, edtMonHoc.getText().toString());
                 adapter.notifyDataSetChanged();
             }
         });

         btnXoa.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 array.remove(vitri);
                 adapter.notifyDataSetChanged();

             }
         });

         lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
             @Override
             public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                 intent.putExtra("monhoc",array.get(i));
                 startActivity(intent);
                 return false;
             };
         });
    }
}