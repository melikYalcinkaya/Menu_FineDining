package melik.yalcinkaya.menu_finedining.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

import melik.yalcinkaya.menu_finedining.R;

public class ReservationFragment extends Fragment {

    private EditText nameInput, emailInput, phoneInput;
    private EditText dateInput, timeInput;
    private Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);

        nameInput  = view.findViewById(R.id.editTextName);
        emailInput = view.findViewById(R.id.editTextEmail);
        phoneInput = view.findViewById(R.id.editTextPhone);
        dateInput  = view.findViewById(R.id.editTextDate);
        timeInput  = view.findViewById(R.id.editTextTime);
        nextButton = view.findViewById(R.id.buttonNext);

        dateInput.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new DatePickerDialog(requireContext(),
                    (DatePicker view1, int y, int m, int d) -> {
                        String date = String.format("%02d/%02d/%04d", d, m + 1, y);
                        dateInput.setText(date);
                    },
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            ).show();
        });

        timeInput.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new TimePickerDialog(requireContext(),
                    (TimePicker view12, int hour, int minute) -> {
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
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(requireContext(), "Please enter a valid email", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
