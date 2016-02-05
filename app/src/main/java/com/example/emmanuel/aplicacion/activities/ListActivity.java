package com.example.emmanuel.aplicacion.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emmanuel.aplicacion.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView Texto = (TextView) findViewById(R.id.TextoNuevo);
        final ListView Lista = (ListView) findViewById(R.id.lista);
        Button Boton = (Button) findViewById(R.id.Boton1);
        final EditText Campo = (EditText) findViewById(R.id.CampoDeText);

        final ArrayList<String> arrayList = new ArrayList<>();
        final ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, R.layout.custom_layout, arrayList);


        Bundle bundle = getIntent().getExtras();
        Lista.setAdapter(adapter);
        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(Campo.getText().toString());
                adapter.notifyDataSetChanged();
                Campo.setText(" ");
            }
        });
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Item "+Lista.getItemAtPosition(position).toString()+" presionado",
                        Toast.LENGTH_SHORT).show();

            }
        });


                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
