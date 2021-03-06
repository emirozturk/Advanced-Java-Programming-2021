package com.emirozturk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            var satirlar =  Files.readAllLines(Path.of("/Users/emirozturk/Desktop/DepremVeri.txt"));
            DepremVeriListesi liste = DepremVeriListesi.satirlardan(satirlar);
            if(liste != null)
                menu(liste);
            else
                System.out.println("Dosya listesi boş");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void menu(DepremVeriListesi liste){
        var scanner = new Scanner(System.in);
        while(true){
            System.out.println(listele(liste,10));
            System.out.println("1.Ekle");
            System.out.println("2.Ara");
            System.out.println("3.Cikis");
            var secim = scanner.nextInt();
            if(secim == 1)ekle(liste);
            else if(secim == 2)ara(liste);
            else if(secim == 3)break;
        }
    }
    public static String listele(DepremVeriListesi liste, int kayitSayisi){
        StringBuilder sonuc = new StringBuilder();
        for(int i=0;i<kayitSayisi;i++)
            sonuc.append(liste.nInciEleman(i)).append("\n");
        sonuc.append("---------------------------");
        return sonuc.toString();
    }
    public static void ekle(DepremVeriListesi liste){
        liste.ekle("1999.03.13 14:00:19  23.2323   53.5353        2.2      -.-  1.1  -.-   AKDENIZ                                           İlksel");
    }
    public static void ara(DepremVeriListesi liste){
        List<DepremVerisi> sonuclar = liste.ara(3.0f,10);
        for (var veri:sonuclar)
            System.out.println(veri.toString());
        System.out.println("--------------------------------");
    }
}
