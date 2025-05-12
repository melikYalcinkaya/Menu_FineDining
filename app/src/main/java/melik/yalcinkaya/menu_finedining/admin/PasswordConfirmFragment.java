package melik.yalcinkaya.menu_finedining.admin;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
        return inflater.inflate(R.layout.fragment_password_confirm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Make dialog background transparent
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().setDimAmount(0.7f); // Optional dim effect
        }

        passwordInput = view.findViewById(R.id.password_input);
        confirmButton = view.findViewById(R.id.confirm_button);
        backButton = view.findViewById(R.id.back_button);

        confirmButton.setOnClickListener(v -> {
            String enteredPassword = passwordInput.getText().toString();
            if ("1234".equals(enteredPassword)) {
                Intent intent = new Intent(getActivity(), AdminMainFragment.class);
                startActivity(intent);
            } else {
                Toast.makeText(getActivity(), "Wrong password!", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(v -> dismiss());

    }
}
