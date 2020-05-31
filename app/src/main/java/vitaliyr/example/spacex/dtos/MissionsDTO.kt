package vitaliyr.example.spacex.dtos

data class Missions(var array : List<MissionsDTO>){

}

data class MissionsDTO(var mission_name: String,
                       var mission_id: String,
                       var manufacturers: List<String>,
                       var payloadIds: List<String>,
                       var links: MissionLinks,
                       var description: String){
}

data class MissionLinks(var wikipedia: String,
                        var website: String,
                        var twitter: String){
}