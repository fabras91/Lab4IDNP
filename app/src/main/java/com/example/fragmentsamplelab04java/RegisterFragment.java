package com.example.fragmentsamplelab04java;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    private OnUserCreatedListener listener;

    public RegisterFragment()  {
        // Required empty public constructor
    }
    public static RegisterFragment newInstance(OnUserCreatedListener listener){
        RegisterFragment registerFragment = new RegisterFragment();
        registerFragment.listener = listener;
        return registerFragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view =inflater.inflate(R.layout.fragment_register,container,false);
        EditText edtNames = view.findViewById(R.id.edtName);
        EditText edtEmail = view.findViewById(R.id.edtEmail);
        EditText edtPhone = view.findViewById(R.id.edtPhone);
        EditText edtUser = view.findViewById(R.id.edtUser);
        EditText edtPassword = view.findViewById(R.id.edtPassword);
        Button btnAceptar = view.findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(v -> {
            String name = edtNames.getText().toString();
            String email = edtEmail.getText().toString();
            String phone = edtPhone.getText().toString();
            String username = edtUser.getText().toString();
            String password = edtPassword.getText().toString();
            User user = new User(name, email, phone, username, password);
            if (listener != null) {
                listener.onUserCreated(user);
            }
        });
        return view;
    }
    public interface OnUserCreatedListener {
        void onUserCreated(User user);
    }
}