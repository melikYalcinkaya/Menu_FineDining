package melik.yalcinkaya.menu_finedining.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import melik.yalcinkaya.menu_finedining.MainActivity;
import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.admin.PasswordConfirmFragment;

public class EntranceActivity extends AppCompatActivity {

    private Spinner spinner;
    private ImageView imageViewAdmin;
    private String[] languageCodes;
    private String[] languageDisplayNames;
    private boolean firstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        // Initialize views
        spinner = findViewById(R.id.spinner);
        imageViewAdmin = findViewById(R.id.imageView3);

        // Setup languages
        languageDisplayNames = getResources().getStringArray(R.array.language_display_names);
        languageCodes = getResources().getStringArray(R.array.language_codes);

        // Setup spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                languageDisplayNames
        );
        spinner.setAdapter(adapter);

        // Set current language without triggering navigation
        String currentLang = getSavedLanguage();
        for (int i = 0; i < languageCodes.length; i++) {
            if (languageCodes[i].equals(currentLang)) {
                spinner.setSelection(i, false);
                break;
            }
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (firstSelection) {
                    firstSelection = false;
                    return;
                }

                String selectedLanguageCode = languageCodes[position];
                setAppLocale(selectedLanguageCode);
                saveLanguagePreference(selectedLanguageCode);

                // Navigate to MainActivity
                startActivity(new Intent(EntranceActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        imageViewAdmin.setOnClickListener(v -> {
            PasswordConfirmFragment passwordDialog = new PasswordConfirmFragment();
            passwordDialog.show(getSupportFragmentManager(), "password_dialog");
        });
    }

    private void setAppLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

    private void saveLanguagePreference(String languageCode) {
        getSharedPreferences("AppPreferences", MODE_PRIVATE)
                .edit()
                .putString("selected_language", languageCode)
                .apply();
    }

    private String getSavedLanguage() {
        return getSharedPreferences("AppPreferences", MODE_PRIVATE)
                .getString("selected_language", "en");
    }
}