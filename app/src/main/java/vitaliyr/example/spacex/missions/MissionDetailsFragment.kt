package vitaliyr.example.spacex.missions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vitaliyr.example.spacex.R
import vitaliyr.example.spacex.databinding.FragmentMissionsDetailsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [MissionDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MissionDetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding: FragmentMissionsDetailsBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_missions_details, container, false)

        binding.lifecycleOwner = this

        val mission = MissionDetailsFragmentArgs.fromBundle(requireArguments()).selectedMission

        val viewModelFactory = MissionDetailsVMFactory(mission, application)

        binding.viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MissionsDetailsViewModel::class.java)


        return binding.root
    }

}