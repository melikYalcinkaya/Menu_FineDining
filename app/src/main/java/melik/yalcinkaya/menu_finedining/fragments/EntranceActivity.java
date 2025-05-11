package melik.yalcinkaya.menu_finedining.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import melik.yalcinkaya.menu_finedining.MainActivity;
import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.admin.PasswordConfirmFragment;

public class EntranceActivity extends AppCompatActivity {

    private Spinner spinner;
    private ImageView imageViewAdmin;
    private String[] languageCodes;
    private boolean isSpinnerInitialized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocaleHelper.applyOverrideConfiguration(this);
        setContentView(R.layout.activity_entrance);

        spinner = findViewById(R.id.spinner);
        imageViewAdmin = findViewById(R.id.imageView3);

        // Setup languages
        languageCodes = getResources().getStringArray(R.array.language_codes);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.language_display_names,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Set current selection
        String currentLang = LocaleHelper.getPersistedLanguage(this);
        for (int i = 0; i < languageCodes.length; i++) {
            if (languageCodes[i].equals(currentLang)) {
                spinner.setSelection(i, false);
                break;
            }
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!isSpinnerInitialized) {
                    isSpinnerInitialized = true;
                    return;
                }

                String selectedLanguage = languageCodes[position];
                Log.d("LanguageSelection", "Selected: " + selectedLanguage);

                handleLanguageSelection(selectedLanguage);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        imageViewAdmin.setOnClickListener(v -> {
            PasswordConfirmFragment passwordDialog = new PasswordConfirmFragment();
            passwordDialog.show(getSupportFragmentManager(), "password_dialog");
        });
    }

    private void handleLanguageSelection(String language) {
        LocaleHelper.setLocale(this, language);

        if (LocaleHelper.isRunningOnEmulator() && "en".equals(language)) {
            // Special handling for English on emulator
            forceEnglishRefresh();
        } else {
            restartApp();
        }
    }

    private void forceEnglishRefresh() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("FORCE_ENGLISH", true);
        startActivity(intent);
        finish();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            recreate();
        }
    }

    private void restartApp() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isSpinnerInitialized = false;
    }
}