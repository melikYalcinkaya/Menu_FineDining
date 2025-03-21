package melik.yalcinkaya.menu_finedining;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class EntranceActivity extends AppCompatActivity {

    Spinner spinner_languages;
    String languages [] = new String[]{"Türkçe", "English", "Arabic"};
    Context context = this;
    ArrayAdapter<String> languages_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_entrance); // entrance_layout.xml'i bağlama
        spinner_languages = findViewById(R.id.spinner); // spinner_id'sini tanımlama
        languages_adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, languages);
        spinner_languages.setAdapter(languages_adapter);

        //spinner_languages.setSelection(1);



        // Seçim dinleyicisini ekleyelim
        spinner_languages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedLanguage = languages[position];

                if (selectedLanguage.equals("English")) {
                    // English seçildiğinde MainActivity'ye geç
                    Intent intent = new Intent(EntranceActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Seçim yapılmadığında hiçbir şey yapma
            }
        });


    }
}
