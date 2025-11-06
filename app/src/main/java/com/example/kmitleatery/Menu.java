package com.example.kmitleatery;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageView btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, Authentication.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        setupMenuItems();
    }

    // เชื่อมกับเมนู
    private void setupMenuItems() {
        setupMenuItem(R.id.menuItem1, "ข้าวผัดแกะ", 120, R.drawable.friedrice);
        setupMenuItem(R.id.menuItem2, "ผัดไทย", 80, R.drawable.padthai);
        setupMenuItem(R.id.menuItem3, "ข้าวขาแมว", 90, R.drawable.porklegrice);
        setupMenuItem(R.id.menuItem4, "เฟรนช์ฟรายส์", 50, R.drawable.frenchfried);
        setupMenuItem(R.id.menuItem5, "ไก่ทอด", 60, R.drawable.friedchicken);
        setupMenuItem(R.id.menuItem6, "ชาไทย", 25, R.drawable.thaitea);
        setupMenuItem(R.id.menuItem7, "กาแฟเย็น", 35, R.drawable.icecoffee);
        setupMenuItem(R.id.menuItem8, "โมจิช็อคโกแลตดูไบ", 55, R.drawable.mojidubai);
        setupMenuItem(R.id.menuItem9, "บราวนี่", 50, R.drawable.brownie);
    }

    private void setupMenuItem(int menuId, String name, int price, int imageResId) {
        LinearLayout menuItem = findViewById(menuId);
        menuItem.setOnClickListener(v -> {
           Intent intent = new Intent(Menu.this, Checkout.class);
           intent.putExtra("menuName", name);
           intent.putExtra("menuPrice", price);
           intent.putExtra("menuImage", imageResId);
           startActivity(intent);
        });
    }
}