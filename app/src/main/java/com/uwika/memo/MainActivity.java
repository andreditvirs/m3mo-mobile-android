package com.uwika.memo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech tts;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.txtInput);
        tts = new TextToSpeech(this, this);
        tts.setSpeechRate((float) 1.2);
        tts.setPitch((float) 1.8);
        tts.setLanguage(Locale.CHINA);
    }

    public void dengerin (View v)
    {
        Intent i  = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en US");
        try {
            input.setText("");
            startActivityForResult(i, 1);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void simpan1(View v){
        try {
            OutputStreamWriter o = new OutputStreamWriter(openFileOutput("output1.txt", 0));
            o.write(input.getText().toString());
            o.close();

            Toast.makeText(this, "Data Sudah Tersimpan di memo 1", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void simpan2(View v){
        try {
            OutputStreamWriter o = new OutputStreamWriter(openFileOutput("output2.txt", 0));
            o.write(input.getText().toString());
            o.close();

            Toast.makeText(this, "Data Sudah Tersimpan di memo 2", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void simpan3(View v){
        try {
            OutputStreamWriter o = new OutputStreamWriter(openFileOutput("output3.txt", 0));
            o.write(input.getText().toString());
            o.close();

            Toast.makeText(this, "Data Sudah Tersimpan di memo 3", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int RequestCode, int ResultCode, Intent data) {

        super.onActivityResult(ResultCode, RequestCode, data);
       switch (RequestCode)
        {
            case 1: {
                if (ResultCode == RESULT_OK && null != data) {
                    ArrayList<String> aa = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    input.setText(aa.get(0));
                }
                break;
            }
        }
    }

    @Override
    public void onInit(int i) {

    }
}