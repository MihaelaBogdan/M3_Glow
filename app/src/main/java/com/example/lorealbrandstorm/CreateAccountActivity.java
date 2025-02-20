package com.example.lorealbrandstorm; // Modifică acest lucru cu pachetul corect

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    // Metoda care se apelează când se apasă butonul "Înapoi"
    public void onBackPressed(View view) {
        // Navighează înapoi la activitatea de autentificare
        Intent intent = new Intent(CreateAccountActivity.this, AuthActivity.class);
        startActivity(intent);
        finish(); // Închide activitatea curentă
    }
}
