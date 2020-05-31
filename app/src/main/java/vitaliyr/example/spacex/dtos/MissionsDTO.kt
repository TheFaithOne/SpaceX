package vitaliyr.example.spacex.dtos

import com.squareup.moshi.Json


data class MissionsDTO(var mission_name: String,
                       @Json(name = "mission_id")var missionId: String,
                       var manufacturers: List<String>,
                       @Json(name = "payload_ids")var payloadIds: List<String>,
                       var wikipedia: String? ="",
                       var website: String?= "",
                       var twitter: String? = "",
                       var description: String){
}