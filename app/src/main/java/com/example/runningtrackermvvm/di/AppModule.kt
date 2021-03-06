package com.example.runningtrackermvvm.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.example.runningtrackermvvm.other.Constants.RUNNING_DATABASE_NAME
import com.example.runningtrackermvvm.db.RunningDatabase
import com.example.runningtrackermvvm.other.Constants.KEY_FIRST_TIME_TOGGLE
import com.example.runningtrackermvvm.other.Constants.KEY_NAME
import com.example.runningtrackermvvm.other.Constants.KEY_WEIGHT
import com.example.runningtrackermvvm.other.Constants.SHARED_PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPreferences(
        @ApplicationContext app: Context
    ) = app.getSharedPreferences(SHARED_PREFERENCES_NAME,MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(sharedpref: SharedPreferences) = sharedpref.getString(KEY_NAME,"")?:""

    @Singleton
    @Provides
    fun provideWeight(sharedpref: SharedPreferences) = sharedpref.getFloat(KEY_WEIGHT,80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedpref: SharedPreferences) = sharedpref.getBoolean(
        KEY_FIRST_TIME_TOGGLE,true)
}