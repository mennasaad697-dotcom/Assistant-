package com.teacherassistant.ui.attendance

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teacherassistant.R

class AttendanceScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        val btnScanQr = findViewById<Button>(R.id.btnScanQr)
        val btnManualAttendance = findViewById<Button>(R.id.btnManualAttendance)

        btnScanQr?.setOnClickListener {
            Toast.makeText(this, "فتح مسح الـ QR للتسجيل السريع", Toast.LENGTH_SHORT).show()
            // هنا سيتم فتح الكاميرا لمسح كود الطالب وتسجيل الحضور محلياً
        }

        btnManualAttendance?.setOnClickListener {
            Toast.makeText(this, "تسجيل الحضور اليدوي", Toast.LENGTH_SHORT).show()
            // هنا سيتم عرض قائمة الطلاب لتسجيل (حاضر / غياب / متأخر)
        }
    }
}
