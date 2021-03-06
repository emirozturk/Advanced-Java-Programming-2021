package com.emirozturk.models;

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
    public void ekrandanEkle(String kayit) {
        liste.add(0, new DepremVerisi(kayit.replace("-",".")));
    }
    public List<String> ara(String yer) {
        var sonucListesi = new ArrayList<String>();
        for(var eleman:liste)
            if(eleman.getYer().contains(yer))
                sonucListesi.add(eleman.toString());
        return sonucListesi;
    }

    public List<DepremVerisi> ara(float buyukluk,int kayitSayisi){
        var sonucListesi = new ArrayList<DepremVerisi>();
        for(var eleman:liste)
            if(eleman.getBuyukluk() >= buyukluk){
                sonucListesi.add(eleman);
                if(sonucListesi.size() == kayitSayisi)break;
            }
        //return liste.stream().filter(x->x.getBuyukluk()>3).sorted().limit(kayitSayisi).toList(); Listeden en büyük ilk 10'u al
        var results = liste.stream().map(DepremVerisi::toString);
        return sonucListesi;
    }
    public List<String> listeAl(){
        ArrayList<String> elemanlar = new ArrayList<String>();
        for(var eleman:liste)
            elemanlar.add(eleman.toString());
        return elemanlar;
    }
}
