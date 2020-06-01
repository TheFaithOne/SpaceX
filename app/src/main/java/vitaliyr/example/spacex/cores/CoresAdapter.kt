package vitaliyr.example.spacex.cores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import vitaliyr.example.spacex.databinding.CoresListBinding
import vitaliyr.example.spacex.dtos.CoresDTO

class CoresAdapter: ListAdapter<CoresDTO, ViewHolder>(CoresDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


}

class ViewHolder private constructor(val binding: CoresListBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(item: CoresDTO) {
        binding.core = item
        binding.originalLaunch.text
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = CoresListBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }
    }


}

class CoresDiffCallback: DiffUtil.ItemCallback<CoresDTO>(){
    override fun areItemsTheSame(oldItem: CoresDTO, newItem: CoresDTO): Boolean {
        return oldItem.coreSerial == newItem.coreSerial
    }

    override fun areContentsTheSame(oldItem: CoresDTO, newItem: CoresDTO): Boolean {
        return oldItem == newItem
    }
}