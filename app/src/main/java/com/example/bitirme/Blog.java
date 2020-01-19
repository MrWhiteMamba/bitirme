package com.example.bitirme;

public class Blog{


    public String getDers() { return ders; }

    public Long getDerskodu() { return derskodu;  }

    public void setDers(String ders) {
        this.ders = ders;
    }

    public void setDerskodu(Long derskodu) {
        this.derskodu = derskodu;
    }


    private Long qrcodevalue;
    private Long derskodu;
    private String ders;

    public Long getQrcodevalue() {
        return qrcodevalue;
    }

    public void setQrcodevalue(Long qrcodevalue) {
        this.qrcodevalue = qrcodevalue;
    }

    public Blog(Long qrcodevalue, String ders, Long derskodu) {
        this.qrcodevalue = qrcodevalue;
        this.ders = ders;
        this.derskodu = derskodu;
    }
    public Blog(Long qrcodevalue){


        this.qrcodevalue = qrcodevalue;
    }
}