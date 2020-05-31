package vitaliyr.example.spacex

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import vitaliyr.example.spacex.dtos.CompanyInfo
import vitaliyr.example.spacex.dtos.MissionsDTO

object RetrofitClientInstance {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://api.spacexdata.com/v3/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    //Creating retrofit instance only if it has not been created yet
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build()
            }

            return retrofit
        }

}

interface GetJsonData {

    @GET("info")
    fun getCompanyInfo(): retrofit2.Call<CompanyInfo>

    @GET("missions")
    fun getMissions(): retrofit2.Call<List<MissionsDTO>>
}