package com.teacherassistant.ui.students

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.teacherassistant.R

class StudentsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        val fabAddStudent = findViewById<FloatingActionButton>(R.id.fabAddStudent)

        fabAddStudent?.setOnClickListener {
            Toast.makeText(this, "إضافة طالب جديد", Toast.LENGTH_SHORT).show()
            // هنا سيتم فتح نموذج إضافة الطالب وحفظه في قاعدة البيانات المحلية
        }
    }
}

