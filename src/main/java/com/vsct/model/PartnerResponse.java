package com.vsct.model;

public class PartnerResponse {

    private int id;
    private String value;

    PartnerResponse(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
