package ua.sten.tachograph.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import ua.sten.tachograph.data.room.Shift
import ua.sten.tachograph.data.room.ShiftDao
import javax.inject.Inject


class ShiftRepository @Inject constructor(
    private val countryDao: ShiftDao
) {
    fun getShifts(): Flow<List<Shift>> = flow {
        val allShifts = countryDao.getAllShifts().first().map { it.id }
    }

    suspend fun addShift(shift: Shift) {
        countryDao.insertShift(shift)
    }

    suspend fun removeShift(shift: Shift) {
        countryDao.deleteShift(shift)
    }

    private fun List<Shift>.toCountryList(): List<Shift> {
        return this.map {
            Shift(
                id = iterator().toString(),
                timeStart = "1",
                timeStop = "2"
            )
        }
    }
}