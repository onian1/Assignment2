package com.example.quiz2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class TimerFragment : Fragment() {

    private lateinit var timerTextView: TextView
    private lateinit var startButton: Button
    private lateinit var resetButton: Button
    private var timeInSeconds: Int = 0
    private var isRunning = false
    private val handler = Handler(Looper.getMainLooper())
    private val timerRunnable = object : Runnable {
        override fun run() {
            if (isRunning) {
                timeInSeconds++
                updateTimer()
                handler.postDelayed(this, 1000) // Update every second
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_timer, container, false)

        timerTextView = rootView.findViewById(R.id.timerTextView)
        startButton = rootView.findViewById(R.id.startButton)
        resetButton = rootView.findViewById(R.id.resetButton)

        // Start button logic
        startButton.setOnClickListener {
            if (isRunning) {
                isRunning = false
                startButton.text = "Start"
            } else {
                isRunning = true
                startButton.text = "Pause"
                handler.post(timerRunnable) // Start the timer
            }
        }

        // Reset button logic
        resetButton.setOnClickListener {
            isRunning = false
            timeInSeconds = 0
            updateTimer()
            startButton.text = "Start"
        }

        return rootView
    }

    private fun updateTimer() {
        val minutes = timeInSeconds / 60
        val seconds = timeInSeconds % 60
        val timeString = String.format("%02d:%02d", minutes, seconds)
        timerTextView.text = timeString
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(timerRunnable) // Stop the timer if the fragment is destroyed
    }
}
