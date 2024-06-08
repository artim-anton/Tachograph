package ua.sten.tachograph.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.sten.tachograph.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Shift::class], version = 1)
abstract class TachographAppDatabase : RoomDatabase() {
    abstract fun countryDao(): ShiftDao

    class Callback @Inject constructor(
        private val database: Provider<TachographAppDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}
