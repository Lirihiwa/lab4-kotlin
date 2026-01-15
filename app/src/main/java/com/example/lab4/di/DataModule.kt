package com.example.lab4.di

import android.content.Context
import androidx.room.Room
import com.example.lab4.data.db.AppDatabase
import com.example.lab4.data.db.TaskDao
import com.example.lab4.data.repository.TaskRepository
import com.example.lab4.data.repository.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) : AppDatabase =
        Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = DB_NAME,
        ).build()

    @Provides
    fun provideTaskDao(db: AppDatabase): TaskDao =
        db.taskDao()

    companion object {

        const val DB_NAME = "todo_db"
    }
}