package com.example.kmitleatery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        ImageView imageView = findViewById(R.id.menuImage);
        TextView nameView = findViewById(R.id.menuName);

        TextView receiptMenuName = findViewById(R.id.receiptMenuName);
        TextView receiptMenuPrice = findViewById(R.id.receiptMenuPrice);
        TextView receiptVAT = findViewById(R.id.receiptVAT);
        TextView receiptTotal = findViewById(R.id.receiptTotal);

        Button btnCancel = findViewById(R.id.btnCancel);
        Button btnConfirm = findViewById(R.id.btnConfirm);

        // รับค่าที่ส่งมาจาก Menu
        String menuName = getIntent().getStringExtra("menuName");
        int menuPrice = getIntent().getIntExtra("menuPrice", 0);
        int menuImage = getIntent().getIntExtra("menuImage", 0);

        // แสดงผล
        imageView.setImageResource(menuImage);
        nameView.setText(menuName);

        // คำนวน VAT 80%!!
        double vat = menuPrice * 0.8;
        double total = menuPrice + vat;

        // รายการใบเสร็จ
        receiptMenuName.setText(menuName);
        receiptMenuPrice.setText(menuPrice + " บาท");
        receiptVAT.setText(String.format("%.2f บาท", vat));
        receiptTotal.setText(String.format("%.2f บาท", total));

        // ปุ่มยกเลิก
        btnCancel.setOnClickListener(v -> {
            Intent intent = new Intent(Checkout.this, Menu.class);
            startActivity(intent);
            finish();
        });

        // ปุ่มยืนยัน
        btnConfirm.setOnClickListener(v -> {
            Intent intent = new Intent(Checkout.this, Success.class);
            startActivity(intent);
            finish();
        });
    }
}