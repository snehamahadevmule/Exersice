package com.example.exersice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TToSpeech extends AppCompatActivity implements View.OnClickListener {

    Button speak,mute;
    TextToSpeech tts;

    String[] items_list = {
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start",
            "Let's Start"
    };
    String[] step, deep_step;

    int index;

    private static final String default_answer = "Start";

    // Variables & object of TTS
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tto_speech);
        speak = findViewById(R.id.speak);
        mute = findViewById(R.id.mute);
        speak.setOnClickListener((View.OnClickListener) this);
        mute.setOnClickListener((View.OnClickListener) this);
        index = 0;

        tts = new TextToSpeech(TToSpeech.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {

                    result = tts.setLanguage(Locale.US);

                } else {

                    Toast.makeText(getApplicationContext(),
                            "Feature not Supported in Your Device",
                            Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.speak:

                speak.setText(deep_step[index]);

                break;

                

                

            case R.id.mute:

                if (tts != null) {

                    tts.stop();

                }

                break;

        }

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (tts != null) {

            tts.stop();
            tts.shutdown();

        }
    }
}
