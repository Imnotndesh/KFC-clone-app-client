package com.example.kfc_sample_client;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class main_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView signUpTextBottom;
        FragmentContainerView loginPages;
        FragmentManager fragmentManager;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_login);
        signUpTextBottom = findViewById(R.id.signUpText);
        fragmentManager = getSupportFragmentManager();
        signUpTextBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new SignUpSection();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.loginPagesContainer, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                signUpTextBottom.setText("Already Have an Account? Click here to login");
            }
        });
    }
}