public class Sinif {
    public static double Hesapla(String metin){
        var sonuc = -1.0;
        if(metin == "")return 0;
        var deger = Double.parseDouble(metin);
        if(deger == 0)return 0;
        if (deger <= 100) sonuc = 100/ deger;
        else sonuc = Math.round(deger);
        return sonuc;
    }
}
