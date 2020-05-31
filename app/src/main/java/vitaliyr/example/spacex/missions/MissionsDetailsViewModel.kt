package vitaliyr.example.spacex.missions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vitaliyr.example.spacex.dtos.MissionsDTO

class MissionsDetailsViewModel(mission: MissionsDTO, app: Application): AndroidViewModel(app) {

    private val _selectedMission = MutableLiveData<MissionsDTO>()

    val selectedMission: LiveData<MissionsDTO>
    get() = _selectedMission

    init {
        _selectedMission.value = mission
    }
}