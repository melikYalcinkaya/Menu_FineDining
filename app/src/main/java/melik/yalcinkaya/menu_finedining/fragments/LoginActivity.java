package melik.yalcinkaya.menu_finedining.fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import melik.yalcinkaya.menu_finedining.MainActivity;
import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.databinding.ActivityLoginBinding;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Change status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.my_status_bar_color));
        }

        mDatabase = FirebaseDatabase.getInstance().getReference("users");

        binding.loginButton.setOnClickListener(v -> {
            String enteredEmail = binding.loginEmailText.getText().toString().trim();
            String enteredPassword = binding.loginPasswordText.getText().toString().trim();

            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                return;
            }

            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    DataSnapshot matchedUser = null;

                    for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                        String email = userSnapshot.child("email").getValue(String.class);
                        String password = userSnapshot.child("password").getValue(String.class);

                        if (enteredEmail.equals(email) && enteredPassword.equals(password)) {
                            matchedUser = userSnapshot;
                            break;
                        }
                    }

                    if (matchedUser != null) {
                        String name = matchedUser.getKey(); // Username as key
                        String email = matchedUser.child("email").getValue(String.class);

                        Toast.makeText(LoginActivity.this, "Successful Login!", Toast.LENGTH_SHORT).show();

                        getSharedPreferences("AppPreferences", MODE_PRIVATE)
                                .edit()
                                .putString("user_name", name)
                                .putString("user_email", email)
                                .apply();

                        // ✅ Navigate to MainActivity (home with bottom nav)
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("user_name", name);
                        intent.putExtra("user_email", email);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Incorrect email or password!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(LoginActivity.this, "Failed to fetch data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}