package ua.sten.tachograph.data.room

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shifts")
@Immutable
class Shift (
    @PrimaryKey
    var id: String,
    var timeStart: String,
    var timeStop: String,
)