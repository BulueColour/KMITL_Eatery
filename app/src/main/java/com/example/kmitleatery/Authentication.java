package com.example.kmitleatery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Authentication extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // ชี้ไปที่ activity.xml ให้เอามาแสดง UI

        // เชื่อมกับช่องกรอก username password ใน .xml
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // เมื่อกดปุ่ม Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        // ตรวจสอบว่ากรอกครบหรือยัง
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ", Toast.LENGTH_SHORT).show();
            return;
        }

        // Login สำเร็จ ไม่ได้เช้คจริงๆ
        Toast.makeText(this, "เข้าสู่ระบบสำเร็จ", Toast.LENGTH_SHORT).show();

        // กดปุ่มแล้วไปหน้าเมนู
        Intent intent = new Intent(Authentication.this, Menu.class);
        startActivity(intent);
        finish();
    }
}