package melik.yalcinkaya.menu_finedining.fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.databinding.ActivityRegistrationBinding;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegistrationActivity extends AppCompatActivity {

    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DatabaseReference mDatabase;
// ...
        mDatabase = FirebaseDatabase.getInstance().getReference();

        binding.registerSaveButton.setOnClickListener(view -> {
            // Buraya Firebase'e veri yazma işlemi eklenebilir
            String name = binding.registerNameText.getText().toString();
            String email = binding.registerEmailText.getText().toString();
            String password = binding.registerPasswordText.getText().toString();
            mDatabase.child("users").child(name).child("email").setValue(email)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show();
                    });
            mDatabase.child("users").child(name).child("password").setValue(password)
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Kayıt başarısız: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        });


        binding.registerButton.setOnClickListener(view -> {
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
        });

    }
}