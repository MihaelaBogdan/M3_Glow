package com.example.lorealbrandstorm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity);

        // Verifică dacă utilizatorul a fost deja autentificat
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            // Dacă utilizatorul este deja autentificat, deschide pagina principală
            openMainPage();
        }
    }

    // Metodă pentru autentificare
    public void login(View view) {
        // Preia datele din câmpuri
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Verifică dacă sunt corecte (într-un caz real, verificați cu serverul)
        if (username.equals("user") && password.equals("password")) {
            // Salvăm starea de autentificare în SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", true);
            editor.apply();

            // Deschide pagina principală
            openMainPage();
        } else {
            // Afișează un mesaj de eroare
            Toast.makeText(this, "Autentificare eșuată", Toast.LENGTH_SHORT).show();
        }
    }

    // Navigare la pagina principală
    private void openMainPage() {
        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Închide activitatea de autentificare
    }
}
