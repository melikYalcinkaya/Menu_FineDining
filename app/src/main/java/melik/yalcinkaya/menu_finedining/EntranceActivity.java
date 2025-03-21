package melik.yalcinkaya.menu_finedining;

import android.content.Context;
import android.os.Bundle;
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
    }
}
