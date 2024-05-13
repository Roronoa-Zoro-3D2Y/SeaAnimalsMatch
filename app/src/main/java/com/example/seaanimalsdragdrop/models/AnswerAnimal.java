package com.example.seaanimalsdragdrop.models;

public class AnswerAnimal {
    int color;
    int sea_animal_fill;

    seaAnimals seaAnimal;

    String TAG;

    public AnswerAnimal(int color, int sea_animal_fill) {
        this.color = color;
        this.sea_animal_fill = sea_animal_fill;
    }

    public AnswerAnimal(int color, seaAnimals seaAnimal, String TAG) {
        this.color = color;
        this.seaAnimal = seaAnimal;
        this.TAG = TAG;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public AnswerAnimal(int color, seaAnimals seaAnimal) {
        this.color = color;
        this.seaAnimal = seaAnimal;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSea_animal_fill() {
        return sea_animal_fill;
    }

    public void setSea_animal_fill(int sea_animal_fill) {
        this.sea_animal_fill = sea_animal_fill;
    }

    public seaAnimals getSeaAnimal() {
        return seaAnimal;
    }

    public void setSeaAnimal(seaAnimals seaAnimal) {
        this.seaAnimal = seaAnimal;
    }
}
