package vitaliyr.example.spacex.missions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import vitaliyr.example.spacex.R
import vitaliyr.example.spacex.databinding.FragmentMissionsDetailsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [Missions_details.newInstance] factory method to
 * create an instance of this fragment.
 */
class Missions_details : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMissionsDetailsBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_missions_details, container, false)

        val viewModel = MissionsScreenViewModel()

        viewModel.missions.observe(viewLifecycleOwner, Observer {
           it?.let {
               binding.missionName.text
           }
        })

        return binding.root
    }

}