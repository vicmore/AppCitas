package com.moniguar.app.citas;

public class Elements {

    private String strDate;
    private String strUser;

    public Elements(String strDate, String strUser) {
        this.strDate = strDate;
        this.strUser = strUser;
    }

    public String getDate() {
        return strDate;
    }
    public String getUser() {
        return strUser;
    }

    public void setUser(String strUser) {
        this.strUser = strUser;
    }
    public void setDate(String strDate) {
        this.strDate = strDate;
    }
}
