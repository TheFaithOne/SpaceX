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

    fun getMissions(){
        val service = RetrofitClientInstance.retrofitInstance?.create(GetJsonData::class.java)
        val call = service?.getMissions()?.enqueue(object: Callback<List<MissionsDTO>>{
            override fun onFailure(call: Call<List<MissionsDTO>>, t: Throwable) {
                val downloadFailed = "Failed to download missions: ${t.message}"
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

    private val _navigateToMissionDetails = MutableLiveData<String>()
    val navigateToMissionDetails: LiveData<String>
    get() = _navigateToMissionDetails

    fun onMissionClicked(id: String){
        _navigateToMissionDetails.value = id
    }

    fun onMissionDetailsNavigated(){
        _navigateToMissionDetails.value = null
    }
}