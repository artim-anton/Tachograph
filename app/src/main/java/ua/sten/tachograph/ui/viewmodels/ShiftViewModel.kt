package ua.sten.tachograph.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ua.sten.tachograph.data.repository.ShiftRepository
import ua.sten.tachograph.data.room.Shift
import javax.inject.Inject

@HiltViewModel
class ShiftViewModel@Inject constructor(
    private val repository: ShiftRepository
) : ViewModel() {
    val shifts: Flow<List<Shift>> = repository.getShifts()

    fun addShifts(shift: Shift) {
        viewModelScope.launch {
            repository.addShift(shift)
        }
    }

    fun removeShifts(shift: Shift) {
        viewModelScope.launch {
            repository.removeShift(shift)
        }
    }
}