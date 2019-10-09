package com.example.exersice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    Button speak;

    String[] step, deep_step;

    int index;

    private static final String default_answer = "Press \"A\" Button for the Answer";

    // Variables & object of TTS
    TextToSpeech ttsobject;
    int result;
    
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CustomClass> items = new ArrayList<>();
        items.add(new CustomClass("First","Diaphragm Breathing",R.drawable.img1));
        items.add(new CustomClass("Second","Stomach Breathing",R.drawable.img2));
        items.add(new CustomClass("Third","Balloon Breathing",R.drawable.img3));
        items.add(new CustomClass("Forth","Ribcage Breathing",R.drawable.img4));
        items.add(new CustomClass("Fifth","Body Scan",R.drawable.img5));
        items.add(new CustomClass("Sixth","Retreat Breathing ",R.drawable.img6));
        items.add(new CustomClass("Seventh","Grounding Self",R.drawable.img7));
        items.add(new CustomClass("Eighth","Cleansing Sanctuary",R.drawable.img8));
        items.add(new CustomClass("Ninth","Mountain Meditation",R.drawable.img9));
        items.add(new CustomClass("Tenth","Comparing Emotion",R.drawable.img10));
        items.add(new CustomClass("Eleventh","Letting Your Thoughts Go!",R.drawable.img11));
        items.add(new CustomClass("Twelth","Forgiveness Meditation",R.drawable.img12));
        items.add(new CustomClass("Thirteenth","Mindful Eating",R.drawable.img13));
        items.add(new CustomClass("Forteenth","Overcoming Craving",R.drawable.img14));
        items.add(new CustomClass("Fifteenth","Mindful Smiling ",R.drawable.img15));
        items.add(new CustomClass("Sixteenth","Mindful Reflective Listening",R.drawable.img16));
        items.add(new CustomClass("Seventeenth","Having patience ",R.drawable.img17));
        items.add(new CustomClass("Eighteenth","Just Worrying Labelling Technique",R.drawable.img18));


        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,items);

        ListView listView = findViewById(R.id.list_views);

        listView.setDivider(null);
        listView.setAdapter(customAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.second_activity);
                TextView text = dialog.findViewById(R.id.alert_text_view);
                Button hide = dialog.findViewById(R.id.hide_btn);
                hide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        

                    }
                });


                text.setText(items_list[position]);

                dialog.show();

                

                hide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(MainActivity.this, TToSpeech.class);
                        startActivity(i);
                    }
                });      
            }
        });


    }
}
