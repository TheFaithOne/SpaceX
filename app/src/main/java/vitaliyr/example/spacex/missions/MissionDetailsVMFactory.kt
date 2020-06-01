package vitaliyr.example.spacex.missions

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vitaliyr.example.spacex.dtos.MissionsDTO

class MissionDetailsVMFactory(
    private val mission: MissionsDTO,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MissionsDetailsViewModel::class.java)) {
            return MissionsDetailsViewModel(mission, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}