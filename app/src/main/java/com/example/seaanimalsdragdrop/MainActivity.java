package com.example.seaanimalsdragdrop;

import static com.example.seaanimalsdragdrop.R.color.red;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import com.example.seaanimalsdragdrop.models.AnswerAnimal;
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
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import android.view.animation.Animation.AnimationListener;


public class MainActivity extends AppCompatActivity {

    ImageView bubble, answerMatch;
    ImageView sea_animal_outline_1, sea_animal_fill_1, sea_animal_eyes_1;
    ImageView sea_animal_outline_2, sea_animal_fill_2, sea_animal_eyes_2;
    ImageView sea_animal_outline_3, sea_animal_fill_3, sea_animal_eyes_3;

    ArrayList<seaAnimals> sas;

    ArrayList<colourSources> cs;

    ArrayList<AnswerAnimal> answerAnimalArrayList;

    seaAnimals answerMatchAnimal;

    String msg = "TESTING";
    int userMatched = 0;
    int userMatch3Outlines = 0;
    int Games = 1;
    int i = 0;
    int flag = 0;

    int setColor;
    Animation move;
    TranslateAnimation moveLeft;
    int color1, color2, color3;

    FrameLayout seaAnimal1, seaAnimal2, seaAnimal3;

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

    public void start(int i) {
        init();
//        Collections.shuffle(cs);
        Collections.shuffle(sas);
        assignAnswerAnimal();
        Collections.shuffle(answerAnimalArrayList);
        setAnswerMatchColorRandom();
        setColor = 0;
        setAnswerMatch(sas.get(0));
        OnClickBubble(0);
        initialStates(0);
        userMatched = 0;
    }


    public void init() {

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

        answerMatch.setVisibility(View.INVISIBLE);


        seaAnimal1 = findViewById(R.id.sea_animal_1_frame);
        seaAnimal2 = findViewById(R.id.sea_animal_2_frame);
        seaAnimal3 = findViewById(R.id.sea_animal_3_frame);
    }

    public void assignColourList() {

        cs = new ArrayList<>();

       /* cs.add(new colourSources(red));
        cs.add(new colourSources(R.color.blue));
        cs.add(new colourSources(R.color.magenta));
        cs.add(new colourSources(R.color.green));
        cs.add(new colourSources(R.color.yellow));
        cs.add(new colourSources(R.color.orange));
        cs.add(new colourSources(R.color.teal));
        cs.add(new colourSources(R.color.maroon));
        cs.add(new colourSources(R.color.violet));*/

    }

    public void assignSeaAnimalList() {

        sas = new ArrayList<>();
        sas.add(new seaAnimals(1, R.drawable.sa_1_a, R.drawable.sa_1_b, R.drawable.sa_1_c, cs.get(0).getColor_source(), false));
        sas.add(new seaAnimals(2, R.drawable.sa_2_a, R.drawable.sa_2_b, R.drawable.sa_2_c, cs.get(1).getColor_source(), false));
        sas.add(new seaAnimals(3, R.drawable.sa_3_a, R.drawable.sa_3_b, R.drawable.sa_3_c, cs.get(2).getColor_source(), false));
        sas.add(new seaAnimals(4, R.drawable.sa_4_a, R.drawable.sa_4_b, R.drawable.sa_4_c, cs.get(3).getColor_source(), true));
        sas.add(new seaAnimals(5, R.drawable.sa_5_a, R.drawable.sa_5_b, R.drawable.sa_5_c, cs.get(4).getColor_source(), false));
        sas.add(new seaAnimals(6, R.drawable.sa_6_a, R.drawable.sa_6_b, R.drawable.sa_6_c, cs.get(5).getColor_source(), false));
        sas.add(new seaAnimals(7, R.drawable.sa_7_a, R.drawable.sa_7_b, R.drawable.sa_7_c, cs.get(6).getColor_source(), false));
        sas.add(new seaAnimals(8, R.drawable.sa_6_a, R.drawable.sa_6_b, R.drawable.sa_6_c, cs.get(7).getColor_source(), false));

    }

    public void assignAnswerAnimal() {
        answerAnimalArrayList = new ArrayList<>();
        answerAnimalArrayList.add(new AnswerAnimal(cs.get(0).getColor_source(), sas.get(0).getSeaAnimalOutline()));
        answerAnimalArrayList.add(new AnswerAnimal(cs.get(1).getColor_source(), sas.get(0).getSeaAnimalOutline()));
        answerAnimalArrayList.add(new AnswerAnimal(cs.get(2).getColor_source(), sas.get(0).getSeaAnimalOutline()));

    }


    public void initialStates(int animalNumber) {

        // answer match and other three animals get set at the same time
        int temp = 1;

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

    public void setAnswerMatchTag(AnswerAnimal answerAnimal) {
        if (cs.get(0).getColor_source() == answerAnimal.getColor())
            answerMatch.setTag("A");
        else if (cs.get(1).getColor_source() == answerAnimal.getColor())
            answerMatch.setTag("B");
        else if (cs.get(2).getColor_source() == answerAnimal.getColor())
            answerMatch.setTag("C");

    }


    @SuppressLint("ClickableViewAccessibility")
    public void setAnswerMatch(@NonNull seaAnimals answerMatchAnimalNumber) {
        //setting the answer match animal
        answerMatch.setImageResource(answerMatchAnimalNumber.getSeaAnimalFill());
        flag = 0;


        //setting the answer match animal color to cs get(setColor)
        if (setColor == 0) {
            ImageViewCompat.setImageTintList(answerMatch, ColorStateList.valueOf(getResources().getColor(answerAnimalArrayList.get(0).getColor(), null)));
            setAnswerMatchTag(answerAnimalArrayList.get(0));
        }
        if (setColor == 1) {
            ImageViewCompat.setImageTintList(answerMatch, ColorStateList.valueOf(getResources().getColor(answerAnimalArrayList.get(1).getColor(), null)));
            setAnswerMatchTag(answerAnimalArrayList.get(1));
        }
        if (setColor == 2) {
            ImageViewCompat.setImageTintList(answerMatch, ColorStateList.valueOf(getResources().getColor(answerAnimalArrayList.get(2).getColor(), null)));
            setAnswerMatchTag(answerAnimalArrayList.get(2));
        }

        answerMatch.setVisibility(View.VISIBLE);

        answerMatch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder answerMatchShadow = new View.DragShadowBuilder(answerMatch);
                answerMatch.startDragAndDrop(data, answerMatchShadow, answerMatch, 0);
                answerMatch.setVisibility(View.INVISIBLE);
                return true;
            }
        });


        View.OnDragListener dragListener = new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                int draggy = dragEvent.getAction();
                final ImageView Img_Being_drag = (ImageView) dragEvent.getLocalState();


                switch (draggy) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DROP:
                        /*Log.d("Testing104",answerMatch.getTag()+" answerMatch "+sea_animal_outline_1.getTag()+"  sea_animal_outline_1.getTag");
                        Log.d("Testing104",answerMatch.getTag()+" answerMatch "+sea_animal_outline_2.getTag()+"  sea_animal_outline_2.getTag");
                        Log.d("Testing104",answerMatch.getTag()+" answerMatch "+sea_animal_outline_3.getTag()+"  sea_animal_outline_3.getTag");*/

                        if (Img_Being_drag.getTag().equals(answerMatch.getTag()) && answerMatch.getTag() == sea_animal_outline_1.getTag() && view.getTag() == sea_animal_outline_1.getTag()) {
                            flag = 1;
                            sea_animal_fill_1.setImageResource(sas.get(0).getSeaAnimalFill());
                            ImageViewCompat.setImageTintList(sea_animal_fill_1, ColorStateList.valueOf(getResources().getColor(cs.get(0).getColor_source(), null)));
                            sea_animal_eyes_1.setImageResource(sas.get(0).getSeaAnimalEyes());

                            sea_animal_fill_1.setVisibility(View.VISIBLE);
                            sea_animal_eyes_1.setVisibility(View.VISIBLE);

                            if (!sas.get(0).isFace()) {
                                move = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_out_of_frame_left);
//                                sea_animal_eyes_1.startAnimation(move);
//                                sea_animal_fill_1.startAnimation(move);

                                seaAnimal1.clearAnimation();
                                seaAnimal1.startAnimation(move);

                                move.setAnimationListener(new AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {

                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        sea_animal_outline_1.setVisibility(View.INVISIBLE);
                                        sea_animal_fill_1.setVisibility(View.INVISIBLE);
                                        sea_animal_eyes_1.setVisibility(View.INVISIBLE);
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {

                                    }
                                });


                            }
                            if (sas.get(0).isFace()) {
                                move = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_out_of_frame_right);

                                sea_animal_eyes_1.startAnimation(move);
                                sea_animal_fill_1.startAnimation(move);

                                sea_animal_outline_1.setVisibility(View.INVISIBLE);
                                sea_animal_fill_1.setVisibility(View.INVISIBLE);
                                sea_animal_eyes_1.setVisibility(View.INVISIBLE);
                            }

                           /* sea_animal_outline_1.setVisibility(View.INVISIBLE);
                            sea_animal_fill_1.setVisibility(View.INVISIBLE);
                            sea_animal_eyes_1.setVisibility(View.INVISIBLE);*/

                            incrementUserWin();
                            Log.d("testing 1", "" + userMatched + " userMatched ");
                        } else if (Img_Being_drag.getTag().equals(answerMatch.getTag()) && answerMatch.getTag() == sea_animal_outline_2.getTag() && view.getTag() == sea_animal_outline_2.getTag()) {
                            flag = 1;

                            sea_animal_fill_2.setImageResource(sas.get(0).getSeaAnimalFill());
                            ImageViewCompat.setImageTintList(sea_animal_fill_2, ColorStateList.valueOf(getResources().getColor(cs.get(1).getColor_source(), null)));
                            sea_animal_eyes_2.setImageResource(sas.get(0).getSeaAnimalEyes());

                            sea_animal_fill_2.setVisibility(View.VISIBLE);
                            sea_animal_eyes_2.setVisibility(View.VISIBLE);

                            if (!sas.get(0).isFace()) {
                                move = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_out_of_frame_left);
                                sea_animal_eyes_2.startAnimation(move);
                                sea_animal_fill_2.startAnimation(move);

                                sea_animal_outline_2.setVisibility(View.INVISIBLE);
                                sea_animal_fill_2.setVisibility(View.INVISIBLE);
                                sea_animal_eyes_2.setVisibility(View.INVISIBLE);
                            }
                            if (sas.get(0).isFace()) {
                                move = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_out_of_frame_right);

                                sea_animal_eyes_2.startAnimation(move);
                                sea_animal_fill_2.startAnimation(move);

                                sea_animal_outline_2.setVisibility(View.INVISIBLE);
                                sea_animal_fill_2.setVisibility(View.INVISIBLE);
                                sea_animal_eyes_2.setVisibility(View.INVISIBLE);
                            }

                            incrementUserWin();
                            Log.d("testing 1", "" + userMatched + " userMatched ");
                        } else if (Img_Being_drag.getTag().equals(answerMatch.getTag()) && answerMatch.getTag() == sea_animal_outline_3.getTag() && view.getTag() == sea_animal_outline_3.getTag()) {
                            flag = 1;

                            sea_animal_fill_3.setImageResource(sas.get(0).getSeaAnimalFill());
                            ImageViewCompat.setImageTintList(sea_animal_fill_3, ColorStateList.valueOf(getResources().getColor(cs.get(2).getColor_source(), null)));
                            sea_animal_eyes_3.setImageResource(sas.get(0).getSeaAnimalEyes());

                            sea_animal_fill_3.setVisibility(View.VISIBLE);
                            sea_animal_eyes_3.setVisibility(View.VISIBLE);

                            if (!sas.get(0).isFace()) {
                                move = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_out_of_frame_left);
                                sea_animal_eyes_3.startAnimation(move);
                                sea_animal_fill_3.startAnimation(move);

                                sea_animal_outline_3.setVisibility(View.INVISIBLE);
                                sea_animal_fill_3.setVisibility(View.INVISIBLE);
                                sea_animal_eyes_3.setVisibility(View.INVISIBLE);
                            }
                            if (sas.get(0).isFace()) {
                                move = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_out_of_frame_right);

                                sea_animal_eyes_3.startAnimation(move);
                                sea_animal_fill_3.startAnimation(move);
                                sea_animal_outline_3.setVisibility(View.INVISIBLE);
                                sea_animal_fill_3.setVisibility(View.INVISIBLE);
                                sea_animal_eyes_3.setVisibility(View.INVISIBLE);
                            }

                            incrementUserWin();
                            Log.d("testing 1", "" + userMatched + " userMatched ");
                        } else
                            answerMatch.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        answerMatch.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        if (flag == 0)
                            answerMatch.setVisibility(View.VISIBLE);
                        break;
                }
                return true;
            }
        };

        answerMatch.setOnDragListener(dragListener);

        sea_animal_outline_1.setOnDragListener(dragListener);
        sea_animal_outline_2.setOnDragListener(dragListener);
        sea_animal_outline_3.setOnDragListener(dragListener);


    }

    public void incrementUserWin() {
        userMatched += 1;
        if (userMatched == 1) {
            setColor = 1;
            setAnswerMatch(sas.get(0));
        }
        if (userMatched == 2) {
            setColor = 2;
            setAnswerMatch(sas.get(0));
        }
        if (userMatched == 3) {
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


    public void checkAnimalColorMatch(int animalOutlineNumber, seaAnimals answerMatchAnimalType, ImageView sea_animal_outline) {

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


    public void OnClickBubble(int i) {

        bubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerMatch.setClickable(false);
                bubble.setVisibility(View.INVISIBLE);


            }
        });

    }//on click bubble ends HERE

/*
    public void OnClickAnswerMatch(int animalNumber){

        sea_animal_outline_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking the animal color match with the answer animal match
                checkAnimalColorMatch(0,sas.get(animalNumber),sea_animal_outline_1);
                setAnswerMatch(sas.get(animalNumber));

            }
        }); //sea_animal_outline_1.setOnClickListener ends here


        sea_animal_outline_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking the animal color match with the answer animal match
                checkAnimalColorMatch(1,sas.get(animalNumber),sea_animal_outline_2);
                setAnswerMatch(sas.get(animalNumber));

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
*/

    public void setAnswerMatchColorRandom() {
        Random rand = new Random();
        do {
            color1 = rand.nextInt(3);
            color2 = rand.nextInt(3);
            color3 = rand.nextInt(3);
        } while ((color1 == color2) || (color1 == color3) || (color2 == color3));
        Log.d("TESTINGcolors", color1 + " " + color2 + " " + color3 + " ");

    }
}