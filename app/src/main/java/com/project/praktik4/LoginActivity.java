package com.project.praktik4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.lights.LightState;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnLogin;
    String filepath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        filepath = "MyFileDir";

        btnLogin.setOnClickListener(view -> {
            String username, password;
            username = etUsername.getText().toString();
            password = etPassword.getText().toString();
            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(LoginActivity.this, "input tidak boleh kosong", Toast.LENGTH_LONG).show();
            }else{
                cekDataLogin(username, password);
            }
        });
    }

    private void cekDataLogin(String username, String password){
        boolean found = false;
        String usernameData[] = {"wirda","nana","moana"};
        String passwordData[] = {"w123","n123","m123"};

        for(int i=0; i<usernameData.length; i++){
            if(usernameData[i].equals(username) && passwordData[i].equals(password)){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                found = true;
                break;
            }
        }

        if(!found){
            Toast.makeText(this, "Login gagal, username/password salah", Toast.LENGTH_SHORT).show();
        }
    }

}