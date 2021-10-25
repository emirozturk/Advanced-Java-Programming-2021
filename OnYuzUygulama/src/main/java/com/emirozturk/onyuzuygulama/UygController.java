package com.emirozturk.onyuzuygulama;

import com.emirozturk.models.DepremVeriListesi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class UygController {
    DepremVeriListesi veriListesi;

    public TextField TbSaat;
    public DatePicker DpTarih;
    public TextField TbEbd;
    public TextField TbMDegerleri;
    public TextField TbYer;
    public TextField TbCozumNiteligi;
    public ListView<String> LbListe;

    public void initialize(){
        System.out.println("Form acildi");
        try {
            var satirlar = Files.readAllLines(Path.of("/Users/emirozturk/Desktop/DepremVeri.txt"));
            veriListesi = DepremVeriListesi.satirlardan(satirlar);
            listele();
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    public void BtnEkleOnAction(ActionEvent actionEvent) {
        var tarih = DpTarih.getValue();
        var saat = TbSaat.getText()+":00";
        var ebd = TbEbd.getText();
        var mDegerleri = TbMDegerleri.getText();
        var cozumNiteligi = TbCozumNiteligi.getText();
        var yer = TbYer.getText();
        veriListesi.ekrandanEkle("%s %s %s %s %s %s".formatted(tarih, saat, ebd, mDegerleri, cozumNiteligi, yer));
        listele();
    }

    @FXML
    public void BtnAraOnAction(ActionEvent actionEvent){
        var yer = TbYer.getText();
        if(yer.length()>0){
            var sonuclar = veriListesi.ara(yer);
            LbListe.getItems().clear();
            for(var eleman:sonuclar)
                LbListe.getItems().add(eleman);
        }
        else
            listele();
    }
    public void listele(){
        LbListe.getItems().clear();
        for(var eleman:veriListesi.listeAl())
            LbListe.getItems().add(eleman);
    }
}