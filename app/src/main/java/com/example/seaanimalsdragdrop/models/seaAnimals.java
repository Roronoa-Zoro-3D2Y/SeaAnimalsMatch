package com.example.seaanimalsdragdrop.models;

import android.widget.ImageView;

public class seaAnimals {
    int id;
    int seaAnimalOutline;
    int seaAnimalFill;
    int seaAnimalEyes;
    int assignColour;

    boolean face;

    public seaAnimals(int id, int seaAnimalOutline, int seaAnimalFill, int seaAnimalEyes, int assignColour, boolean face) {
        this.id = id;
        this.seaAnimalOutline = seaAnimalOutline;
        this.seaAnimalFill = seaAnimalFill;
        this.seaAnimalEyes = seaAnimalEyes;
        this.assignColour = assignColour;
        this.face = face;
    }

    public void setSeaAnimalOutline(int seaAnimalOutline) {
        this.seaAnimalOutline = seaAnimalOutline;
    }

    public void setSeaAnimalFill(int seaAnimalFill) {
        this.seaAnimalFill = seaAnimalFill;
    }

    public void setSeaAnimalEyes(int seaAnimalEyes) {
        this.seaAnimalEyes = seaAnimalEyes;
    }

    public int getSeaAnimalOutline() {
        return seaAnimalOutline;
    }

    public int getSeaAnimalFill() {
        return seaAnimalFill;
    }

    public int getSeaAnimalEyes() {
        return seaAnimalEyes;
    }

    public seaAnimals() {
    }

    public int getAssignColour() {
        return assignColour;
    }

    public void setAssignColour(int assignColour) {
        this.assignColour = assignColour;
    }
}
