package com.adelia.kreasieat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.adelia.kreasieat.databinding.ActivityUpdateUnggahBinding;

public class UpdateUnggahActivity extends AppCompatActivity {
    private ActivityUpdateUnggahBinding binding;
    private Unggah unggah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateUnggahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        unggah = getIntent().getParcelableExtra("EXTRA_DATA");
        String id = unggah.getId();

        binding.etContent.setText(unggah.getContent());
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = binding.etContent.getText().toString();

                boolean bolehUpdate = true;

                if (TextUtils.isEmpty(content)) {
                    bolehUpdate = false;
                    binding.etContent.setError("Konten tidak boleh kosong!");
                }
                if (bolehUpdate) {
                    updateUnggah(id, content);
                }
            }
        });
    }

    private void updateUnggah(String id, String content) {
        binding.progressBar.setVisibility(View.VISIBLE);
        //memanggil API untuk update
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
