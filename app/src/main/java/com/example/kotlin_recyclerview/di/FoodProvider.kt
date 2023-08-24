package com.example.kotlin_recyclerview.di

import android.content.Context
import com.example.kotlin_recyclerview.dbServiec.FoodDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FoodProvider {
@Provides
@Singleton
    fun provider(@ApplicationContext context: Context):FoodDatabase{
        return FoodDatabase.getInstance(context)
    }
}