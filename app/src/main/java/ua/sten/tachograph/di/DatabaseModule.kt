package ua.sten.tachograph.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.sten.tachograph.data.room.ShiftDao
import ua.sten.tachograph.data.room.TachographAppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: TachographAppDatabase.Callback): TachographAppDatabase{
        return Room.databaseBuilder(application, TachographAppDatabase::class.java, "tachograph_app_database")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideArticleDao(db: TachographAppDatabase): ShiftDao {
        return db.countryDao()
    }
}