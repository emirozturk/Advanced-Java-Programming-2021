package com.emirozturk;

public class Lokasyon {
    private float enlem;
    private float boylam;
    private float derinlik;
    private String yer;
    public Lokasyon(String enlem,String boylam,String derinlik,String yer){
        this.enlem = Float.parseFloat(enlem);
        this.boylam = Float.parseFloat(boylam);
        this.derinlik = Float.parseFloat(derinlik);
        this.yer = yer;
    }
    public String toString(){
        return "%2.3f %2.3f %2.3f %20s".formatted(enlem,boylam,derinlik,yer);
    }
}
