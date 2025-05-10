package melik.yalcinkaya.menu_finedining;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import melik.yalcinkaya.menu_finedining.StartPage.ReservationFormActivity;
import melik.yalcinkaya.menu_finedining.R;

public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private Button buttonReservation;
    private Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inset handling (unchanged)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Status bar styling (unchanged)
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.BLACK);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        setTitle("Home");

        // NavController setup
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        } else {
            throw new NullPointerException("NavHostFragment is null!");
        }

        // Wire up your two buttons
        buttonReservation = findViewById(R.id.button_make_reservation);
        buttonMenu        = findViewById(R.id.button_view_menu);

        // Launch the reservation form
        buttonReservation.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ReservationFormActivity.class));
        });

        // Navigate to DishesFragment directly by ID
        buttonMenu.setOnClickListener(v -> {
            navController.navigate(R.id.dishesFragment);
        });

        // Hide/show buttons based on destination
        navController.addOnDestinationChangedListener((controller, destination, args) -> {
            if (destination.getId() == R.id.dishesFragment) {
                buttonMenu.setVisibility(View.GONE);
                buttonReservation.setVisibility(View.GONE);
            } else {
                buttonMenu.setVisibility(View.VISIBLE);
                buttonReservation.setVisibility(View.VISIBLE);
            }
        });
    }
}
