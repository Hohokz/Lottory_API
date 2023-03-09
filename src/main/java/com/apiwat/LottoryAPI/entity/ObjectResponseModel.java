package com.apiwat.LottoryAPI.entity;

public class ObjectResponseModel extends ResponseModel{
    private Object data;

    public Object getData() {
        return data;
    }

    public ObjectResponseModel(String status, String message, Object data) {
        super(status, message);
        this.data = data;
    }

    public ObjectResponseModel(Object data) {
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
