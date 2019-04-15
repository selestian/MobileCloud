package com.selestian.mobilecloud;

import android.util.Log;

class LocalCalcThread
{
    private String time;
    private final int UPPER_LIMIT = 1000000;
    private long primeNumberCounter = 0;

    void CalculatePrimeNum() {
        Long i = 0L;
        Timer.reset();
        Timer.start();

        while (++i <= this.UPPER_LIMIT) {
            if (isPrimeNum(i)) {
                ++this.primeNumberCounter;
                Log.d("Prime Number",i+"");
            }
        }
        Timer.stop();
        time =  String.valueOf(Timer.result()/1000.0f);
    }

    private static boolean isPrimeNum(Long num){
        if (num <= 1)
            return false;
        long check = (long) Math.ceil(Math.sqrt(num));
        for (int i = 2; i < check; i++)
            if (num % i == 0)
                return false;

        return true;
    }

    long getPrimeNum() {
        return primeNumberCounter;
    }

    String getTime() {
        return time;
    }
}
