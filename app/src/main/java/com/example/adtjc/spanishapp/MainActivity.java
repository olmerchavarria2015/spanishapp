package com.example.adtjc.spanishapp;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {
    TextView t1;
    TextView t2;
    EditText n2;
    Map <String ,String> traductor;
    MediaPlayer EnTono;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Spanish Tutor");
        setSupportActionBar(toolbar);
        traductor= new HashMap <String ,String>();





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Typeface CustomFont = Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");
        t1 = (TextView)findViewById(R.id.textView);
        t1.setTypeface(CustomFont);
        t2 = (TextView)findViewById(R.id.textView2);
        n2 = (EditText)findViewById(R.id.editText3);
        traductor= new HashMap <String ,String>();
        traductor.put("corazon","heart");
        traductor.put("zapato", "shoe");
        traductor.put("cama","bed");



    }
    public void SonidoPlay(View V){
        EnTono = MediaPlayer.create(this,R.raw.bells);
        EnTono.start();




        //EnTono.release();
    }
    public void ButtonClicked(View v){
        String num2 = n2.getText().toString().trim();
        String count = String.valueOf(num2.length());

        if (traductor.get(num2)!=null){
            t1.setText(num2 +" = "+(traductor.get(num2)));
            t2.setText(count);


        }
        else {

            t1.setText(num2 +" is not in database");

        }

    }
    public String wordProcessor(String str){

        for(int i=1;i <= str.length();i++){
            if (str.substring(i).equals(" ")){

               str = str.replace(str.substring(i),"");
           }

        }

        return str;
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
