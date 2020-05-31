package vitaliyr.example.spacex.dtos

data class CompanyInfo(var name: String, var founder: String, var founded: String, var employees: Int,
                       var vehicles: Int, var launch_sites: Int, var test_sites: Int, var ceo: String,
                       var cto: String, var coo: String, var cto_propulsion: String, var valuation: Long,
                       var headquarters: Headquarters, var links: Links, val summary: String) {
}

data class Headquarters(var address: String, var city: String, var state:String)

data class Links (var website: String, var flickr: String, var twitter: String, var elon_twitter: String){
    override fun toString(): String {
        return "Website: $website \nFlickr: $flickr \nTwitter: $twitter \nElon's Twitter: $elon_twitter"

    }
}