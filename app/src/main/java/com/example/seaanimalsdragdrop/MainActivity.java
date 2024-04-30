package com.example.seaanimalsdragdrop;

import static com.example.seaanimalsdragdrop.R.color.red;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import com.example.seaanimalsdragdrop.models.colourSources;
import com.example.seaanimalsdragdrop.models.seaAnimals;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bubble,answerMatch;
    ImageView sea_animal_outline_1,sea_animal_fill_1,sea_animal_eyes_1;
    ImageView sea_animal_outline_2,sea_animal_fill_2,sea_animal_eyes_2;
    ImageView sea_animal_outline_3,sea_animal_fill_3,sea_animal_eyes_3;

    ArrayList<seaAnimals> sas;

    ArrayList<colourSources> cs;

    seaAnimals answerMatchAnimal;

    String msg = "TESTING";
    int userMatched = 0;
    int userMatch3Outlines=0;
    int Games = 1;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning the resource IDs and the Bubble
        init();

        //Make the Colour List
        assignColourList();

        //Make the Sea Animals List
        assignSeaAnimalList();

       start(Games);


    }// OnCreate ends

    public void start(int i){
        init();
        Collections.shuffle(cs);
        Collections.shuffle(sas);
        setAnswerMatch(0,sas.get(0));
        initialStates(0);
        OnClickBubble(0);
        userMatched = 0;
    }



    public void init(){

        bubble = findViewById(R.id.sea_animal_bubble);
        answerMatch = findViewById(R.id.sea_animal_match);

        sea_animal_outline_1 = findViewById(R.id.sea_animal_1_a);
        sea_animal_fill_1 = findViewById(R.id.sea_animal_1_b);
        sea_animal_eyes_1 = findViewById(R.id.sea_animal_1_c);
        sea_animal_outline_2 = findViewById(R.id.sea_animal_2_a);
        sea_animal_fill_2 = findViewById(R.id.sea_animal_2_b);
        sea_animal_eyes_2 = findViewById(R.id.sea_animal_2_c);
        sea_animal_outline_3 = findViewById(R.id.sea_animal_3_a);
        sea_animal_fill_3 = findViewById(R.id.sea_animal_3_b);
        sea_animal_eyes_3 = findViewById(R.id.sea_animal_3_c);

        bubble.setVisibility(View.VISIBLE);

        sea_animal_outline_1.setVisibility(View.INVISIBLE);
           sea_animal_fill_1.setVisibility(View.INVISIBLE);
           sea_animal_eyes_1.setVisibility(View.INVISIBLE);
        sea_animal_outline_2.setVisibility(View.INVISIBLE);
           sea_animal_fill_2.setVisibility(View.INVISIBLE);
           sea_animal_eyes_2.setVisibility(View.INVISIBLE);
        sea_animal_outline_3.setVisibility(View.INVISIBLE);
           sea_animal_fill_3.setVisibility(View.INVISIBLE);
           sea_animal_eyes_3.setVisibility(View.INVISIBLE);
    }

    public void assignColourList(){

        cs = new ArrayList<>();

        cs.add(new colourSources(red));
        cs.add(new colourSources(R.color.blue));
        cs.add(new colourSources(R.color.purple));
        cs.add(new colourSources(R.color.green));
        cs.add(new colourSources(R.color.yellow));
        cs.add(new colourSources(R.color.orange));
        cs.add(new colourSources(R.color.gold));
        cs.add(new colourSources(R.color.pink));
        cs.add(new colourSources(R.color.violet));

    }

    public void assignSeaAnimalList(){

        sas = new ArrayList<>();
        sas.add(new seaAnimals(1,R.drawable.sa_1_a,R.drawable.sa_1_b,R.drawable.sa_1_c,cs.get(0).getColor_source(),false));
        sas.add(new seaAnimals(2,R.drawable.sa_2_a,R.drawable.sa_2_b,R.drawable.sa_2_c,cs.get(1).getColor_source(),false));
        sas.add(new seaAnimals(3,R.drawable.sa_3_a,R.drawable.sa_3_b,R.drawable.sa_3_c,cs.get(2).getColor_source(),false));
        sas.add(new seaAnimals(4,R.drawable.sa_4_a,R.drawable.sa_4_b,R.drawable.sa_4_c,cs.get(3).getColor_source(),false));
        sas.add(new seaAnimals(5,R.drawable.sa_5_a,R.drawable.sa_5_b,R.drawable.sa_5_c,cs.get(4).getColor_source(),false));
        sas.add(new seaAnimals(6,R.drawable.sa_6_a,R.drawable.sa_6_b,R.drawable.sa_6_c,cs.get(5).getColor_source(),false));
        sas.add(new seaAnimals(7,R.drawable.sa_7_a,R.drawable.sa_7_b,R.drawable.sa_7_c,cs.get(6).getColor_source(),false));
        sas.add(new seaAnimals(8,R.drawable.sa_6_a,R.drawable.sa_6_b,R.drawable.sa_6_c,cs.get(7).getColor_source(),false));

    }


    public void initialStates(int animalNumber){

        // answer match and other three animals get set at the same time
        int temp=1;

        //sea animal one with color at ca.get(0)
        sea_animal_outline_1.setImageResource(sas.get(animalNumber).getSeaAnimalOutline());
        ImageViewCompat.setImageTintList(sea_animal_outline_1,
                ColorStateList.valueOf(getResources().getColor(cs.get(0).getColor_source(), null)));

        sea_animal_fill_1.setImageResource(sas.get(animalNumber).getSeaAnimalOutline());
        ImageViewCompat.setImageTintList(sea_animal_outline_1,
                ColorStateList.valueOf(getResources().getColor(cs.get(0).getColor_source(), null)));

        //sea animal one with color at ca.get(1)
        sea_animal_outline_2.setImageResource(sas.get(animalNumber).getSeaAnimalOutline());
        ImageViewCompat.setImageTintList(sea_animal_outline_2,
                ColorStateList.valueOf(getResources().getColor(cs.get(1).getColor_source(), null)));

        sea_animal_fill_2.setImageResource(sas.get(animalNumber).getSeaAnimalOutline());
        ImageViewCompat.setImageTintList(sea_animal_fill_2,
                ColorStateList.valueOf(getResources().getColor(cs.get(1).getColor_source(), null)));


        //sea animal one with color at ca.get(2)
        sea_animal_outline_3.setImageResource(sas.get(animalNumber).getSeaAnimalOutline());
        ImageViewCompat.setImageTintList(sea_animal_outline_3,
                ColorStateList.valueOf(getResources().getColor(cs.get(2).getColor_source(), null)));

        sea_animal_fill_3.setImageResource(sas.get(animalNumber).getSeaAnimalOutline());
        ImageViewCompat.setImageTintList(sea_animal_fill_3,
                ColorStateList.valueOf(getResources().getColor(cs.get(2).getColor_source(), null)));


        sea_animal_outline_1.setVisibility(View.VISIBLE);
        sea_animal_outline_2.setVisibility(View.VISIBLE);
        sea_animal_outline_3.setVisibility(View.VISIBLE);

        sea_animal_outline_1.setTag("A");
        sea_animal_outline_2.setTag("B");
        sea_animal_outline_3.setTag("C");


    }

    @SuppressLint("ClickableViewAccessibility")
    public void setAnswerMatch(int setColor, @NonNull seaAnimals answerMatchAnimalNumber){
        //setting the answer match animal
        answerMatch.setImageResource(answerMatchAnimalNumber.getSeaAnimalOutline());


        //setting the answer match animal color to cs get(setColor)
        ImageViewCompat.setImageTintList(answerMatch,ColorStateList.valueOf(getResources().getColor(cs.get(setColor).getColor_source(),null)));

        answerMatch.setVisibility(View.VISIBLE);
        answerMatch.setTag("1");

        answerMatch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder answerMatchShadow = new View.DragShadowBuilder(answerMatch);
                answerMatch.startDragAndDrop(data,answerMatchShadow,answerMatch,0);
                answerMatch.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        View.OnDragListener dragListener = new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                int draggy = dragEvent.getAction();
                final ImageView Img_Being_drag = (ImageView) dragEvent.getLocalState();
                int flag = 0;

                switch (draggy){
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DROP:
                        Log.d("testing101",""+Img_Being_drag.getTag());
                        if(Img_Being_drag.getTag().equals("1") && view.getTag().equals("A")){
                            flag =1;

                            sea_animal_fill_1.setImageResource(answerMatchAnimalNumber.getSeaAnimalFill());
                            ImageViewCompat.setImageTintList(sea_animal_fill_1,ColorStateList.valueOf(getResources().getColor(cs.get(setColor).getColor_source(),null)));
                            sea_animal_eyes_1.setImageResource(answerMatchAnimalNumber.getSeaAnimalEyes());

                            sea_animal_fill_1.setVisibility(View.VISIBLE);
                            sea_animal_eyes_1.setVisibility(View.VISIBLE);

                            setAnswerMatch(1,sas.get(0));
                            incrementUserWin();
                        }
                        else if(Img_Being_drag.getTag().equals("1") && view.getTag().equals("B")){
                            flag =1;

                            sea_animal_fill_2.setImageResource(answerMatchAnimalNumber.getSeaAnimalFill());
                            ImageViewCompat.setImageTintList(sea_animal_fill_2,ColorStateList.valueOf(getResources().getColor(cs.get(setColor).getColor_source(),null)));
                            sea_animal_eyes_2.setImageResource(answerMatchAnimalNumber.getSeaAnimalEyes());

                            sea_animal_fill_2.setVisibility(View.VISIBLE);
                            sea_animal_eyes_2.setVisibility(View.VISIBLE);
                            setAnswerMatch(2,sas.get(0));
                            incrementUserWin();
                        }
                        else if(Img_Being_drag.getTag().equals("1") && view.getTag().equals("C")){
                            flag =1;

                            sea_animal_fill_3.setImageResource(answerMatchAnimalNumber.getSeaAnimalFill());
                            ImageViewCompat.setImageTintList(sea_animal_fill_3,ColorStateList.valueOf(getResources().getColor(cs.get(setColor).getColor_source(),null)));
                            sea_animal_eyes_3.setImageResource(answerMatchAnimalNumber.getSeaAnimalEyes());

                            sea_animal_fill_3.setVisibility(View.VISIBLE);
                            sea_animal_eyes_3.setVisibility(View.VISIBLE);

                            incrementUserWin();
                        }

                        else
                            answerMatch.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        if(flag == 1)
                            answerMatch.setVisibility(View.INVISIBLE);
                        break;
                }
                return true;
            }
        };

        answerMatch.setOnDragListener(dragListener);
        sea_animal_outline_1.setOnDragListener(dragListener);
        sea_animal_outline_2.setOnDragListener(dragListener);
        sea_animal_outline_3.setOnDragListener(dragListener);

        sea_animal_fill_1.setOnDragListener(dragListener);

    }

    public void incrementUserWin(){
        userMatched += 1;
        if(userMatched == 3) {
            Handler myHandler = new Handler();
            myHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (Games <= 5) {
                        start(Games);
                        Games++;
                    }
                }
            }, 1000);
        }

    }

    public void checkAnimalColorMatch(int animalOutlineNumber,seaAnimals answerMatchAnimalType,ImageView sea_animal_outline) {

        //animal number to know which animal is being checked right now
        // answer match animal to get the colour of the answer match animal
        // imageview to know which outline animal would be filled now

        answerMatchAnimalType.setAssignColour(cs.get(animalOutlineNumber).getColor_source());

       /* if(getResources().getColor(answerMatchAnimalType.getAssignColour(),null) ==
                getResources().getColor(cs.get(animalOutlineNumber).getColor_source(),null)){
           userMatched += 1;
            sea_animal_outline.setImageResource(answerMatchAnimalType.getSeaAnimalFill());
            if(userMatched == 3){
                Handler myHandler = new Handler();
                myHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(Games != 0)
                            start(Games--);
                    }
                },1000);

            } //if user matched 3 correctly
        }//if closing*/

    }


    public void OnClickBubble(int i){

        bubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bubble.setVisibility(View.INVISIBLE);
                OnClickAnswerMatch(i);

            }
        });

    }//on click bubble ends HERE

    public void OnClickAnswerMatch(int animalNumber){

        sea_animal_outline_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking the animal color match with the answer animal match
                checkAnimalColorMatch(0,sas.get(animalNumber),sea_animal_outline_1);
                setAnswerMatch(1, sas.get(animalNumber));

            }
        }); //sea_animal_outline_1.setOnClickListener ends here


        sea_animal_outline_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking the animal color match with the answer animal match
                checkAnimalColorMatch(1,sas.get(animalNumber),sea_animal_outline_2);
                setAnswerMatch(2,sas.get(animalNumber));

            }
        }); //sea_animal_outline_2.setOnClickListener ends here



        sea_animal_outline_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking the animal color match with the answer animal match
                checkAnimalColorMatch(2, sas.get(animalNumber), sea_animal_outline_3);
            }
        }); //sea_animal_outline_3.setOnClickListener ends here




    }//on click answer match ends HERE
}