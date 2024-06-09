package ua.sten.tachograph

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Timer
import java.util.TimerTask

class TimerService : Service() {

    private val timer = Timer() // Create a timer object

    override fun onCreate() {
        super.onCreate()
        // Start the timer
        timer.schedule(object : TimerTask() {
            override fun run() {
                val currentTime = LocalDateTime.now()
                val formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                // Displaying the time on the console
                Log.d("Time", "Time: $formattedTime")
            }
        }, 0, 1000) // Delay 0 seconds, interval 1 seconds (1000 milliseconds)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null // We don't connect anything
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel() // Stop the timer before destroying the service
    }
}