package com.example.seaanimalsdragdrop.models;

import android.content.res.ColorStateList;

public class colourSources {
    int color_source;
    int tag;

    public colourSources(int color_source,int tag) {
        this.color_source = color_source;
        this.tag = tag;
    }

    public int getColor_source() {
        return color_source;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
