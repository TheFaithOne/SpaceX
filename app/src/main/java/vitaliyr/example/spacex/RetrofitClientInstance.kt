package vitaliyr.example.spacex

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import vitaliyr.example.spacex.dtos.CompanyInfo
import vitaliyr.example.spacex.dtos.CoresDTO
import vitaliyr.example.spacex.dtos.MissionsDTO

enum class CoreFilter(val value: String) {
    SHOW_ALL(""),
    SHOW_ACTIVE("active"),
    SHOW_LANDED("true")}
object RetrofitClientInstance {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://api.spacexdata.com/v3/"

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

    @GET("cores")
    fun getActiveCores(@Query("status") type: String): retrofit2.Call<List<CoresDTO>>

    @GET("cores")
    fun getLandedCores(@Query("water_landing") type: String): retrofit2.Call<List<CoresDTO>>
}