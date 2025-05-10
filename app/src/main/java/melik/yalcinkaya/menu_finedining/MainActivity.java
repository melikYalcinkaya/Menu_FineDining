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
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.fragments.HomeFragment;
import melik.yalcinkaya.menu_finedining.fragments.MenuFragment;
import melik.yalcinkaya.menu_finedining.fragments.ReservationFragment;
import melik.yalcinkaya.menu_finedining.fragments.OrderFragment;
import melik.yalcinkaya.menu_finedining.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

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

        // Status bar customization
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.BLACK);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        // Load default fragment
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.homeFragment) {
                selectedFragment = new HomeFragment();
                setTitle("Home");
            } else if (itemId == R.id.menuFragment) {
                selectedFragment = new MenuFragment();
                setTitle("Menu");
            } else if (itemId == R.id.reservationFragment) {
                selectedFragment = new ReservationFragment();
                setTitle("Reservation");
            } else if (itemId == R.id.orderFragment) {
                selectedFragment = new OrderFragment();
                setTitle("My Orders");
            } else if (itemId == R.id.profileFragment) {
                selectedFragment = new ProfileFragment();
                setTitle("Profile");
            }

            return loadFragment(selectedFragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.admin_fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}