package com.vsct.model;

public class PartnerResponse {

    public int id;
    public String value;

    public PartnerResponse(int id, String value) {
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
