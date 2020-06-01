package vitaliyr.example.spacex.missions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vitaliyr.example.spacex.GetJsonData
import vitaliyr.example.spacex.RetrofitClientInstance
import vitaliyr.example.spacex.dtos.MissionsDTO

class MissionsScreenViewModel: ViewModel() {
    private val _missions = MutableLiveData<List<MissionsDTO>>()
    val missions: LiveData<List<MissionsDTO>>
    get() = _missions

    private val _downloadFailed = MutableLiveData<String>()
    val downloadFailed: LiveData<String>
        get() = _downloadFailed

    fun getMissions(){
        val service = RetrofitClientInstance.retrofitInstance?.create(GetJsonData::class.java)
        val call = service?.getMissions()?.enqueue(object: Callback<List<MissionsDTO>>{
            override fun onFailure(call: Call<List<MissionsDTO>>, t: Throwable) {
                _downloadFailed.value = "Failed to download missions: ${t.message}"
                Log.d("MissionsScreenViewModel", "failed to downbload ${t.message}")
            }

            override fun onResponse(
                call: Call<List<MissionsDTO>>,
                response: Response<List<MissionsDTO>>
            ) {
                val body = response.body()
               _missions.value = body
                Log.d("QWERTY", "value of missons is: ${missions.value}")
            }
        }
         )
    }

    private val _navigateToMissionDetails = MutableLiveData<MissionsDTO>()
    val navigateToMissionDetails: LiveData<MissionsDTO>
    get() = _navigateToMissionDetails

    fun onMissionClicked(selectedMission: MissionsDTO){
        _navigateToMissionDetails.value = selectedMission
    }

    //Clearing LiveData object to avoid being redirected back to the details
    //after coming back to the missions list
    fun onMissionDetailsNavigated(){
        _navigateToMissionDetails.value = null
    }
}