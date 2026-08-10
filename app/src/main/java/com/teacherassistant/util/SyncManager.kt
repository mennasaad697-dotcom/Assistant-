package com.teacherassistant.util

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.teacherassistant.data.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SyncManager(context: Context) {
    private val database = AppDatabase.getDatabase(context)
    private val firestore = FirebaseFirestore.getInstance()

    suspend fun syncPendingData() {
        withContext(Dispatchers.IO) {
            try {
                // 1. مزامنة الطلاب المعلقين
                val pendingStudents = database.studentDao().getPendingSyncStudents()
                for (student in pendingStudents) {
                    val studentMap = mapOf(
                        "studentId" to student.studentId,
                        "workspaceId" to student.workspaceId,
                        "fullName" to student.fullName,
                        "phone" to student.phone,
                        "parentPhone" to student.parentPhone,
                        "groupName" to student.groupName,
                        "grade" to student.grade,
                        "status" to student.status,
                        "updatedAt" to student.updatedAt
                    )
                    
                    firestore.collection("students")
                        .document(student.studentId)
                        .set(studentMap)
                        .addOnSuccessListener {
                            // تحديث الحالة محلياً إلى متزامن (syncStatus = 0)
                            kotlinx.coroutines.GlobalScope.launch(Dispatchers.IO) {
                                database.studentDao().markStudentSynced(student.studentId)
                            }
                        }
                }

                // 2. مزامنة الحضور المعلق
                val pendingAttendance = database.attendanceDao().getPendingSyncAttendance()
                for (attendance in pendingAttendance) {
                    val attendanceMap = mapOf(
                        "attendanceId" to attendance.attendanceId,
                        "workspaceId" to attendance.workspaceId,
                        "studentId" to attendance.studentId,
                        "groupId" to attendance.groupId,
                        "lessonId" to attendance.lessonId,
                        "date" to attendance.date,
                        "status" to attendance.status,
                        "checkInTime" to attendance.checkInTime,
                        "updatedAt" to attendance.updatedAt
                    )

                    firestore.collection("attendance")
                        .document(attendance.attendanceId)
                        .set(attendanceMap)
                        .addOnSuccessListener {
                            kotlinx.coroutines.GlobalScope.launch(Dispatchers.IO) {
                                database.attendanceDao().markAttendanceSynced(attendance.attendanceId)
                            }
                        }
                }
            } catch (e: Exception) {
                // التعامل مع أخطاء الاتصال بصمت لضمان استمرار عمل التطبيق محلياً
            }
        }
    }
}
