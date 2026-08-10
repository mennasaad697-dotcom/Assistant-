package com.teacherassistant.ui.payments

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.teacherassistant.R

class PaymentsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)

        val fabAddPayment = findViewById<FloatingActionButton>(R.id.fabAddPayment)

        fabAddPayment?.setOnClickListener {
            Toast.makeText(this, "تسجيل دفعة جديدة أو اشتراك للطالب", Toast.LENGTH_SHORT).show()
            // هنا سي يتم حفظ المدفوعات محلياً ومزامنتها لاحقاً
        }
    }
}

