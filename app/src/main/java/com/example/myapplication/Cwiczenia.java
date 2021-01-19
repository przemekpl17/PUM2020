package com.example.myapplication;

public class Cwiczenia {
    private String numerCwiczenia;
    private String nazwaCwiczenia;
    private String serieCwiczenia;
    private String powtorzeniaCwiczenia;
    private String obciazenieCwiczenia;

    public Cwiczenia(String numerCwiczenia, String nazwaCwiczenia, String serieCwiczenia, String powtorzeniaCwiczenia, String obciazenieCwiczenia) {
        this.numerCwiczenia = numerCwiczenia;
        this.nazwaCwiczenia = nazwaCwiczenia;
        this.serieCwiczenia = serieCwiczenia;
        this.powtorzeniaCwiczenia = powtorzeniaCwiczenia;
        this.obciazenieCwiczenia = obciazenieCwiczenia;
    }

    public String getNumerCwiczenia() {
        return numerCwiczenia;
    }

    public String getNazwaCwiczenia() {
        return nazwaCwiczenia;
    }

    public String getSerieCwiczenia() {
        return serieCwiczenia;
    }

    public String getPowtorzeniaCwiczenia() {
        return powtorzeniaCwiczenia;
    }

    public String getObciazenieCwiczenia() {
        return obciazenieCwiczenia;
    }

    public void setNumerCwiczenia(String numerCwiczenia) {
        this.numerCwiczenia = numerCwiczenia;
    }

    public void setNazwaCwiczenia(String nazwaCwiczenia) {
        this.nazwaCwiczenia = nazwaCwiczenia;
    }

    public void setSerieCwiczenia(String serieCwiczenia) {
        this.serieCwiczenia = serieCwiczenia;
    }

    public void setPowtorzeniaCwiczenia(String powtorzeniaCwiczenia) {
        this.powtorzeniaCwiczenia = powtorzeniaCwiczenia;
    }

    public void setObciazenieCwiczenia(String obciazenieCwiczenia) {
        this.obciazenieCwiczenia = obciazenieCwiczenia;
    }
}
