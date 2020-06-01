package vitaliyr.example.spacex.cores

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vitaliyr.example.spacex.CoreFilter
import vitaliyr.example.spacex.GetJsonData
import vitaliyr.example.spacex.RetrofitClientInstance
import vitaliyr.example.spacex.dtos.CoresDTO

class CoresViewModel : ViewModel() {
    private val _core = MutableLiveData<List<CoresDTO>>()
    val core: LiveData<List<CoresDTO>>
        get() = _core

    private val _downloadFailed = MutableLiveData<String>()
    val downloadFailed: LiveData<String>
    get() = _downloadFailed

    init {
        getCores(CoreFilter.SHOW_ALL)
    }
     fun getCores(filter: CoreFilter) {
        val service = RetrofitClientInstance.retrofitInstance?.create(GetJsonData::class.java)
        service?.getActiveCores(filter.value)?.enqueue(object : Callback<List<CoresDTO>> {
            override fun onFailure(call: Call<List<CoresDTO>>, t: Throwable) {
                 _downloadFailed.value = "Failed to download JSON ${t.message}"
                Log.d("CoresViewModel", "Failed to download cores: ${t.message}")
            }

            override fun onResponse(
                call: Call<List<CoresDTO>>,
                response: Response<List<CoresDTO>>
            ) {
                val body = response.body()
                _core.value = body
                Log.d("CoresViewModel", "Value of core is: ${core.value}")
            }
        })
    }

     fun getLandedCores(filter: CoreFilter){
        val service = RetrofitClientInstance.retrofitInstance?.create(GetJsonData::class.java)
        service?.getLandedCores(filter.value)?.enqueue(object : Callback<List<CoresDTO>> {
            override fun onFailure(call: Call<List<CoresDTO>>, t: Throwable) {
                val downloadFailed = "Failed to download JSON ${t.message}"
                Log.d("CoresViewModel", "Failed to download cores: ${t.message}")
            }

            override fun onResponse(
                call: Call<List<CoresDTO>>,
                response: Response<List<CoresDTO>>
            ) {
                val body = response.body()
                _core.value = body
                Log.d("CoresViewModel", "Value of core is: ${core.value}")
            }
        })
    }

//    fun updateFilter(filter: CoreFilter){
//            getCores(filter)
//    }
}