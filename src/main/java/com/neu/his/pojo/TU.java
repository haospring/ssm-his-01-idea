package com.neu.his.pojo;

public class TU {
    private String keywords;
    private String keywords2;

    public TU() {
        super();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getKeywords2() {
        return keywords2;
    }

    public void setKeywords2(String keywords2) {
        this.keywords2 = keywords2;
    }

    @Override
    public String toString() {
        return "TU [keywords=" + keywords + ", keywords2=" + keywords2 + "]";
    }
}
