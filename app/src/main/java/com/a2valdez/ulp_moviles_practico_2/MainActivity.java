package com.a2valdez.ulp_moviles_practico_2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.a2valdez.ulp_moviles_practico_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        binding.btConvetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.convertirMoneda(
                    binding.etEuros.getText().toString(),
                    binding.etDolares.getText().toString(),
                    binding.rbDolaresEuros.isChecked(),
                    binding.rbEurosDolares.isChecked()
                );
            }
        });
        mv.getmCambio().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double cambio) {
                binding.etCambio.setText(String.format("%.02f", cambio));
            }
        });
        binding.rbDolaresEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEuros.setText("");
                binding.etDolares.setText("");
                binding.etCambio.setText("");
                binding.etEuros.setEnabled(false);
                binding.etDolares.setEnabled(true);
                binding.etDolares.requestFocus();
            }
        });
        binding.rbEurosDolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEuros.setText("");
                binding.etDolares.setText("");
                binding.etCambio.setText("");
                binding.etDolares.setEnabled(false);
                binding.etEuros.setEnabled(true);
                binding.etEuros.requestFocus();
            }
        });
    }
}