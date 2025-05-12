package melik.yalcinkaya.menu_finedining.admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.admin.fragments.AdminHomeFragment;
import melik.yalcinkaya.menu_finedining.admin.fragments.AdminMenuFragment;
import melik.yalcinkaya.menu_finedining.admin.fragments.AdminCustomerFragment;

public class AdminMainFragment extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        bottomNavigationView = findViewById(R.id.admin_bottom_navigation);

        // Load default fragment
        loadFragment(new AdminHomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                selectedFragment = new AdminHomeFragment();
            } else if (itemId == R.id.nav_menu) {
                selectedFragment = new AdminMenuFragment();
            } else if (itemId == R.id.nav_customers) {
                selectedFragment = new AdminCustomerFragment();
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
