package com.example.lab4.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab4.data.entities.TaskEntity

@Database(
    entities = [ TaskEntity::class ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}