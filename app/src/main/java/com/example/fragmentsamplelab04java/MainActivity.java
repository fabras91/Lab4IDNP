package com.example.fragmentsamplelab04java;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private TextView txtNames;
    private TextView txtEmail;
    private TextView txtPhone;
    private TextView txtUser;
    private TextView txtPassword;

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

        txtNames = findViewById(R.id.textName);
        txtEmail = findViewById(R.id.textEmail);
        txtPhone = findViewById(R.id.textPhone);
        txtUser = findViewById(R.id.textUsuario);
        txtPassword = findViewById(R.id.textPassword);

        RegisterFragment.OnUserCreatedListener listener = user -> {

            txtNames.setText(user.getName());
            txtEmail.setText(user.getEmail());
            txtPhone.setText(user.getPhone());
            txtUser.setText(user.getUsername());
            txtPassword.setText(user.getPassword());
        };
        RegisterFragment registerFragment = RegisterFragment.newInstance(listener);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, registerFragment);
        transaction.commit();
    }
}