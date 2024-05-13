package com.example.seaanimalsdragdrop;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static com.example.seaanimalsdragdrop.R.color.red;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

import android.view.animation.Animation.AnimationListener;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {

    ImageView bubble, answerMatch;
    ImageView sea_animal_outline_1, sea_animal_fill_1, sea_animal_eyes_1;
    ImageView sea_animal_outline_2, sea_animal_fill_2, sea_animal_eyes_2;
    ImageView sea_animal_outline_3, sea_animal_fill_3, sea_animal_eyes_3;

    ArrayList<seaAnimals> sas;

    ArrayList<colourSources> cs;
    ArrayList<String> animalsMatchedTag = new ArrayList<>();
    ArrayList<AnswerAnimal> img_animal_ArrayList = new ArrayList<>();;
    ArrayList<ImageView> outlinesList;
    ArrayList<ImageView> fillList;
    ArrayList<ImageView> eyesList;
    ArrayList<FrameLayout> frameList;


    String msg = "TESTING";
    int Games = 1;
    int userMatched=0;
    int i = 0;
    int seaAniNumGen;
    boolean isBubbleClicked;
    FrameLayout seaAnimal1, seaAnimal2, seaAnimal3;

    ConstraintLayout bubbleFrame;

    Animation translate;

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



        start();

    }// OnCreate ends

    public void start() {
        init();
        Random random = new Random();
        seaAniNumGen = random.nextInt(8);
        sea_animal_outline_1.clearAnimation();
        sea_animal_outline_2.clearAnimation();
        sea_animal_outline_3.clearAnimation();
        answerMatch.clearAnimation();
        seaAnimal1.clearAnimation();
        seaAnimal2.clearAnimation();
        seaAnimal3.clearAnimation();
        answerMatch.clearAnimation();
        setOutlinesList();
        setFillList();
        setEyesList();
        setFrameList();
        assignColourList();
        assignSeaAnimalList();
        assignAnswerAnimal();
        i=0;
        userMatched=0;
        GameSetup();
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

        bubbleFrame = findViewById(R.id.sea_animal_match_layout);
    }

    public void assignColourList() {

        cs = new ArrayList<>();

        cs.add(new colourSources(R.color.red,1));
        cs.add(new colourSources(R.color.blue,2));
        cs.add(new colourSources(R.color.magenta,3));
        cs.add(new colourSources(R.color.green,4));
        cs.add(new colourSources(R.color.yellow,5));
        cs.add(new colourSources(R.color.orange,6));
        cs.add(new colourSources(R.color.teal,7));
        cs.add(new colourSources(R.color.maroon,8));
        cs.add(new colourSources(R.color.violet,9));


    }

    public void assignSeaAnimalList() {

        Collections.shuffle(cs);

        sas = new ArrayList<>();
        sas.add(new seaAnimals(1, R.drawable.sa_1_a, R.drawable.sa_1_b, R.drawable.sa_1_c, cs.get(0).getColor_source(), true));
        sas.add(new seaAnimals(2, R.drawable.sa_2_a, R.drawable.sa_2_b, R.drawable.sa_2_c, cs.get(1).getColor_source(), true));
        sas.add(new seaAnimals(3, R.drawable.sa_3_a, R.drawable.sa_3_b, R.drawable.sa_3_c, cs.get(2).getColor_source(), false));
        sas.add(new seaAnimals(4, R.drawable.sa_4_a, R.drawable.sa_4_b, R.drawable.sa_4_c, cs.get(3).getColor_source(), true));
        sas.add(new seaAnimals(5, R.drawable.sa_5_a, R.drawable.sa_5_b, R.drawable.sa_5_c, cs.get(4).getColor_source(), false));
        sas.add(new seaAnimals(6, R.drawable.sa_6_a, R.drawable.sa_6_b, R.drawable.sa_6_c, cs.get(5).getColor_source(), false));
        sas.add(new seaAnimals(7, R.drawable.sa_7_a, R.drawable.sa_7_b, R.drawable.sa_7_c, cs.get(6).getColor_source(), false));
        sas.add(new seaAnimals(8, R.drawable.sa_6_a, R.drawable.sa_6_b, R.drawable.sa_6_c, cs.get(7).getColor_source(), false));

    }

    public void assignAnswerAnimal() {
        img_animal_ArrayList.clear();
        for(int i=0;i<3;i++) {
            img_animal_ArrayList.add(new AnswerAnimal(cs.get(i).getColor_source(), sas.get(seaAniNumGen), i + ""));
        }
    }

    public  void setOutlinesList(){
        outlinesList = new ArrayList<>();
        outlinesList.add(sea_animal_outline_1);
        outlinesList.add(sea_animal_outline_2);
        outlinesList.add(sea_animal_outline_3);
    }
    public  void setFillList(){
        fillList = new ArrayList<>();
        fillList.add(sea_animal_fill_1);
        fillList.add(sea_animal_fill_2);
        fillList.add(sea_animal_fill_3);
    }
    public  void setEyesList(){
        eyesList = new ArrayList<>();
        eyesList.add(sea_animal_eyes_1);
        eyesList.add(sea_animal_eyes_2);
        eyesList.add(sea_animal_eyes_3);
    }
    public  void setFrameList(){
        frameList = new ArrayList<>();
        frameList.add(seaAnimal1);
        frameList.add(seaAnimal2);
        frameList.add(seaAnimal3);
    }

    public void setAnswerMatch() {

        do{
            Collections.shuffle(img_animal_ArrayList);
        }while (img_animal_ArrayList.get(0).getTAG() == "setted");

        if (answerMatch.getTag() != img_animal_ArrayList.get(0).getTAG()){
            answerMatch.setImageResource(img_animal_ArrayList.get(0).getSeaAnimal().getSeaAnimalFill());

            ImageViewCompat.setImageTintList(answerMatch, ColorStateList.valueOf(
                    getResources().getColor(img_animal_ArrayList.get(0).getColor(), null)));

          /*  for(i=0;i<3;i++){
                if(outlinesList.get(i).getResources().getColor() == img_animal_ArrayList.get(0).getTAG())
                    answerMatch.setTag(outlinesList.get(i).getTag());*/
            answerMatch.setTag(img_animal_ArrayList.get(0).getTAG());
            img_animal_ArrayList.get(0).setTAG("setted");
        }
        else
            Collections.shuffle(img_animal_ArrayList);

        Log.d(msg, "Tag of Animal" + " is " + answerMatch.getTag());
        answerMatch.setVisibility(View.VISIBLE);
        backForth(answerMatch);

        }



    @SuppressLint("ClickableViewAccessibility")
    public void GameSetup(){
        final int[] temp = {0};
        isBubbleClicked = onBubbleClick();



        //setting Color and outline of all three sea Animals
        for(i=0;i<3;i++) {
            outlinesList.get(i).setImageResource(sas.get(seaAniNumGen).getSeaAnimalOutline());
            ImageViewCompat.setImageTintList(outlinesList.get(i),ColorStateList.valueOf(
                    getResources().getColor(cs.get(i).getColor_source(),null)));
            outlinesList.get(i).setTag(i+"");

            View pV = (View) outlinesList.get(i).getParent();
            pV.setTag(i+"");

            //Log.d(msg,"Tag of Sea Animal"+i+" is "+outlinesList.get(i).getTag());
            Log.d("TAG sa 1", sea_animal_outline_1.getTag()+"");
            Log.d("TAG sa 2", sea_animal_outline_2.getTag()+"");
            Log.d("TAG sa 3", sea_animal_outline_3.getTag()+"");

        }
        comingInAnimation(0,-1500);
        Handler myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                comingInAnimation(1,-2000);
            }
        },1000);

        Handler myHandler1 = new Handler();
        myHandler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                comingInAnimation(2,-2500);
            }
        },2000);

        setAnswerMatch();

        if(isBubbleClicked){

            answerMatch.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ClipData data = ClipData.newPlainText("","");
                    View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(answerMatch);
                    view.startDragAndDrop(data,dragShadowBuilder,answerMatch,0);
                    answerMatch.setVisibility(View.INVISIBLE);
                    return true;
                }
            });
            for(i=0;i<3;i++) {
                setDragDrop();
            }
        }
    }

    public void comingInAnimation(int frame,int fromX){
        TranslateAnimation comesIn =null;
        if(!sas.get(seaAniNumGen).isFace()){
            comesIn = new TranslateAnimation(2000,0,0,0);
        }
        else{
            comesIn = new TranslateAnimation(fromX,0,0,0);
        }
        frameList.get(frame).startAnimation(comesIn);
        comesIn.setDuration(1000);
        comesIn.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                outlinesList.get(frame).setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                backForth(outlinesList.get(frame));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void goingOutAnimation(int frame){
        TranslateAnimation goesOut = null;
        if(!sas.get(seaAniNumGen).isFace()){
            goesOut = new TranslateAnimation(0,1000,0,0);
        }
        else{
            goesOut = new TranslateAnimation(0,1000,0,0);
        }
        frameList.get(frame).startAnimation(goesOut);
        goesOut.setDuration(1000);
        goesOut.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                frameList.get(frame).setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void setDragDrop(){
        int[] temp = new int[1];
        View.OnDragListener onDragListener = new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                int draggy = dragEvent.getAction();

                final ImageView drag_img = (ImageView) dragEvent.getLocalState();

                ImageView imageView;
                Log.d(msg,"Tag of drag animal"+i+" is "+drag_img.getTag());
                Log.d(msg,"Tag of answer match animal"+" is "+answerMatch.getTag());
                Log.d(msg,"Tag of view"+" is "+view.getTag());

                Log.d(msg, outlinesList.get(0).getTag()+"");
                Log.d(msg, outlinesList.get(1).getTag()+"");
                Log.d(msg, outlinesList.get(2).getTag()+"");


                switch (draggy){

                    case DragEvent.ACTION_DRAG_STARTED:
                        answerMatch.clearAnimation();
                        break;
                    case DragEvent.ACTION_DROP:
//                            Toast.makeText(MainActivity2.this, view.getTag()+" TAG "+pV.getTag(), Toast.LENGTH_SHORT).show();

                        if(view.getTag().toString().equals(answerMatch.getTag().toString())) {
                            userMatched += 1;

                            Log.d(TAG, "user matched: "+userMatched);
                            for (i = 0; i < 3; i++) {
                                View pV = (View) outlinesList.get(i).getParent();
                                if (view.getTag().toString().equals(pV.getTag().toString())) {
                                    temp[0] = 1;
                                    outlinesList.get(i).clearAnimation();
                                    fillList.get(i).setImageResource(sas.get(seaAniNumGen).getSeaAnimalFill());
                                    eyesList.get(i).setImageResource(sas.get(seaAniNumGen).getSeaAnimalEyes());
                                    ImageViewCompat.setImageTintList(fillList.get(i), ColorStateList.valueOf(
                                            getResources().getColor(cs.get(i).getColor_source(), null)));
                                    fillList.get(i).setVisibility(View.VISIBLE);
                                    eyesList.get(i).setVisibility(View.VISIBLE);
//                                    View view1 = outlinesList.get(i);

//                                    goingOutAnimation(i);
                                }
                            }
                        }
                        else
                            answerMatch.setVisibility(View.VISIBLE);

                        if(userMatched <3 && userMatched >0)
                        { setAnswerMatch();
                            answerMatch.clearAnimation();}
                        if(userMatched >=3)
                            gameReset();
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        answerMatch.setVisibility(View.INVISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        if(temp[0] == 0)
                            answerMatch.setVisibility(View.VISIBLE);
                        break;
                }
                return true;
            }
        };
        //answerMatch.setOnDragListener(onDragListener);
        seaAnimal1.setOnDragListener(onDragListener);
        seaAnimal2.setOnDragListener(onDragListener);
        seaAnimal3.setOnDragListener(onDragListener);

    }

    public void backForth(View view){
        RotateAnimation rotate = new RotateAnimation(-2.0f,2.0f,view.getWidth()/2,view.getHeight()/2);
        rotate.setRepeatMode(Animation.REVERSE);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setDuration(1000);
        view.startAnimation(rotate);
    }
    public boolean onBubbleClick(){
        isBubbleClicked = true;
//        backForth(bubbleFrame);
        translate =AnimationUtils.loadAnimation(this,R.anim.tilt);
        bubbleFrame.startAnimation(translate);
        bubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bubble.setVisibility(View.INVISIBLE);
                bubbleFrame.clearAnimation();
            }

        });
        Log.d(msg,isBubbleClicked+" on bubble click");
        return isBubbleClicked;

    }

    public void gameReset(){
        Toast.makeText(this, Games+" Game Over", Toast.LENGTH_SHORT).show();
        Games += 1;
        Handler myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Games <= 5)
                    start();
            }
        },1000);
    }

} // PUBLIC CLASS ENDS

/*    public void set_outlines(){
        sea_animal_outline_1.setImageResource(img_animal_ArrayList.get(0).getSeaAnimal().getSeaAnimalOutline());
        ImageViewCompat.setImageTintList(sea_animal_outline_1,
                ColorStateList.valueOf(getResources().getColor(img_animal_ArrayList.get(0).getColor(),null)));

        sea_animal_outline_2.setImageResource(img_animal_ArrayList.get(1).getSeaAnimal().getSeaAnimalOutline());
        ImageViewCompat.setImageTintList(sea_animal_outline_2,
                ColorStateList.valueOf(getResources().getColor(img_animal_ArrayList.get(1).getColor(),null)));

        sea_animal_outline_3.setImageResource(img_animal_ArrayList.get(2).getSeaAnimal().getSeaAnimalOutline());
        ImageViewCompat.setImageTintList(sea_animal_outline_3,
                ColorStateList.valueOf(getResources().getColor(img_animal_ArrayList.get(2).getColor(),null)));

        sea_animal_outline_1.setVisibility(View.VISIBLE);
        sea_animal_outline_2.setVisibility(View.VISIBLE);
        sea_animal_outline_3.setVisibility(View.VISIBLE);
    }*/
