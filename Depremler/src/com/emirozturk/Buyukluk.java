package com.emirozturk;

public class Buyukluk {
    private float md;
    private float ml;
    private float mw;
    public Buyukluk(String md,String ml,String mw){
        this.md = md.equals("-.-")?-1:Float.parseFloat(md);
        this.ml = ml.equals("-.-")?-1:Float.parseFloat(ml);
        this.mw = mw.equals("-.-")?-1:Float.parseFloat(mw);
    }
    public String toString(){
        return "%2.3f %2.3f %2.3f".formatted(md,ml,mw);
    }
}
