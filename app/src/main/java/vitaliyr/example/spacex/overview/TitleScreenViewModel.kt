package vitaliyr.example.spacex.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vitaliyr.example.spacex.GetJsonData
import vitaliyr.example.spacex.RetrofitClientInstance
import vitaliyr.example.spacex.dtos.CompanyInfo

class TitleScreenViewModel : ViewModel() {


    private val _companyInfo = MutableLiveData<CompanyInfo>()
    val companyInfo: LiveData<CompanyInfo>
        get() = _companyInfo



     fun getCompanyInfo() {
         val service =
            RetrofitClientInstance.retrofitInstance?.create(GetJsonData::class.java)
        val call = service?.getCompanyInfo()?.enqueue(object : Callback<CompanyInfo> {
            override fun onFailure(call: Call<CompanyInfo>, t: Throwable) {
                val downloadFail = t.message
            }

            override fun onResponse(call: Call<CompanyInfo>, response: Response<CompanyInfo>) {
                val body = response.body()
                _companyInfo.value = body
            }
        })
    }

}