package com.selestian.mobilecloud;

import com.google.gson.annotations.SerializedName;

public class DataBean {
    @SerializedName("primeNum")
    private long primeNum;
    @SerializedName("time")
    private String time;

    public long getPrimeNum() {
        return primeNum;
    }

    public void setPrimeNum(long primeNum) {
        this.primeNum = primeNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return primeNum + " - " + time;
    }
}
