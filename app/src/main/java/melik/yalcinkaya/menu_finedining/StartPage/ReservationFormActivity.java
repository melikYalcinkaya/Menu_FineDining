package melik.yalcinkaya.menu_finedining.StartPage;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import melik.yalcinkaya.menu_finedining.R;
import java.util.Calendar;

public class ReservationFormActivity extends AppCompatActivity {

    private EditText nameInput, emailInput, phoneInput;
    private EditText dateInput, timeInput;
    private Button   nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);

        nameInput  = findViewById(R.id.editTextName);
        emailInput = findViewById(R.id.editTextEmail);
        phoneInput = findViewById(R.id.editTextPhone);
        dateInput  = findViewById(R.id.editTextDate);
        timeInput  = findViewById(R.id.editTextTime);
        nextButton = findViewById(R.id.buttonNext);

        // Date picker dialog
        dateInput.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new DatePickerDialog(this,
                    (DatePicker view, int y, int m, int d) -> {
                        // month is 0-based
                        String date = String.format("%02d/%02d/%04d", d, m + 1, y);
                        dateInput.setText(date);
                    },
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            ).show();
        });

        // Time picker dialog
        timeInput.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new TimePickerDialog(this,
                    (TimePicker view, int hour, int minute) -> {
                        String time = String.format("%02d:%02d", hour, minute);
                        timeInput.setText(time);
                    },
                    c.get(Calendar.HOUR_OF_DAY),
                    c.get(Calendar.MINUTE),
                    true
            ).show();
        });

        nextButton.setOnClickListener(v -> {
            String name  = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String phone = phoneInput.getText().toString().trim();
            String date  = dateInput.getText().toString().trim();
            String time  = timeInput.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || date.isEmpty() || time.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                return;
            }


        });
    }
}
