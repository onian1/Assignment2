package com.example.quiz2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz2.R

class AlarmFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var alarmAdapter: AlarmAdapter
    private lateinit var alarmList: List<AlarmItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_alarm, container, false)

        // Initialize the RecyclerView and set the layout manager
        recyclerView = binding.findViewById(R.id.recyclerViewAlarms)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Sample data (replace with actual alarm data if necessary)
        alarmList = listOf(
            AlarmItem("08:00 AM", "Morning Alarm", true),
            AlarmItem("12:00 PM", "Lunch Alarm", false),
            AlarmItem("06:00 PM", "Evening Alarm", true)
        )

        // Set up the adapter
        alarmAdapter = AlarmAdapter(alarmList)
        recyclerView.adapter = alarmAdapter

        return binding
    }
}
