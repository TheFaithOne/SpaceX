package vitaliyr.example.spacex.missions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import vitaliyr.example.spacex.R
import vitaliyr.example.spacex.databinding.FragmentMissionsScreenBinding


/**
 * A simple [Fragment] subclass.
 * Use the [MissionsScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MissionsScreenFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding: FragmentMissionsScreenBinding = DataBindingUtil
           .inflate(inflater, R.layout.fragment_missions_screen, container, false)

        val viewModel = MissionsScreenViewModel()

        viewModel.getMissions()

        val adapter = MissionsAdapter(MissionListener { missionId ->
            viewModel.onMissionClicked(missionId)
        })
        binding.missionsList.adapter = adapter

        viewModel.navigateToMissionDetails.observe(viewLifecycleOwner, Observer {missionId ->
            missionId?.let {
                this.findNavController().navigate(R.id.action_missionsScreenFragment_to_missions_details)
            }
        })

        viewModel.missions.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }

}