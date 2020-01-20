package com.example.bitirme;

public class Blog{

    public Blog(){}

    public String getDers() { return ders; }

    public String getDerskodu() { return derskodu;  }

    public void setDers(String ders) {
        this.ders = ders;
    }

    public void setDerskodu(String derskodu) {
        this.derskodu = derskodu;
    }


    private String derskodu;
    private String ders;


    public Blog(String ders, String derskodu) {

        this.ders = ders;
        this.derskodu = derskodu;
    }

}