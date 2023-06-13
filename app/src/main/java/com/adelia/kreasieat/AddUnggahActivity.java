package com.adelia.kreasieat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.adelia.kreasieat.databinding.ActivityAddUnggahBinding;

public class AddUnggahActivity extends AppCompatActivity {
    private ActivityAddUnggahBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddUnggahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = binding.etContent.getText().toString();

                boolean bollehUnggah = true;

                if (TextUtils.isEmpty(content)) {
                    bollehUnggah = false;
                    binding.etContent.setError("Konten tidak boleh kosong!");
                }
                if (bollehUnggah) {
                    String username = Utilities.getValue(AddUnggahActivity.this, "xUsername");
                    addUnggah(username, content);
                }
            }
        });
    }

    private void addUnggah(String username, String content) {
        binding.progressBar.setVisibility(View.VISIBLE);
        //proses untuk mengunggah konten...
        binding.progressBar.setVisibility(View.GONE);
    }
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
