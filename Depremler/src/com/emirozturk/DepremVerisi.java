package com.emirozturk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DepremVerisi {
    private LocalDateTime tarihSaat;
    private Lokasyon lokasyon;
    private Buyukluk buyukluk;
    private String cozumNiteligi;
    public DepremVerisi(String satir){
        //var a = Arrays.stream(satir.split(" ")).filter(x-> !x.equals("")).toList();
        var degistirilmis = satir.replaceAll("\\s{2,}"," ");
        var parcalar = degistirilmis.split(" ");

        var tarihSaatStringi = "%s-%s".formatted(parcalar[0], parcalar[1]);//"2021.10.04-14:00:19"
        tarihSaat =  LocalDateTime.parse(tarihSaatStringi, DateTimeFormatter.ofPattern("yyyy.MM.dd-HH:mm:ss"));
        lokasyon = new Lokasyon(parcalar[2],parcalar[3],parcalar[4],parcalar[8]);
        buyukluk = new Buyukluk(parcalar[5],parcalar[6],parcalar[7]);
        cozumNiteligi = parcalar[9];
    }

    @Override
    public String toString() {
        return "%s %s %s %s".formatted(tarihSaat.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),lokasyon,buyukluk,cozumNiteligi);
    }
}
