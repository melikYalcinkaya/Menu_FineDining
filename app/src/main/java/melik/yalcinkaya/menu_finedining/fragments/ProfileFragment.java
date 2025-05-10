package melik.yalcinkaya.menu_finedining.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import melik.yalcinkaya.menu_finedining.fragments.EntranceActivity;
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

        // Set click listener for language change button
        btnChangeLanguage.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EntranceActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            getActivity().finish();
        });

        // Set other button click listeners
        btnEditProfile.setOnClickListener(v -> {
            // Handle edit profile
        });

        btnLogout.setOnClickListener(v -> {
            // Handle logout
        });

        // Add this code inside onCreateView after initializing views
        SharedPreferences prefs = requireActivity().getSharedPreferences("AppPreferences", 0);
        String lang = prefs.getString("selected_language", "en");

            // Set button texts based on language
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


        return view;
    }
}