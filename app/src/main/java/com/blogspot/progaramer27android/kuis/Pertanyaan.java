package com.blogspot.progaramer27android.kuis;

/**
 * Created by gery on 11/6/17.
 */

public class Pertanyaan {
    public String soal []={
      "soal 1", "soal 2", "soal 2","soal 4","soal 5","soal 6","soal 7","soal 8","soal 9","soal 10",
    };
    private String pilihan [][]={
            {"ayam1", "bebek1", "burung1", "elang1"},
            {"ayam2", "bebek2", "burung2", "elang2"},
            {"ayam3", "bebek3", "burung3", "elang3"},
            {"ayam4", "bebek4", "burung4", "elang4"},
            {"ayam5", "bebek5", "burung5", "elang5"},
            {"ayam6", "bebek6", "burung6", "elang6"},
            {"ayam7", "bebek7", "burung7", "elang7"},
            {"ayam8", "bebek8", "burung8", "elang8"},
            {"ayam9", "bebek9", "burung9", "elang9"},
            {"ayam10", "bebek10", "burung10", "elang10"},
    };
    private String jawabanBenar[]={
      "ayam1","ayam2","ayam3","ayam4","ayam5","ayam6","ayam7","ayam8","ayam9","ayam10"
    };
    //soal
    public String getsoal(int nomor){
        String soall = soal[nomor];
        return soall;}

    //pilihan
    public String getpilihan1(int nomor) {
        String pilihann = pilihan[nomor][0];
        return pilihann;
    }
    public String getpilihan2(int nomor) {
        String pilihann = pilihan[nomor][1];
        return pilihann;
    }
    public String getpilihan3(int nomor) {
        String pilihann = pilihan[nomor][2];
        return pilihann;
    }
    public String getpilihan4(int nomor) {
        String pilihann = pilihan[nomor][3];
        return pilihann;}

    //jawaban benar
    public String getjawaban(int nomor){
        String jawaban = jawabanBenar[nomor];
        return jawaban;}

}
