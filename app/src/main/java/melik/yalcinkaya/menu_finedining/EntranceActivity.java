package melik.yalcinkaya.menu_finedining;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import melik.yalcinkaya.menu_finedining.StartPage.PasswordConfirmFragment;

public class EntranceActivity extends AppCompatActivity {
    Spinner spinner_languages;
    String languages[] = new String[]{"Türkçe", "English", "Arabic"};
    Context context = this;
    ArrayAdapter<String> languages_adapter;
    ImageView imageView; // don't initialize here!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_entrance); // correct spelling? acitivity_entrance?

        spinner_languages = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView3); // moved inside onCreate after setContentView

        languages_adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, languages);
        spinner_languages.setAdapter(languages_adapter);

        spinner_languages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedLanguage = languages[position];

                if (selectedLanguage.equals("English")) {
                    Intent intent = new Intent(EntranceActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });

        imageView.setOnClickListener(v -> {
            PasswordConfirmFragment passwordDialog = new PasswordConfirmFragment();
            passwordDialog.show(getSupportFragmentManager(), "password_dialog");
        });
    }
}
