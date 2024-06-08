package ua.sten.tachograph.data.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface  ShiftDao {
    @Query("SELECT * FROM shifts")
    fun getAllShifts(): Flow<List<Shift>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShift(shift: Shift)

    @Delete
    suspend fun deleteShift(shift: Shift)
}