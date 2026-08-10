package com.teacherassistant.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.google.firebase.auth.FirebaseAuth
import com.teacherassistant.R

class HomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // أزرار لوحة التحكم الرئيسية
        val cardStudents = findViewById<MaterialCardView>(R.id.cardStudents)
        val cardAttendance = findViewById<MaterialCardView>(R.id.cardAttendance)
        val cardGroups = findViewById<MaterialCardView>(R.id.cardGroups)
        val cardPayments = findViewById<MaterialCardView>(R.id.cardPayments)

        cardStudents?.setOnClickListener {
            Toast.makeText(this, "إدارة الطلاب", Toast.LENGTH_SHORT).show()
            // هنا سيتم فتح شاشة الطلاب
        }

        cardAttendance?.setOnClickListener {
            Toast.makeText(this, "سجل الحضور والغياب", Toast.LENGTH_SHORT).show()
            // هنا سيتم فتح شاشة الحضور
        }

        cardGroups?.setOnClickListener {
            Toast.makeText(this, "إدارة المجموعات", Toast.LENGTH_SHORT).show()
        }

        cardPayments?.setOnClickListener {
            Toast.makeText(this, "المدفوعات والحسابات", Toast.LENGTH_SHORT).show()
        }
    }
}

