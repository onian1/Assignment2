package com.example.quiz2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz2.R

class AlarmAdapter(private val alarmList: List<AlarmItem>) : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {

    class AlarmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        val labelTextView: TextView = itemView.findViewById(R.id.labelTextView)
        val statusTextView: TextView = itemView.findViewById(R.id.statusTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarm_layout, parent, false)
        return AlarmViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        val alarmItem = alarmList[position]
        holder.timeTextView.text = alarmItem.time
        holder.labelTextView.text = alarmItem.label
        holder.statusTextView.text = if (alarmItem.isActive) "Active" else "Inactive"
    }

    override fun getItemCount(): Int = alarmList.size
}

data class AlarmItem(
    val time: String,
    val label: String,
    val isActive: Boolean
)