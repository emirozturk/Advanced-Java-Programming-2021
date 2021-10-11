package com.emirozturk;

import java.util.ArrayList;
import java.util.List;

public class DepremVeriListesi {
    List<DepremVerisi> liste;

    private DepremVeriListesi(List<DepremVerisi> liste){
        this.liste = liste;
    }

    public static DepremVeriListesi satirlardan(List<String> satirlar){
        var liste = new ArrayList<DepremVerisi>();
        for (var satir : satirlar) {
            var depremVerisi = new DepremVerisi(satir);
            liste.add(depremVerisi);
        }
        return new DepremVeriListesi(liste);
    }
    public String nInciEleman(int i){
        return liste.get(i).toString();
    }
    public int getElemanSayisi(){
        return liste.size();
    }
    public void ekle(String kayit){
        liste.add(0,new DepremVerisi(kayit));
    }
    public List<DepremVerisi> ara(float buyukluk,int kayitSayisi){
        var sonucListesi = new ArrayList<DepremVerisi>();
        for(var eleman:liste)
            if(eleman.getBuyukluk() >= buyukluk){
                sonucListesi.add(eleman);
                if(sonucListesi.size() == kayitSayisi)break;
            }
        return sonucListesi;
    }
}
