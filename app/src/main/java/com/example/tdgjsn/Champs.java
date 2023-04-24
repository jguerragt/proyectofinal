package com.example.tdgjsn;

public class Champs {

    String camp, subc, result, torn;

public Champs(){}



    public Champs(String camp, String subc, String result,String torn) {
        this.camp = camp;
        this.subc = subc;
        this.result = result;
        this.torn = torn;
    }

    public String getTorn() {
        return torn;
    }

    public void setTorn(String torn) {
        this.torn = torn;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

    public String getSubc() {
        return subc;
    }

    public void setSubc(String subc) {
        this.subc = subc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
