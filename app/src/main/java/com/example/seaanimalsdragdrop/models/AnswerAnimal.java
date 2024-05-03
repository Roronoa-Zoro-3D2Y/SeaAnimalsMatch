package com.example.seaanimalsdragdrop.models;

public class AnswerAnimal {
    int color;
    int sea_animal_fill;

    public AnswerAnimal(int color, int sea_animal_fill) {
        this.color = color;
        this.sea_animal_fill = sea_animal_fill;
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
}
