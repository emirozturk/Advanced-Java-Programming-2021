package com.emirozturk;

import java.util.*;

class Sinif<E> implements List{

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}

public class Main {

    public static int fonk(ArrayList<Integer> parametre){
        int degisken = parametre.get(0);
        return degisken+10;
    }
    public static int fonk2(List<Integer> parametre){
        int degisken = parametre.get(0);
        return degisken+10;
    }
    public static void main(String[] args) {
        //byte 0-255
        //short 0-65535
        //int 0-2147483647
        //long 0-9223372036854775807
        /*
        double degisken = 3.1231273;
        var byteSonuc = Byte.parseByte("127");
        var sonuc = (int)degisken;
        var doubleSonuc = Double.parseDouble("3,110984".replace(",","."));
        var hexSonuc = Integer.parseInt("AA",16);
        var binarySonuc = Integer.parseInt("101001",2);
        System.out.println(sonuc);
        System.out.println(doubleSonuc);
        System.out.println(byteSonuc);
        System.out.println(hexSonuc);
        System.out.println(binarySonuc);
        if(3>5){        //ilk koşul
        }
        else if(2==2){  //sağlamazsa kontrol edilecek ikinci koşul
        }
        else{           //hiç bir durum sağlanmadığında
        }
        //Eğer blokların içerisinde tek satır varsa blok parantezlerini koymamıza gerek yok.
        var dizi = new int[5];
        for(int i=0;i<dizi.length;i++)
            dizi[i]=i;

        for(int i=0;i<dizi.length;i++){
            System.out.printf("%d ", dizi[i]);
        }
        System.out.println();

        for(int degisken:dizi)
           degisken = 3;

        for(int degisken:dizi){
            System.out.printf("%d ",degisken);
        }
     */
        List<Integer> liste = new ArrayList<Integer>();
        ArrayList<Integer> liste2 = new ArrayList<Integer>();
        fonk(liste);
        fonk(liste2);
        Sinif<Integer> yeniListe = new Sinif();
        fonk(yeniListe);
        fonk2(liste);
        fonk2(liste2);
        fonk2(yeniListe);
    }
}
