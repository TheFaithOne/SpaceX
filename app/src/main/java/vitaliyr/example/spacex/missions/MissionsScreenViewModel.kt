package vitaliyr.example.spacex.missions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vitaliyr.example.spacex.dtos.Missions

class MissionsScreenViewModel: ViewModel() {
    private val _missions = MutableLiveData<List<Missions>>()
    val missions: LiveData<List<Missions>>
    get() = _missions
}