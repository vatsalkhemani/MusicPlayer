package com.example.vatsal.audioapp.Adapters.Model;

import java.util.ArrayList;

/**
 * Created by Vatsal on 09-06-2020.
 */

public class VerticalModel {

    String title;
    ArrayList<HorizontalModel> arrayList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<HorizontalModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<HorizontalModel> arrayList) {
        this.arrayList = arrayList;
    }
}
