package com.selestian.mobilecloud;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ServerCalcThread extends Thread {
    private String time = "1";
    private long primeNumberCounter = 1;
    private DataBean bean;

    ServerCalcThread(){
        ConnectionMethod method = ConnectionConfig.getApiClient().create(ConnectionMethod.class);
        Call<DataBean> call = method.getData();
        call.enqueue(new Callback<DataBean>() {
            @Override
            public void onResponse(Call<DataBean> call, Response<DataBean> response) {
                bean = response.body();
                if(bean != null){
                    Log.d("Bean", bean.toString());
                    primeNumberCounter = bean.getPrimeNum();
                    time = bean.getTime();
                    Log.d("Data 1", primeNumberCounter +" - "+ time);
                } else {
                    Log.d("Error", "Object is Null");
                }
            }

            @Override
            public void onFailure(Call<DataBean> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
        Log.d("Data 2", primeNumberCounter +" - "+ time);
    }

    long getPrimeNum() {
        return primeNumberCounter;
    }

    String getTime() {
        return time;
    }
}
