package com.garanti.model;

public class Konu {
    private Integer ID;
    // aman dikkat repoda boş gelmesin
    private String NAME;

    public Konu() {
    }
    public Konu(String NAME) {
        this.NAME = NAME;
    }
    public Konu(Integer ID, String NAME) {
        this.ID = ID;
        this.NAME = NAME;
    }


    public Integer getID() {
        return ID;
    }
    public String getNAME() {
        return NAME;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "Konu{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
