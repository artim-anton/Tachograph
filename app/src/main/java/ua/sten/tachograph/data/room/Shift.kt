package ua.sten.tachograph.data.room

import androidx.compose.runtime.Stable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shifts")
@Stable
class Shift (
    @PrimaryKey
    var timeStart: String,
    var timeStop: String?,
)