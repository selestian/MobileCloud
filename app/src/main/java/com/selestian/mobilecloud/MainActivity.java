package com.selestian.mobilecloud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    private TextView status;
    private Button btnStart;
    private Button btnExit;
    private TextView local;
    private TextView server;
    private DataBean bean = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btn_start);
        status = findViewById(R.id.status);
        status.setVisibility(View.INVISIBLE);
        btnExit = findViewById(R.id.btn_exit);
        local = findViewById(R.id.local);
        server = findViewById(R.id.server);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setVisibility(View.INVISIBLE);
                btnExit.setVisibility(View.INVISIBLE);
                status.setText(getString(R.string.txt_completed));
                status.setVisibility(View.VISIBLE);
                viewData();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }

    public void viewData() {
        LocalCalcThread localCalcThread = new LocalCalcThread();
        localCalcThread.CalculatePrimeNum();
        String txtLocal = localCalcThread.getPrimeNum() + " - " + localCalcThread.getTime();
        local.setText(txtLocal);


        ConnectionMethod method = ConnectionConfig.getApiClient().create(ConnectionMethod.class);
        Call<DataBean> call = method.getData();
        call.enqueue(new Callback<DataBean>() {
            @Override
            public void onResponse(Call<DataBean> call, Response<DataBean> response) {
                bean = response.body();
                if(bean != null){
                    String txtServer = bean.getPrimeNum() + " - " + bean.getTime();
                    server.setText(txtServer);
                } else {
                    Log.d("Error", "Object is Null");
                }
            }

            @Override
            public void onFailure(Call<DataBean> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
