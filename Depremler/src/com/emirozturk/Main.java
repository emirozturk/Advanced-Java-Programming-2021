package com.emirozturk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        return "";
    }
    public static void ekle(DepremVeriListesi liste){

    }
    public static void ara(DepremVeriListesi liste){

    }
}
