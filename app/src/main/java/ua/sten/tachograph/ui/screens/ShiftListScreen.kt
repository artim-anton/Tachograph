package ua.sten.tachograph.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ua.sten.tachograph.data.room.Shift
import ua.sten.tachograph.ui.viewmodels.ShiftViewModel

@Composable
fun ShiftListItem(
    shift: Shift
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Column {
                Text(
                    text = "timeStart: ${shift.timeStart}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = "timeStop: ${shift.timeStop}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun ShiftList(
    shifts: List<Shift>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
    ) {
        items(shifts) { shift ->
            ShiftListItem(
                shift = shift
            )
        }
    }
}

@Composable
fun CountryListScreen(
) {
    val viewModel: ShiftViewModel = viewModel()
    val shifts by viewModel.shifts.collectAsState(emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        ShiftList(
            shifts = shifts
        )
    }
}