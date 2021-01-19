package com.example.myapplication;

import java.util.ArrayList;

public class Trening {
    private String nazwa_treningu;
    private String dzien_tygodnia;


    public Trening(String nazwa_treningu, String dzien_tygodnia) {
        this.nazwa_treningu = nazwa_treningu;
        this.dzien_tygodnia = dzien_tygodnia;

    }

    public String getNazwa_treningu() {
        return nazwa_treningu;
    }

    public void setNazwa_treningu(String nazwa_treningu) {
        this.nazwa_treningu = nazwa_treningu;
    }

    public String getDzien_tygodnia() {
        return dzien_tygodnia;
    }

    public void setDzien_tygodnia(String dzien_tygodnia) {
        this.dzien_tygodnia = dzien_tygodnia;
    }
}
