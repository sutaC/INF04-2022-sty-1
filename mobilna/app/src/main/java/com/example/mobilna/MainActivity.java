package com.example.mobilna;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvMsg;
    private EditText etEmail, etPassword, etRepeatPassword;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvMsg = findViewById(R.id.tvMsg);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRepeatPassword = findViewById(R.id.etRepeatPassword);
        btnConfirm = findViewById(R.id.btnConfirm);

//        Listeners
        btnConfirm.setOnClickListener(e -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String rPassword = etRepeatPassword.getText().toString();
            if(email.indexOf('@') == -1){
                tvMsg.setText("Nieprawidłowy adres e-mail");
                return;
            }
            if(!password.equals(rPassword)){
                tvMsg.setText("Hasła się różnią");
                return;
            }
            tvMsg.setText("Witaj " + email);
        });
    }
}