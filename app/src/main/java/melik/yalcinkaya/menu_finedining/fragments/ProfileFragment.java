package melik.yalcinkaya.menu_finedining.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import melik.yalcinkaya.menu_finedining.R;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        TextView profileName = view.findViewById(R.id.profile_name);
        TextView profileEmail = view.findViewById(R.id.profile_email);
        Button btnEditProfile = view.findViewById(R.id.btn_edit_profile);
        Button btnLogout = view.findViewById(R.id.btn_logout);
        Button btnChangeLanguage = view.findViewById(R.id.btn_change_language);

        // Set language preferences
        SharedPreferences prefs = requireActivity().getSharedPreferences("AppPreferences", 0);
        String lang = prefs.getString("selected_language", "en");

        if (lang.equals("tr")) {
            btnEditProfile.setText(getString(R.string.edit_profile_tr));
            btnChangeLanguage.setText(getString(R.string.change_language_tr));
            btnLogout.setText(getString(R.string.logout_tr));
        } else if (lang.equals("ar")) {
            btnEditProfile.setText(getString(R.string.edit_profile_ar));
            btnChangeLanguage.setText(getString(R.string.change_language_ar));
            btnLogout.setText(getString(R.string.logout_ar));
        } else {
            btnEditProfile.setText(getString(R.string.edit_profile));
            btnChangeLanguage.setText(getString(R.string.change_language));
            btnLogout.setText(getString(R.string.logout));
        }

        // 🔽 🔽 🔽 Firebase'den kullanıcı verilerini çekme 🔽 🔽 🔽
        // Kullanıcı adını SharedPreferences'tan alalım (login'de kaydettiysen)
        String userName = prefs.getString("user_name", null);

        if (userName != null && !userName.isEmpty()) {
            DatabaseReference userRef = FirebaseDatabase.getInstance()
                    .getReference("users")
                    .child(userName);

            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String updatedName = snapshot.getKey();  // key is the username
                    String updatedEmail = snapshot.child("email").getValue(String.class);

                    profileName.setText(updatedName != null ? updatedName : "Ad bulunamadı");
                    profileEmail.setText(updatedEmail != null ? updatedEmail : "Email bulunamadı");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getActivity(), "Kullanıcı bilgileri alınamadı!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(getActivity(), "Kullanıcı adı bulunamadı!", Toast.LENGTH_SHORT).show();
        }

        // Buton click işlemleri
        btnChangeLanguage.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EntranceFragment.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            getActivity().finish();
        });

        btnEditProfile.setOnClickListener(v -> {
            // Handle edit profile
        });

        btnLogout.setOnClickListener(v -> {
            // Handle logout
        });

        return view;
    }
}
