package com.example.emmanuel.aplicacion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emmanuel.aplicacion.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button miBoton= (Button) findViewById(R.id.Boton);
        final TextView texto = (TextView) findViewById(R.id.etiqueta);
        final EditText campo = (EditText) findViewById(R.id.campo);
        Button NuevaVentana = (Button) findViewById(R.id.NextWin);
        final TextView textoN = (TextView) findViewById(R.id.TextoNuevo);
        final Button Tabs =(Button)findViewById(R.id.ViewPager);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Qué onda", Toast.LENGTH_SHORT).show();
                texto.setText(campo.getText().toString());

            }
        });

        Tabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tab=new Intent(MainActivity.this, SectionsActivity.class);
                startActivity(tab);
            }
        });


        NuevaVentana.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                                                intent.putExtra("parametro",campo.getText().toString());
                                                startActivity(intent);
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

        Log.d("MainActivity", "Mi primera app!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
