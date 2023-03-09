package com.apiwat.LottoryAPI.entity;

import java.util.ArrayList;

public class CheckResponseModel extends ResponseModel {
    private ArrayList<String> data;

    public CheckResponseModel(String status, String message, ArrayList<String> data) {
        super(status, message);
        this.data = data;
    }
    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

}
