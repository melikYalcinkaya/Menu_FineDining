package melik.yalcinkaya.menu_finedining.StartPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import melik.yalcinkaya.menu_finedining.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PasswordConfirmFragment extends DialogFragment {

    private EditText passwordInput;
    private Button confirmButton, backButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password_confirm, container, false);

        passwordInput = view.findViewById(R.id.password_input);
        confirmButton = view.findViewById(R.id.confirm_button);
        backButton = view.findViewById(R.id.back_button);

        confirmButton.setOnClickListener(v -> {
            String enteredPassword = passwordInput.getText().toString();

            // Example password
            if ("1234".equals(enteredPassword)) {
                Toast.makeText(getActivity(), "Access granted!", Toast.LENGTH_SHORT).show();
                dismiss();
                // TODO: Navigate to Manager Page here
            } else {
                Toast.makeText(getActivity(), "Wrong password!", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(v -> dismiss());

        return view;
    }
}
