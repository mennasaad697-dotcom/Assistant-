package com.teacherassistant.ui.reports

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teacherassistant.R

class ReportsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        val btnExportExcel = findViewById<Button>(R.id.btnExportExcel)

        btnExportExcel?.setOnClickListener {
            Toast.makeText(this, "جاري تصدير تقارير الطلاب والحضور محلياً", Toast.LENGTH_SHORT).show()
        }
    }
}

