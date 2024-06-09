package ua.sten.tachograph.data.repository

import kotlinx.coroutines.flow.Flow
import ua.sten.tachograph.data.room.Shift
import ua.sten.tachograph.data.room.ShiftDao
import javax.inject.Inject


class ShiftRepository @Inject constructor(
    private val countryDao: ShiftDao
) {
    fun getShifts(): Flow<List<Shift>> = countryDao.getAllShifts()

    suspend fun addShift(shift: Shift) {
        countryDao.insertShift(shift)
    }

    suspend fun removeShift(shift: Shift) {
        countryDao.deleteShift(shift)
    }

    private fun List<Shift>.toCountryList(): List<Shift> {
        return this.map {
            Shift(
                timeStart = "1",
                timeStop = "2"
            )
        }
    }
}