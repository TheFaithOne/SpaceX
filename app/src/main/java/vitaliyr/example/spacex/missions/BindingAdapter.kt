package vitaliyr.example.spacex.missions

import android.widget.TextView
import androidx.databinding.BindingAdapter
import vitaliyr.example.spacex.dtos.MissionsDTO

@BindingAdapter("setMissionName")
fun TextView.setMissionName(item: MissionsDTO?){
    item?.let {
        text = item.mission_name
    }
}