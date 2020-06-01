package vitaliyr.example.spacex.dtos

import com.squareup.moshi.Json

data class CoresDTO(@Json(name="core_serial") var coreSerial: String,
                    var block: String?,
                    var status: String,
                    @Json(name="original_launch")var originalLaunch: String,
                    @Json(name="original_launch_unix")var originalLaunchUnix: Long,
                    var missions: List<CoreMissions>,
                    @Json(name="reuse_count")var reuseCount: Int,
                    @Json(name="rtls_attempts")var rtlsAttempts: Int,
                    @Json(name="rtls_landings")var rtlsLandings: Int,
                    @Json(name="asds_attempts")var asdsAttempts: Int,
                    @Json(name="asds_landings") var asdsLandings: Int,
                    @Json(name="water_landing")var waterLanding: Boolean,
                    var details: String?
                    ) {
}

data class CoreMissions(var name: String,
                        var flight: Int)