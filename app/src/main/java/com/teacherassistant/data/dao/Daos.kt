package com.teacherassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teacherassistant.data.entity.StudentEntity
import com.teacherassistant.data.entity.AttendanceEntity

@Dao
interface StudentDao {
    @Query("SELECT * FROM students WHERE workspaceId = :workspaceId AND status = 'active'")
    suspend fun getActiveStudents(workspaceId: String): List<StudentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: StudentEntity)

    @Query("SELECT * FROM students WHERE syncStatus = 1")
    suspend fun getPendingSyncStudents(): List<StudentEntity>

    @Query("UPDATE students SET syncStatus = 0 WHERE studentId = :studentId")
    suspend fun markStudentSynced(studentId: String)
}

@Dao
interface AttendanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendance(attendance: AttendanceEntity)

    @Query("SELECT * FROM attendance WHERE syncStatus = 1")
    suspend fun getPendingSyncAttendance(): List<AttendanceEntity>

    @Query("UPDATE attendance SET syncStatus = 0 WHERE attendanceId = :attendanceId")
    suspend fun markAttendanceSynced(attendanceId: String)
}
