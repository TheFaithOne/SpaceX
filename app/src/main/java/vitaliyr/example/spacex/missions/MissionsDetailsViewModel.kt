package vitaliyr.example.spacex.missions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import vitaliyr.example.spacex.R
import vitaliyr.example.spacex.dtos.MissionsDTO

class MissionsDetailsViewModel(mission: MissionsDTO, app: Application): AndroidViewModel(app) {

    private val _selectedMission = MutableLiveData<MissionsDTO>()
    val selectedMission: LiveData<MissionsDTO>
    get() = _selectedMission

    init {
        _selectedMission.value = mission
    }

    val displayName = Transformations.map(selectedMission){
        app.applicationContext.getString(R.string.mission_details_name, selectedMission.value?.mission_name)
    }

    val displayId = Transformations.map(selectedMission){
        app.applicationContext.getString(R.string.missions_details_id, selectedMission.value?.missionId)
    }

    val dislpayManufacturers = Transformations.map(selectedMission){
        app.applicationContext.getString(R.string.mission_details_manufacturers, selectedMission.value?.manufacturers)
    }

    val displayPayloadIds = Transformations.map(selectedMission){
        app.applicationContext.getString(R.string.mission_details_payloadIds, selectedMission.value?.payloadIds)
    }

    val wikiLink = Transformations.map(selectedMission){
        app.applicationContext.getString(R.string.mission_details_wikipedia, selectedMission.value?.wikipedia)
    }

    val websiteLink = Transformations.map(selectedMission){
        app.applicationContext.getString(R.string.mission_details_website, selectedMission.value?.website)
    }

    val twitterLink = Transformations.map(selectedMission){
        app.applicationContext.getString(R.string.mission_details_twitter, if(it.twitter != null){
            selectedMission.value?.twitter
        } else{
            ""
        })
    }

    val displayDescription = Transformations.map(selectedMission){
        app.applicationContext.getString(R.string.mission_details_description, selectedMission.value?.description)
    }

}