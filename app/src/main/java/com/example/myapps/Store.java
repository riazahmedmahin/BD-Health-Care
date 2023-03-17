package com.example.myapps;

public class Store {

    private String pataname;
    private String paphone;
    private  String autoc;

    public Store(String pataname, String paphone, String autoc) {
        this.pataname = pataname;
        this.paphone = paphone;
        this.autoc = autoc;
    }

    public String getPataname() {
        return pataname;
    }

    public void setPataname(String pataname) {
        this.pataname = pataname;
    }

    public String getPaphone() {
        return paphone;
    }

    public void setPaphone(String paphone) {
        this.paphone = paphone;
    }

    public String getAutoc() {
        return autoc;
    }

    public void setAutoc(String autoc) {
        this.autoc = autoc;
    }
}
