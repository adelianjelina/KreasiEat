package com.adelia.kreasieat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adelia.kreasieat.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.etUsername.getText().toString();
                String password = binding.etPassword.getText().toString();
                String konfirmasiPassword = binding.etKonfirmasiPassword.getText().toString();

                boolean bolehRegister = true;
                if (TextUtils.isEmpty(username)) {
                    bolehRegister = false;
                    binding.etUsername.setError("Username tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(password)) {
                    bolehRegister = false;
                    binding.etPassword.setError("Password tidak boleh kosong!");
                }
                if (TextUtils.isEmpty(konfirmasiPassword)) {
                    bolehRegister = false;
                    binding.etKonfirmasiPassword.setError("Konfirmasi password tidak boleh kosong");
                }
                if (!password.equals(konfirmasiPassword)) {
                    bolehRegister = false;
                    binding.etKonfirmasiPassword.setError("Konfirmasi password tidak sama dengan password");
                }
                if (password.length() <6) {
                    bolehRegister = false;
                    binding.etPassword.setError("Password minimal 6 karakter");
                }

                if (bolehRegister) {
                    register(username, password);
                }
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void register(String username, String password) {
        binding.progressBar.setVisibility(View.VISIBLE);
        Toast.makeText(RegisterActivity.this, "Register success!", Toast.LENGTH_SHORT).show();
        Utilities.setValue(RegisterActivity.this, "xUsername", username);
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        binding.progressBar.setVisibility(View.GONE);
    }
}
