package com.example.lorealbrandstorm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setăm un Handler pentru a face tranziția după 3 secunde
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // După 3 secunde, deschidem AuthActivity
                Intent intent = new Intent(MainActivity.this, AuthActivity.class);
                startActivity(intent);
                finish();  // Închidem MainActivity astfel încât să nu putem reveni la ea
            }
        }, 3000);  // 3000 milisecunde = 3 secunde
    }
}
