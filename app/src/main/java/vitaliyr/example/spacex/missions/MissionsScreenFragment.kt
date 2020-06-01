package vitaliyr.example.spacex.missions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding: FragmentMissionsScreenBinding = DataBindingUtil
           .inflate(inflater, R.layout.fragment_missions_screen, container, false)

        val viewModel = MissionsScreenViewModel()

        viewModel.getMissions()

        val adapter = MissionsAdapter(OnClickListener { mission ->
            viewModel.onMissionClicked(mission)
        })
        binding.missionsList.adapter = adapter

        viewModel.navigateToMissionDetails.observe(viewLifecycleOwner, Observer {
            if(it != null){
                this.findNavController().navigate(MissionsScreenFragmentDirections
                    .actionMissionsScreenFragmentToMissionsDetails(it))
                viewModel.onMissionDetailsNavigated()
            }
        })

        viewModel.missions.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        viewModel.downloadFailed.observe(viewLifecycleOwner, Observer {
            if(it != null){
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })

        return binding.root
    }

}