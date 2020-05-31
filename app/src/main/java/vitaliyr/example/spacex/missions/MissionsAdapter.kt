package vitaliyr.example.spacex.missions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vitaliyr.example.spacex.R
import vitaliyr.example.spacex.dtos.Missions

class MissionsAdapter: RecyclerView.Adapter<ViewHolder>() {
    var data = listOf<Missions>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.missions_lsit, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

    }
}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val missionName = itemView.findViewById<TextView>(R.id.mission_name)
}