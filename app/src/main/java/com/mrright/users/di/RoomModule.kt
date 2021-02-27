package com.mrright.users.di

import android.content.Context
import androidx.room.Room
import com.mrright.users.db.UserDatabase
import com.mrright.users.db.UserDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {


    @Provides
    @Singleton
    fun provideUserDataBase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context, UserDatabase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase) = userDatabase.userDao()


}














