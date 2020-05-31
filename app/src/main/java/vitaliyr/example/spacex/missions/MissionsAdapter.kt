package vitaliyr.example.spacex.missions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import vitaliyr.example.spacex.databinding.MissionsLsitBinding
import vitaliyr.example.spacex.dtos.MissionsDTO

class MissionsAdapter(val clickListener: MissionListener) :
    androidx.recyclerview.widget.ListAdapter<MissionsDTO, ViewHolder>(MissionsDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
        holder.bind(getItem(position), clickListener)

    }


}

class ViewHolder(val binding: MissionsLsitBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: MissionsDTO,
        clickListener: MissionListener
    ) {
        //binding.missionName.text = item.mission_name
        binding.missionId = item
        binding.clickListener = clickListener
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = MissionsLsitBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }
    }
}

class MissionsDiffCallback : DiffUtil.ItemCallback<MissionsDTO>() {
    override fun areItemsTheSame(oldItem: MissionsDTO, newItem: MissionsDTO): Boolean {
        return oldItem.missionId == newItem.missionId
    }

    override fun areContentsTheSame(oldItem: MissionsDTO, newItem: MissionsDTO): Boolean {
        return oldItem == newItem
    }
}

class MissionListener(val clickListener: (missionId: String) -> Unit){
    fun onClick(mission: MissionsDTO) = clickListener(mission.missionId)
}