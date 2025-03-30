package melik.yalcinkaya.menu_finedining;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private List<MenuItem> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Durum çubuğunu siyah yap
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.BLACK);

        // İkonları beyaz yap
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menuList = new ArrayList<>();
        menuList.add(new MenuItem("🍽 Geleneksel Kahvaltı", true));
        menuList.add(new MenuItem("Serpme Kahvaltı",false));
        menuList.add(new MenuItem("Köy Kahvaltısı",false));

        menuList.add(new MenuItem("🔥 Sıcak Kahvaltılar", true));
        menuList.add(new MenuItem("Menemen",false));
        menuList.add(new MenuItem("Omlet Çeşitleri",false));

        menuList.add(new MenuItem("🍰 Tatlılar", true));
        menuList.add(new MenuItem("Bal Kaymak",false));
        menuList.add(new MenuItem("Çikolatalı Krep",false));

        menuList.add(new MenuItem("🥤 İçecekler", true));
        menuList.add(new MenuItem("Taze Sıkılmış Portakal Suyu",false));
        menuList.add(new MenuItem("Türk Kahvesi",false));

        adapter = new MenuAdapter(menuList);
        recyclerView.setAdapter(adapter);




    }
}