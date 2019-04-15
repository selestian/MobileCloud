package com.selestian.mobilecloud;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ConnectionMethod {
    @POST("index.php")
    Call<DataBean> getData();
}
    <?php
            $start_time = microtime(true);
    $MAX = 100000;
            $response = array();

            function calcPrimeNum($limit) {
            $i = 0;
            $counter = 0;
            while (++$i <= $limit) {
            if (isPrimeNum($i)) {
            $counter++;
            }
            }
            return $counter;
            }

            function isPrimeNum($num){
            if ($num <= 1)
            return false;
            $check = ceil(sqrt($num));
            for ($i = 2; $i < $check; $i++) {
        if ($num % $i === 0)
        return false;
        }
        return true;
        }

        $response['primeNum'] = calcPrimeNum($MAX);

        $end_time = microtime(true);
        $response['time'] = ($end_time - $start_time);

        echo json_encode($response);
        ?>