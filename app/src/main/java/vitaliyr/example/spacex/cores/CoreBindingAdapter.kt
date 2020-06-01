package vitaliyr.example.spacex.cores

import android.widget.TextView
import androidx.databinding.BindingAdapter
import vitaliyr.example.spacex.R
import vitaliyr.example.spacex.dtos.CoresDTO
import java.text.DateFormat

@BindingAdapter("setLaunchTime")
fun TextView.setLaunchTime(item: CoresDTO?){
    item?.let {
        text = DateFormat.getDateTimeInstance().format(item.originalLaunchUnix * 1000)
    }
}






