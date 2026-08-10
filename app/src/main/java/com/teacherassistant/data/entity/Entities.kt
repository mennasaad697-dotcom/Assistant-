package com.teacherassistant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey
    val studentId: String,
    val workspaceId: String,
    val fullName: String,
    val phone: String?,
    val parentPhone: String?,
    val groupName: String?,
    val grade: String?,
    val status: String = "active", // active, archived
    val syncStatus: Int = 0, // 0: Synced, 1: Pending Sync
    val updatedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "attendance")
data class AttendanceEntity(
    @PrimaryKey
    val attendanceId: String,
    val workspaceId: String,
    val studentId: String,
    val groupId: String,
    val lessonId: String,
    val date: String,
    val status: String, // present, absent, late
    val checkInTime: String?,
    val syncStatus: Int = 0,
    val updatedAt: Long = System.currentTimeMillis()
)

