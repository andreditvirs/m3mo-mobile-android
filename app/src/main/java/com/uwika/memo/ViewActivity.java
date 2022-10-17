package com.uwika.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

public class ViewActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    TextToSpeech tts;
    TextView memo1, memo2, memo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        memo1 = findViewById(R.id.txtV_memo1);
        memo2 = findViewById(R.id.txtV_memo2);
        memo3 = findViewById(R.id.txtV_memo3);

        tts = new TextToSpeech(this, this);
        tts.setSpeechRate((float) 1.2);
        tts.setPitch((float) 1.8);
        tts.setLanguage(Locale.CHINA);

        load(memo1, "output1.txt", 1);
        load(memo2, "output2.txt", 2);
        load(memo3, "output3.txt", 3);
    }

    public void load(TextView memo, String filename, int number){
        String temp;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStreamReader is = new InputStreamReader(openFileInput(filename));
            BufferedReader br = new BufferedReader(is);
            while((temp=br.readLine()) != null){
                stringBuilder.append(temp + "\n");
            }
            is.close();
            memo.setText(stringBuilder.toString());
        }catch(Exception e){
            memo.setText("[ Memo "+number+" Kosong ]");
            e.printStackTrace();
        }
    }

    public void speakMemo1(View v){
        String text = memo1.getText().toString();
        if(text == "[ Memo 1 Kosong ]"){
            Toast.makeText(this, "Memo Kosong", Toast.LENGTH_SHORT).show();
        }else{
            speak(text);
        }
    }

    public void speakMemo2(View v){
        String text = memo2.getText().toString();
        if(text == "[ Memo 2 Kosong ]"){
            Toast.makeText(this, "Memo Kosong", Toast.LENGTH_SHORT).show();
        }else{
            speak(text);
        }
    }

    public void speakMemo3(View v){
        String text = memo3.getText().toString();
        if(text == "[ Memo 3 Kosong ]"){
            Toast.makeText(this, "Memo Kosong", Toast.LENGTH_SHORT).show();
        }else{
            speak(text);
        }
    }

    public void speak(String text){
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int i) {

    }
}